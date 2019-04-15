package com.my.scaffold.excel;

import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFClientAnchor;
import org.apache.poi.xssf.usermodel.XSSFRichTextString;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;

/**
 * excel导出工具
 * 1. 根据自定义实体导出，使用@ExcelField注解
 * 2. 一次实例化只能导出一张excel表，但其中可包含多个sheet表
 * @Description
 * @Author xiaohu
 * @Date 2018/12/18 10:09
 */
public class ExportExcel {

    private static Logger log = LoggerFactory.getLogger(ExportExcel.class);

    /**
     * 工作薄对象:
     * SXSSFWorkbook 可设置rowAccessWindowSize。
     * 设置内存窗口大小，设置能从Sheet窗口看到多少刚刚Create了多少ROW；设置为-1则能看到全部创建的数据
     */
    private SXSSFWorkbook wb;

    /**
     * 工作表对象map : sheet表名，工作表对象
     */
    private Map<String,SXSSFSheet> sheetMap = new HashMap<>();

    /**
     *工作表中注解列表：sheet表名，注解列表
     */
    private Map<String,List<Object[]>> annotationMap = new HashMap<>();

    /**
     * 工作表中当前行数：sheet表名，当前行数
     */
    private Map<String,Integer> rownNumMap = new HashMap<>();

    /**
     * 统一样式列表
     */
    private Map<String, CellStyle> styles;

    /**
     * 构造函数
     * @param sheetName 工作表sheet名
     * @param title 表格标题，传“空值”，表示无标题；一般默认表格第一行合并为一个单元格，存放标题
     * @param cls 实体对象，通过annotation.ExportField获取标题
     */
    public ExportExcel(String sheetName,String title, Class<?> cls){
        this(sheetName,title, cls, 1);
    }

    /**
     * 构造函数
     * @param sheetName 工作表sheet名
     * @param title 表格标题，传“空值”，表示无标题；一般默认表格第一行合并为一个单元格，存放标题
     * @param cls 实体对象，通过annotation.ExportField获取标题，作为列名
     * @param type 导出类型（1:导出数据；2：导出模板）
     * @param groups 导入分组
     */
    public ExportExcel(String sheetName,String title, Class<?> cls, int type, int... groups){
        List<String> headerList = getHeaderList(sheetName,cls,type,groups);
        initialize(sheetName,title, headerList);
    }

    /**
     * 构造函数
     * @param sheetName 工作表sheet名
     * @param title 表格标题，传“空值”，表示无标题
     * @param headers 表头数组
     */
    public ExportExcel(String sheetName,String title, String[] headers) {
        initialize(sheetName,title, Lists.newArrayList(headers));
    }

    /**
     * 构造函数
     * @param sheetName 工作表sheet名
     * @param title 表格标题，传“空值”，表示无标题
     * @param headerList 表头列表
     */
    public ExportExcel(String sheetName,String title, List<String> headerList) {
        initialize(sheetName,title, headerList);
    }

    /**
     * 在现有工作薄中创建新的sheet工作表
     * @param sheetName 工作表sheet名
     * @param title 表格标题，传“空值”，表示无标题；一般默认表格第一行合并为一个单元格，存放标题
     * @param cls 实体对象，通过annotation.ExportField获取标题
     */
    public void creatSheetInit(String sheetName,String title, Class<?> cls){
        List<String> headerList = getHeaderList(sheetName,cls,1);
        initialize(sheetName,title,headerList);
    }

    /**
     * 获取并设置指定工作表的列名列表+列名注解列表
     * @param cls 实体对象，通过annotation.ExportField获取标题
     * @param type  导出类型（1:导出数据；2：导出模板）
     * @param groups 导入分组
     * @return
     */
    public List<String> getHeaderList(String sheetName,Class<?> cls, int type, int... groups){
        List<Object[]> annotationList = Lists.newArrayList();
        // Get annotation field
        Field[] fs = cls.getDeclaredFields();
        for (Field f : fs){
            ExcelField ef = f.getAnnotation(ExcelField.class);
            if (ef != null && (ef.type()==0 || ef.type()==type)){
                if (groups!=null && groups.length>0){
                    boolean inGroup = false;
                    for (int g : groups){
                        if (inGroup){
                            break;
                        }
                        for (int efg : ef.groups()){
                            if (g == efg){
                                inGroup = true;
                                annotationList.add(new Object[]{ef, f});
                                break;
                            }
                        }
                    }
                }else{
                    annotationList.add(new Object[]{ef, f});
                }
            }
        }
        // Get annotation method
        Method[] ms = cls.getDeclaredMethods();
        for (Method m : ms){
            ExcelField ef = m.getAnnotation(ExcelField.class);
            if (ef != null && (ef.type()==0 || ef.type()==type)){
                if (groups!=null && groups.length>0){
                    boolean inGroup = false;
                    for (int g : groups){
                        if (inGroup){
                            break;
                        }
                        for (int efg : ef.groups()){
                            if (g == efg){
                                inGroup = true;
                                annotationList.add(new Object[]{ef, m});
                                break;
                            }
                        }
                    }
                }else{
                    annotationList.add(new Object[]{ef, m});
                }
            }
        }
        // Field sorting
        Collections.sort(annotationList, new Comparator<Object[]>() {
            @Override
            public int compare(Object[] o1, Object[] o2) {
                return new Integer(((ExcelField)o1[0]).sort()).compareTo(
                        new Integer(((ExcelField)o2[0]).sort()));
            };
        });
        // Initialize
        List<String> headerList = Lists.newArrayList();
        for (Object[] os : annotationList){
            String t = ((ExcelField)os[0]).title();
            // 如果是导出，则去掉注释
            if (type==1){
                String[] ss = StringUtils.split(t, "**", 2);
                if (ss.length==2){
                    t = ss[0];
                }
            }
            headerList.add(t);
        }
        // 存放各个sheet表中：注解列表（列名列表）
        this.annotationMap.put(sheetName,annotationList);
        return headerList;
    }

    /**
     * 初始化指定工作薄：
     * 1. 根据需要创建工作簿，工作表对象
     * 2. 为指定工作表对象初始化：设置标题，列名
     * @param sheetName 工作表sheet名
     * @param title 表格标题，传“空值”，表示无标题；一般默认表格第一行合并为一个单元格，存放标题
     * @param headerList 表头列表：列名
     */
    private void initialize(String sheetName,String title, List<String> headerList) {
        if (this.wb == null){
            //第一次调用时，新建工作簿对象
            this.wb = new SXSSFWorkbook(500);
            //生成该工作薄的样式
            this.styles = createStyles(wb);
        }
        SXSSFSheet sheet = this.sheetMap.get(sheetName);
        if (sheet == null){
            //若指定工作表不存在，则新建
            sheet = this.wb.createSheet(sheetName);
        }
        Integer rownum = this.rownNumMap.get(sheetName);
        if (rownum == null){
            //若指定工作表当前行数不存在，则新建
            rownum = 0;
        }
        // Create title
        if (StringUtils.isNotBlank(title)){
            Row titleRow = sheet.createRow(rownum++);
            titleRow.setHeightInPoints(30);
            Cell titleCell = titleRow.createCell(0);
            titleCell.setCellStyle(styles.get("title"));
            titleCell.setCellValue(title);
            sheet.addMergedRegion(new CellRangeAddress(titleRow.getRowNum(),
                    titleRow.getRowNum(), titleRow.getRowNum(), headerList.size()-1));
        }
        // Create header
        if (headerList == null){
            throw new RuntimeException("headerList not null!");
        }
        Row headerRow = sheet.createRow(rownum++);
        headerRow.setHeightInPoints(16);
        for (int i = 0; i < headerList.size(); i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellStyle(styles.get("header"));
            String[] ss = StringUtils.split(headerList.get(i), "**", 2);
            if (ss.length==2){
                cell.setCellValue(ss[0]);
                Comment comment = sheet.createDrawingPatriarch().createCellComment(
                        new XSSFClientAnchor(0, 0, 0, 0, (short) 3, 3, (short) 5, 6));
                comment.setString(new XSSFRichTextString(ss[1]));
                cell.setCellComment(comment);
            }else{
                cell.setCellValue(headerList.get(i));
            }
            sheet.trackAllColumnsForAutoSizing();
            sheet.autoSizeColumn(i);
        }
        for (int i = 0; i < headerList.size(); i++) {
            int colWidth = sheet.getColumnWidth(i)*2;
            sheet.setColumnWidth(i, colWidth < 3000 ? 3000 : colWidth);
        }
        this.sheetMap.put(sheetName,sheet);
        this.rownNumMap.put(sheetName,rownum);
        log.debug("Initialize success.");
    }

    /**
     * 创建表格样式
     * @param wb 工作薄对象
     * @return 样式列表
     */
    private Map<String, CellStyle> createStyles(Workbook wb) {
        Map<String, CellStyle> styles = new HashMap<String, CellStyle>();

        CellStyle style = wb.createCellStyle();
        style.setAlignment(HorizontalAlignment.CENTER);
        style.setVerticalAlignment(VerticalAlignment.CENTER);
        Font titleFont = wb.createFont();
        titleFont.setFontName("Arial");
        titleFont.setFontHeightInPoints((short) 16);
        titleFont.setBold(true);
        style.setFont(titleFont);
        styles.put("title", style);

        style = wb.createCellStyle();
        style.setVerticalAlignment(VerticalAlignment.CENTER);
        style.setBorderRight(BorderStyle.THIN);
        style.setRightBorderColor(IndexedColors.GREY_50_PERCENT.getIndex());
        style.setBorderLeft(BorderStyle.THIN);
        style.setLeftBorderColor(IndexedColors.GREY_50_PERCENT.getIndex());
        style.setBorderTop(BorderStyle.THIN);
        style.setTopBorderColor(IndexedColors.GREY_50_PERCENT.getIndex());
        style.setBorderBottom(BorderStyle.THIN);
        style.setBottomBorderColor(IndexedColors.GREY_50_PERCENT.getIndex());
        Font dataFont = wb.createFont();
        dataFont.setFontName("Arial");
        dataFont.setFontHeightInPoints((short) 10);
        style.setFont(dataFont);
        styles.put("data", style);

        style = wb.createCellStyle();
        style.cloneStyleFrom(styles.get("data"));
        style.setAlignment(HorizontalAlignment.CENTER);
        styles.put("data1", style);

        style = wb.createCellStyle();
        style.cloneStyleFrom(styles.get("data"));
        style.setAlignment(HorizontalAlignment.CENTER);
        styles.put("data2", style);

        style = wb.createCellStyle();
        style.cloneStyleFrom(styles.get("data"));
        style.setAlignment(HorizontalAlignment.CENTER);
        styles.put("data3", style);

        style = wb.createCellStyle();
        style.cloneStyleFrom(styles.get("data"));
        style.setAlignment(HorizontalAlignment.CENTER);
        style.setFillForegroundColor(IndexedColors.GREY_50_PERCENT.getIndex());
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        Font headerFont = wb.createFont();
        headerFont.setFontName("Arial");
        headerFont.setFontHeightInPoints((short) 10);
        titleFont.setBold(true);
        headerFont.setColor(IndexedColors.WHITE.getIndex());
        style.setFont(headerFont);
        styles.put("header", style);

        return styles;
    }

    /**
     * 在指定工作表中添加一行
     * @param sheetName 工作表sheet名
     * @return 行对象
     */
    public Row addRow(String sheetName){
        SXSSFSheet sheet = this.sheetMap.get(sheetName);
        if (sheet == null){
            throw new RuntimeException("指定工作表："+sheetName+"不存在");
        }
        Integer rownum = this.rownNumMap.get(sheetName);
        if (rownum == null){
            throw new RuntimeException("指定工作表："+sheetName+"当前行数不存在");
        }
        this.sheetMap.put(sheetName,sheet);
        this.rownNumMap.put(sheetName,rownum);
        return sheet.createRow(rownum++);

    }

    /**
     * 添加数据（通过annotation.ExportField添加数据）
     * 向指定工作表中添加数据
     * @param sheetName 工作表sheet名
     * @return list 数据列表
     */
    public <E> ExportExcel setDataListBySheetName(String sheetName,List<E> list){
        List<Object[]> annotationList = this.annotationMap.get(sheetName);
        if (annotationList == null){
            throw new RuntimeException("指定工作表："+sheetName+"的列名注解列表不存");
        }
        //一个对象一行，循环增加行数，数据
        for (E e : list){
            int colunm = 0;
            Row row = this.addRow(sheetName);
            StringBuilder sb = new StringBuilder();
            for (Object[] os : annotationList){
                ExcelField ef = (ExcelField)os[0];
                Object val = null;
                // Get entity value
                try{
                    if (StringUtils.isNotBlank(ef.value())){
                        val = Reflections.invokeGetter(e, ef.value());
                    }else{
                        if (os[1] instanceof Field){
                            //通过反射获得该对象指定属性值
                            val = Reflections.invokeGetter(e, ((Field)os[1]).getName());
                        }else if (os[1] instanceof Method){
                            val = Reflections.invokeMethod(e, ((Method)os[1]).getName(), new Class[] {}, new Object[] {});
                        }
                    }
                    // If is dict, get dict label
//                    if (StringUtils.isNotBlank(ef.dictType())){
//                        val = DictUtils.getDictLabel(val==null?"":val.toString(), ef.dictType(), "");
//                    }
                }catch(Exception ex) {
                    // Failure to ignore
                    log.info(ex.toString());
                    val = "";
                }
                this.addCell(row, colunm++, val, ef.align(), ef.fieldType());
                sb.append(val + ", ");
            }
            log.debug("Write success: ["+row.getRowNum()+"] "+sb.toString());
        }
        return this;
    }

    /**
     * 添加一个单元格
     * @param row 添加的行
     * @param column 添加列号
     * @param val 添加值
     * @param align 对齐方式（1：靠左；2：居中；3：靠右）
     * @return 单元格对象
     */
    public Cell addCell(Row row, int column, Object val, int align, Class<?> fieldType){
        Cell cell = row.createCell(column);
        String cellFormatString = "@";
        try {
            if(val == null){
                cell.setCellValue("");
            }else if(fieldType != Class.class){
                cell.setCellValue((String)fieldType.getMethod("setValue", Object.class).invoke(null, val));
            }else{
                if(val instanceof String) {
                    cell.setCellValue((String) val);
                }else if(val instanceof Integer) {
                    cell.setCellValue((Integer) val);
                    cellFormatString = "0";
                }else if(val instanceof Long) {
                    cell.setCellValue((Long) val);
                    cellFormatString = "0";
                }else if(val instanceof Double) {
                    cell.setCellValue((Double) val);
                    cellFormatString = "0.00";
                }else if(val instanceof Float) {
                    cell.setCellValue((Float) val);
                    cellFormatString = "0.00";
                }else if(val instanceof Date) {
                    cell.setCellValue((Date) val);
                    cellFormatString = "yyyy-MM-dd HH:mm:ss";
                }else {
                    cell.setCellValue((String)Class.forName(this.getClass().getName().replaceAll(this.getClass().getSimpleName(),
                            "fieldtype."+val.getClass().getSimpleName()+"Type")).getMethod("setValue", Object.class).invoke(null, val));
                }
            }
            if (val != null){
                CellStyle style = styles.get("data_column_"+column);
                if (style == null){
                    style = wb.createCellStyle();
                    style.cloneStyleFrom(styles.get("data"+(align>=1&&align<=3?align:"")));
                    style.setDataFormat(wb.createDataFormat().getFormat(cellFormatString));
                    styles.put("data_column_" + column, style);
                }
                cell.setCellStyle(style);
            }
        } catch (Exception ex) {
            log.info("Set cell value ["+row.getRowNum()+","+column+"] error: " + ex.toString());
            cell.setCellValue(val.toString());
        }
        return cell;
    }

    /**
     * 输出到客户端
     * @param fileName 输出文件名
     */
    public ExportExcel write(HttpServletResponse response, String fileName) throws IOException {
        response.reset();
        response.setContentType("application/octet-stream; charset=utf-8");
        response.setHeader("Content-Disposition", "attachment; filename="+new String( fileName.getBytes("gb2312"), "ISO8859-1" ));
        write(response.getOutputStream());
        return this;
    }

    /**
     * 输出数据流
     * @param os 输出数据流
     */
    public ExportExcel write(OutputStream os) throws IOException{
        wb.write(os);
        return this;
    }

    /**
     * 输出到文件
     * @param name 输出文件名
     */
    public ExportExcel writeFile(String name) throws FileNotFoundException, IOException{
        FileOutputStream os = new FileOutputStream(name);
        this.write(os);
        return this;
    }

    /**
     * 清理临时文件
     */
    public ExportExcel dispose(){
        wb.dispose();
        return this;
    }
}
