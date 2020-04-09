package com.my.scaffold.api;

import cn.hutool.core.util.IdUtil;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.GetObjectRequest;
import com.aliyun.oss.model.OSSObject;
import com.aliyun.oss.model.ObjectMetadata;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URL;
import java.util.Date;

/**
 * oss文件服务
 *
 * @author qiudx
 */
@Component
public class AliyunOSSClient {
    private static Logger logger = LogManager.getLogger(AliyunOSSClient.class);

    private static OSSClient ossClient;
    @Value("${oss.endpoint}")
    private String endpoint;
    @Value("${oss.access_key_id}")
    private String accessKeyId;
    @Value("${oss.access_key_secret}")
    private String accessKeySecret;
    @Value("${oss.backet_name}")
    private String backetName;
    @Value("${oss.folder}")
    private String folder;
    @Value("${oss.templateFolder}")
    private String templateFolder;

    @PostConstruct
    public void init() {
        //初始化OSSClient
        ossClient = getOSSClient();
    }


    /**
     * 获取阿里云OSS客户端对象
     *
     * @return ossClient
     */
    private OSSClient getOSSClient() {
        return new OSSClient(endpoint, accessKeyId, accessKeySecret);
    }

    /**
     * 根据key删除OSS服务器上的文件
     *
     * @param bucketName 存储空间
     * @param folder     模拟文件夹名 如"qj_nanjing/"
     * @param key        Bucket下的文件的路径名+文件名 如："upload/cake.jpg"
     */
    public static void deleteFile(String bucketName, String folder, String key) {
        ossClient.deleteObject(bucketName, folder + key);
        logger.info("删除" + bucketName + "下的文件" + folder + key + "成功");
    }

    /**
     * 上传文件到oss
     * @param file
     * @return
     * @throws IOException
     */
    public String imageUpload(MultipartFile file) throws IOException {
        if (file == null) {
            return "";
        }
        String uuid = IdUtil.simpleUUID();
        String filename = folder + "/" + uuid;
        //创建上传object的metadata
        ObjectMetadata metadata = new ObjectMetadata();
        try (InputStream inputStream = file.getInputStream()) {
            metadata.setContentLength(inputStream.available());
            metadata.setCacheControl("no-cache");
            metadata.setHeader("Pragma", "no-cache");
            metadata.setContentEncoding("utf-8");
            metadata.setContentType(file.getContentType());
            metadata.setContentDisposition("attachment; filename=" + java.net.URLEncoder.encode(file.getOriginalFilename(), "UTF-8"));
            //上传文件
            ossClient.putObject(backetName, filename, inputStream, metadata);
        }
        //返回oss上传文件路径
        //图片域名
        String imageHost = "http://resource.toolmall.com";
        return imageHost + "/" + filename;
    }

    /**
     * 浏览器以附件形式下载oss上指定文件名的文件
     * @param fileName
     */
    public void downloadTemplate(HttpServletResponse response, String fileName){
        BufferedInputStream in = null;
        BufferedOutputStream out = null;
        try {
            //获取fileid对应的阿里云上的文件对象
            String key = templateFolder+"/"+fileName;
            OSSObject ossObject = ossClient.getObject(new GetObjectRequest(backetName,key));
            // 读去Object内容  返回
            in=new BufferedInputStream(ossObject.getObjectContent());
            out=new BufferedOutputStream(response.getOutputStream());
            //通知浏览器以附件形式下载
            response.setHeader("content-type", "application/octet-stream");
            response.setContentType("application/octet-stream");
            try {
                String name = java.net.URLEncoder.encode(fileName, "UTF-8");
                response.setHeader("Content-Disposition", "attachment;filename=" + java.net.URLDecoder.decode(name, "ISO-8859-1") );
            } catch (UnsupportedEncodingException e2) {
                e2.printStackTrace();
                System.out.println("文件名设置错误");
            }
            byte[] car=new byte[1024];
            int L=0;
            while((L=in.read(car))!=-1){
                out.write(car, 0,L);
            }
            if(out!=null){
                out.flush();
                out.close();
            }
            if(in!=null){
                in.close();
            }
            response.getOutputStream().flush();
            response.getOutputStream().close();
            ossObject.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("系统找不到指定的文件");
        }finally {
            try{
                if(out!=null){
                    out.flush();
                    out.close();
                }
                if(in!=null){
                    in.close();
                }
            }catch (IOException e){
                System.out.println("系统找不到指定的文件,且关闭流失败");
            }

        }

    }

    /**
     * 上传图片至OSS
     *
     * @param file       上传文件（文件全路径如：D:\\image\\cake.jpg）
     * @param bucketName 存储空间
     * @param folder     模拟文件夹名 如"qj_nanjing/"
     * @return String 返回的唯一MD5数字签名
     */
    public String uploadObject2OSS(File file, String bucketName, String folder) {
        String resultStr = null;
        try {
            //以输入流的形式上传文件
            String fileName;
            try (InputStream is = new FileInputStream(file)) {
                //文件名
                fileName = file.getName();
                //文件大小
                long fileSize = file.length();
                //创建上传Object的Metadata
                ObjectMetadata metadata = new ObjectMetadata();
                //上传的文件的长度
                metadata.setContentLength(is.available());
                //指定该Object被下载时的网页的缓存行为
                metadata.setCacheControl("no-cache");
                //指定该Object下设置Header
                metadata.setHeader("Pragma", "no-cache");
                //指定该Object被下载时的内容编码格式
                metadata.setContentEncoding("utf-8");
                //文件的MIME，定义文件的类型及网页编码，决定浏览器将以什么形式、什么编码读取文件。如果用户没有指定则根据Key或文件名的扩展名生成，
                //如果没有扩展名则填默认值application/octet-stream
                metadata.setContentType(getContentType(fileName));
                //指定该Object被下载时的名称（指示MINME用户代理如何显示附加的文件，打开或下载，及文件名称）
                metadata.setContentDisposition("filename/filesize=" + fileName + "/" + fileSize + "Byte.");
                //上传文件   (上传文件流的形式)
                ossClient.putObject(bucketName, folder + "/" + fileName, is, metadata);
            }
            //返回oss上传文件路径
            //图片域名
            String imageHost = "http://resource.toolmall.com";
            resultStr = imageHost + "/" + folder + "/" + fileName;
        } catch (Exception e) {
            logger.error("上传阿里云OSS服务器异常." + e.getMessage(), e);
        }
        return resultStr;
    }

    /**
     * 上传文件
     * @param file
     * @param fileName
     * @return
     */
    public String upload(MultipartFile file, String fileName){
        String resultStr = null;
        try {
            //以输入流的形式上传文件
            try (InputStream is = file.getInputStream()) {
                //文件大小
                long fileSize = file.getSize();
                //创建上传Object的Metadata
                ObjectMetadata metadata = new ObjectMetadata();
                //上传的文件的长度
                metadata.setContentLength(is.available());
                //指定该Object被下载时的网页的缓存行为
                metadata.setCacheControl("no-cache");
                //指定该Object下设置Header
                metadata.setHeader("Pragma", "no-cache");
                //指定该Object被下载时的内容编码格式
                metadata.setContentEncoding("utf-8");
                //文件的MIME，定义文件的类型及网页编码，决定浏览器将以什么形式、什么编码读取文件。如果用户没有指定则根据Key或文件名的扩展名生成，
                //如果没有扩展名则填默认值application/octet-stream
                metadata.setContentType(getContentType(fileName));
                //指定该Object被下载时的名称（指示MINME用户代理如何显示附加的文件，打开或下载，及文件名称）
                metadata.setContentDisposition("filename/filesize=" + fileName + "/" + fileSize + "Byte.");
                //上传文件   (上传文件流的形式)
                ossClient.putObject(backetName, folder + "/" + fileName, is, metadata);
            }
            //返回oss上传文件路径
            //图片域名
            String host = "https://scaffold.oss-cn-hangzhou.aliyuncs.com";
            resultStr = host + "/" + folder + "/" + fileName;
        } catch (Exception e) {
            logger.error("上传阿里云OSS服务器异常." + e.getMessage(), e);
        }
        return resultStr;
    }
    /**
     * 上传excel文件
     * @param file
     * @param bucketName
     * @param folder
     * @return
     */
    public String uploadExcelOSS(File file, String excelName,String bucketName, String folder) {
        String resultStr = null;
        try {
                //以输入流的形式上传文件
                String fileName;
                excelName = excelName +".xls";
                try (InputStream is = new FileInputStream(file)) {
                    //文件名
                    fileName = file.getName();
                    //文件大小
                    long fileSize = file.length();
                    //创建上传Object的Metadata
                    ObjectMetadata metadata = new ObjectMetadata();
                    //上传的文件的长度
                    metadata.setContentLength(is.available());
                    //指定该Object被下载时的网页的缓存行为
                    metadata.setCacheControl("no-cache");
                    //指定该Object被下载时的内容编码格式
                    metadata.setContentEncoding("utf-8");
                    //指定该Object下设置Header
                    metadata.setHeader("Pragma", "no-cache");
                    //文件的MIME，定义文件的类型及网页编码，决定浏览器将以什么形式、什么编码读取文件。如果用户没有指定则根据Key或文件名的扩展名生成，
                    //如果没有扩展名则填默认值application/octet-stream
                    metadata.setContentType(getContentType(fileName));
                    //指定该Object被下载时的名称（指示MINME用户代理如何显示附加的文件，打开或下载，及文件名称）
                    metadata.setContentDisposition("filename/filesize=" + excelName + "/" + fileSize + "Byte.");
                    //上传文件   (上传文件流的形式)
                    ossClient.putObject(bucketName, folder + "/" + excelName, is, metadata);
                }
                //返回oss上传文件路径
                String imageHost = "https://jxkj-1.oss-cn-hangzhou.aliyuncs.com";
                resultStr = imageHost + "/" + folder + "/" + excelName;

        } catch (Exception e) {
            logger.error("上传阿里云OSS服务器异常." + e.getMessage(), e);
        }
        return resultStr;
    }

    /**
     * 通过文件名判断并获取OSS服务文件上传时文件的contentType
     *
     * @param fileName 文件名
     * @return 文件的contentType
     */
    private String getContentType(String fileName) {
        //文件的后缀名
        String fileExtension = fileName.substring(fileName.lastIndexOf("."));
        if (Const.BMP.equalsIgnoreCase(fileExtension)) {
            return "image/bmp";
        }
        if (Const.GIF.equalsIgnoreCase(fileExtension)) {
            return "image/gif";
        }
        if (Const.JPEG.equalsIgnoreCase(fileExtension) || Const.JPG.equalsIgnoreCase(fileExtension) || Const.PNG.equalsIgnoreCase(fileExtension)) {
            return "image/jpeg";
        }
        if (Const.HTML.equalsIgnoreCase(fileExtension)) {
            return "text/html";
        }
        if (Const.TXT.equalsIgnoreCase(fileExtension)) {
            return "text/plain";
        }
        if (Const.VSD.equalsIgnoreCase(fileExtension)) {
            return "application/vnd.visio";
        }
        if (Const.PPT.equalsIgnoreCase(fileExtension) || Const.PPTX.equalsIgnoreCase(fileExtension)) {
            return "application/vnd.ms-powerpoint";
        }
        if (Const.DOC.equalsIgnoreCase(fileExtension) || Const.DOCX.equalsIgnoreCase(fileExtension)) {
            return "application/msword";
        }
        if (Const.XML.equalsIgnoreCase(fileExtension)) {
            return "text/xml";
        }
        if (Const.XLS.equalsIgnoreCase(fileExtension)) {
            return "application/vnd.ms-excel";
        }
        //默认返回类型
        return "image/jpeg";
    }

    /**
     * 获取图片路径
     */
    public String getImageURL(String key) {
        OSSClient client = new OSSClient(endpoint, accessKeyId, accessKeySecret);
        Date expiration = new Date(System.currentTimeMillis() + 3600 * 1000);
        URL url = client.generatePresignedUrl(backetName, key, expiration);
        return url.toString();
    }

}

