//package com.my.scaffold.controller;
//
//import com.my.scaffold.excel.ExportExcel;
//import com.my.scaffold.excelmodel.PurWithinSellStockinOrderExcelModel;
//import com.my.scaffold.excelmodel.PurWithinSellStockoutOrderExcelModel;
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.math.BigDecimal;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
///**
// * **************************************************************
// * 公司名称    :杭州巨星科技股份有限公司
// * 系统名称    :土猫网电商平台b端-Mybatis+mysql 最新架构版 v7.20
// * 类 名 称    :
// * 功能描述    :
// * 业务描述    :
// * 作 者 名    :@Author Royal(wls)
// * 开发日期    :2019/3/29 9:20
// * Created     :IntelliJ IDEA
// * **************************************************************
// * 修改日期    :
// * 修 改 者    :
// * 修改内容    :
// * **************************************************************
// */
//@Api(description = "erp内销对账单控制器")
//@Controller
//@RequestMapping("/excel")
//public class excelTest {
//
//    @ApiOperation(value = "导出",notes = "@Author wls")
//    @GetMapping("/exportOrder")
//    @ResponseBody
//    public String exportOrder(HttpServletResponse response){
//        List<PurWithinSellStockinOrderExcelModel> inList = new ArrayList<>();
//        PurWithinSellStockinOrderExcelModel inModel = new PurWithinSellStockinOrderExcelModel();
//        inModel.setSpecNo("12345567");
//        inModel.setGoodsCount(new BigDecimal(21));
//        inModel.setCostPrice(new BigDecimal(3));
//        inModel.setDiscountTax(new BigDecimal(3));
//        inModel.setTotalWithinSellAmount(new BigDecimal(54));
//        inList.add(inModel);
//
//        List<PurWithinSellStockoutOrderExcelModel> outList = new ArrayList<>();
//        PurWithinSellStockoutOrderExcelModel outModel = new PurWithinSellStockoutOrderExcelModel();
//        outModel.setSpecNo("12345567");
//        outModel.setGoodsCount(new BigDecimal(32));
//        outModel.setTotalCost(new BigDecimal(998));
//        outList.add(outModel);
//
//        String fileName = "测试表格导出.xlsx";
//        try {
//            //新建模板：设置列名
//            ExportExcel excel = new ExportExcel("工作簿1","工作簿1的标题", PurWithinSellStockinOrderExcelModel.class);
//            // 设置数据
//            excel.setDataListBySheetName("工作簿1",inList);
//
//            /*************************************
//             * 同个表中：增加sheet表
//             * 1. 标题
//             * 2. 内容
//             *************************************/
//            String sheetName = "入库单";
//            excel.creatSheetInit(sheetName,"",PurWithinSellStockoutOrderExcelModel.class);
//            excel.setDataListBySheetName(sheetName,outList);
//
//
//            //写入浏览器返回
//            excel.write(response, fileName);
//            //清除临时文件
//            excel.dispose();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//
//
//}
