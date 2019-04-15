package com.my.scaffold.excelmodel;

import com.my.scaffold.excel.ExcelField;

import java.math.BigDecimal;

/**
 * **************************************************************
 * 公司名称    :杭州巨星科技股份有限公司
 * 系统名称    :土猫网电商平台b端-Mybatis+mysql 最新架构版 v7.20
 * 类 名 称    :
 * 功能描述    :
 * 业务描述    :
 * 作 者 名    :@Author Royal(wls)
 * 开发日期    :2019/3/28 13:23
 * Created     :IntelliJ IDEA
 * **************************************************************
 * 修改日期    :
 * 修 改 者    :
 * 修改内容    :
 * **************************************************************
 */
public class PurWithinSellStockinOrderExcelModel {
    /**
     * 商家编码
     */
    @ExcelField(title="商家编码", align=2)
    private String specNo;
    /**
     * erp入库单号
     */
    @ExcelField(title="erp入库单号", align=2)
    private String stockinNo;

    /**
     * 货品数量
     */
    @ExcelField(title="货品数量", align=2)
    private BigDecimal goodsCount;
    /**
     * 内销折扣
     */
    @ExcelField(title="内销折扣", align=2)
    private BigDecimal discountTax;
    /**
     * 成本价
     */
    @ExcelField(title="成本价", align=2)
    private BigDecimal costPrice;
    /**
     * 售价
     */
    @ExcelField(title="售价", align=2)
    private BigDecimal withinSellPrice;
    /**
     * 退款总成本
     */
    @ExcelField(title="退款总成本", align=2)
    private BigDecimal totalCost;
    /**
     * 总货款
     */
    @ExcelField(title="总货款", align=2)
    private BigDecimal totalWithinSellAmount;

    public String getSpecNo() {
        return specNo;
    }

    public void setSpecNo(String specNo) {
        this.specNo = specNo;
    }

    public String getStockinNo() {
        return stockinNo;
    }

    public void setStockinNo(String stockinNo) {
        this.stockinNo = stockinNo;
    }

    public BigDecimal getGoodsCount() {
        return goodsCount;
    }

    public void setGoodsCount(BigDecimal goodsCount) {
        this.goodsCount = goodsCount;
    }

    public BigDecimal getDiscountTax() {
        return discountTax;
    }

    public void setDiscountTax(BigDecimal discountTax) {
        this.discountTax = discountTax;
    }

    public BigDecimal getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(BigDecimal costPrice) {
        this.costPrice = costPrice;
    }

    public BigDecimal getWithinSellPrice() {
        return withinSellPrice;
    }

    public void setWithinSellPrice(BigDecimal withinSellPrice) {
        this.withinSellPrice = withinSellPrice;
    }

    public BigDecimal getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(BigDecimal totalCost) {
        this.totalCost = totalCost;
    }

    public BigDecimal getTotalWithinSellAmount() {
        return totalWithinSellAmount;
    }

    public void setTotalWithinSellAmount(BigDecimal totalWithinSellAmount) {
        this.totalWithinSellAmount = totalWithinSellAmount;
    }
}
