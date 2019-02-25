package com.my.scaffold.enums;

/**
 * **************************************************************
 * 公司名称    :杭州巨星科技股份有限公司
 * 系统名称    :土猫网电商平台b端-Mybatis+mysql 最新架构版 v7.20
 * 类 名 称    :
 * 功能描述    : 操作类型
 * 业务描述    :
 * 作 者 名    :@Author Royal(wls)
 * 开发日期    :2019/1/29 14:19
 * Created     :IntelliJ IDEA
 * **************************************************************
 * 修改日期    :
 * 修 改 者    :
 * 修改内容    :
 * **************************************************************
 */
public enum OperationType {

    UNKNOWN("UNKNOWN","未知类型"),
    DELETE("DELETE","删除操作"),
    SELECT("SELECT","查询操作"),
    UPDATE("UPDATE","修改操作"),
    INSERT("INSERT","插入操作")
    ;

    /**
     * code
     */
    private String code;

    /**
     * message
     */
    private String message;

    OperationType(String code,String message){
        this.code = code;
        this.message = message;
    }
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
