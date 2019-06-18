package com.my.scaffold.dal.entity;

import java.math.BigDecimal;
import java.util.Date;

/**
 *
 */
public class PurStockoutOrderTrade {
    /**
     *   
     * pur_stockout_order_trade.id
     */
    private Long id;

    /**
     *   
     * pur_stockout_order_trade.warehouse_no
     */
    private String warehouseNo;

    /**
     *   
     * pur_stockout_order_trade.warehouse_name
     */
    private String warehouseName;

    /**
     *   
     * pur_stockout_order_trade.order_no
     */
    private String orderNo;

    /**
     *   
     * pur_stockout_order_trade.status
     */
    private Integer status;

    /**
     *   
     * pur_stockout_order_trade.consign_time
     */
    private Date consignTime;

    /**
     *   
     * pur_stockout_order_trade.src_trade_no
     */
    private String srcTradeNo;

    /**
     *   
     * pur_stockout_order_trade.trade_no
     */
    private String tradeNo;

    /**
     *   
     * pur_stockout_order_trade.trade_type
     */
    private Integer tradeType;

    /**
     *   
     * pur_stockout_order_trade.stockout_id
     */
    private Integer stockoutId;

    /**
     *   
     * pur_stockout_order_trade.goods_count
     */
    private BigDecimal goodsCount;

    /**
     *   
     * pur_stockout_order_trade.weight
     */
    private BigDecimal weight;

    /**
     *   
     * pur_stockout_order_trade.goods_total_amount
     */
    private BigDecimal goodsTotalAmount;

    /**
     *   
     * pur_stockout_order_trade.goods_total_cost
     */
    private BigDecimal goodsTotalCost;

    /**
     *   
     * pur_stockout_order_trade.post_fee
     */
    private BigDecimal postFee;

    /**
     *   
     * pur_stockout_order_trade.paid
     */
    private BigDecimal paid;

    /**
     *   
     * pur_stockout_order_trade.trade_time
     */
    private Date tradeTime;

    /**
     *   
     * pur_stockout_order_trade.remark
     */
    private String remark;

    /**
     *   
     * pur_stockout_order_trade.nick_name
     */
    private String nickName;

    /**
     *   
     * pur_stockout_order_trade.shop_name
     */
    private String shopName;

    /**
     *   
     * pur_stockout_order_trade.shop_no
     */
    private String shopNo;

    /**
     *   
     * pur_stockout_order_trade.created
     */
    private Date created;

    /**
     *   
     * pur_stockout_order_trade.src_order_no
     */
    private String srcOrderNo;

    /**
     *   
     * pur_stockout_order_trade.trade_status
     */
    private Integer tradeStatus;

    /**
     *   
     * pur_stockout_order_trade.shop_remark
     */
    private String shopRemark;

    /**
     *   
     * pur_stockout_order_trade.trade_id
     */
    private Integer tradeId;

    /**
     *   
     * pur_stockout_order_trade.discount
     */
    private BigDecimal discount;

    /**
     *   
     * pur_stockout_order_trade.outer_no
     */
    private String outerNo;

    /**
     *   创建时间
     * pur_stockout_order_trade.gmt_create
     */
    private Date gmtCreate;

    /**
     *   修改时间
     * pur_stockout_order_trade.gmt_modify
     */
    private Date gmtModify;

    /**
     *   有效性
     * pur_stockout_order_trade.enabled
     */
    private boolean enabled;

    /**
     *   是否已衍生erp内销退货出库单
     * pur_stockout_order_trade.flag_derive
     */
    private Integer flagDerive;

    /**
     * 获取  字段：pur_stockout_order_trade.id
     *
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置  字段：pur_stockout_order_trade.id
     *
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取  字段：pur_stockout_order_trade.warehouse_no
     *
     */
    public String getWarehouseNo() {
        return warehouseNo;
    }

    /**
     * 设置  字段：pur_stockout_order_trade.warehouse_no
     *
     */
    public void setWarehouseNo(String warehouseNo) {
        this.warehouseNo = warehouseNo == null ? null : warehouseNo.trim();
    }

    /**
     * 获取  字段：pur_stockout_order_trade.warehouse_name
     *
     */
    public String getWarehouseName() {
        return warehouseName;
    }

    /**
     * 设置  字段：pur_stockout_order_trade.warehouse_name
     *
     */
    public void setWarehouseName(String warehouseName) {
        this.warehouseName = warehouseName == null ? null : warehouseName.trim();
    }

    /**
     * 获取  字段：pur_stockout_order_trade.order_no
     *
     */
    public String getOrderNo() {
        return orderNo;
    }

    /**
     * 设置  字段：pur_stockout_order_trade.order_no
     *
     */
    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo == null ? null : orderNo.trim();
    }

    /**
     * 获取  字段：pur_stockout_order_trade.status
     *
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置  字段：pur_stockout_order_trade.status
     *
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取  字段：pur_stockout_order_trade.consign_time
     *
     */
    public Date getConsignTime() {
        return consignTime;
    }

    /**
     * 设置  字段：pur_stockout_order_trade.consign_time
     *
     */
    public void setConsignTime(Date consignTime) {
        this.consignTime = consignTime;
    }

    /**
     * 获取  字段：pur_stockout_order_trade.src_trade_no
     *
     */
    public String getSrcTradeNo() {
        return srcTradeNo;
    }

    /**
     * 设置  字段：pur_stockout_order_trade.src_trade_no
     *
     */
    public void setSrcTradeNo(String srcTradeNo) {
        this.srcTradeNo = srcTradeNo == null ? null : srcTradeNo.trim();
    }

    /**
     * 获取  字段：pur_stockout_order_trade.trade_no
     *
     */
    public String getTradeNo() {
        return tradeNo;
    }

    /**
     * 设置  字段：pur_stockout_order_trade.trade_no
     *
     */
    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo == null ? null : tradeNo.trim();
    }

    /**
     * 获取  字段：pur_stockout_order_trade.trade_type
     *
     */
    public Integer getTradeType() {
        return tradeType;
    }

    /**
     * 设置  字段：pur_stockout_order_trade.trade_type
     *
     */
    public void setTradeType(Integer tradeType) {
        this.tradeType = tradeType;
    }

    /**
     * 获取  字段：pur_stockout_order_trade.stockout_id
     *
     */
    public Integer getStockoutId() {
        return stockoutId;
    }

    /**
     * 设置  字段：pur_stockout_order_trade.stockout_id
     *
     */
    public void setStockoutId(Integer stockoutId) {
        this.stockoutId = stockoutId;
    }

    /**
     * 获取  字段：pur_stockout_order_trade.goods_count
     *
     */
    public BigDecimal getGoodsCount() {
        return goodsCount;
    }

    /**
     * 设置  字段：pur_stockout_order_trade.goods_count
     *
     */
    public void setGoodsCount(BigDecimal goodsCount) {
        this.goodsCount = goodsCount;
    }

    /**
     * 获取  字段：pur_stockout_order_trade.weight
     *
     */
    public BigDecimal getWeight() {
        return weight;
    }

    /**
     * 设置  字段：pur_stockout_order_trade.weight
     *
     */
    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    /**
     * 获取  字段：pur_stockout_order_trade.goods_total_amount
     *
     */
    public BigDecimal getGoodsTotalAmount() {
        return goodsTotalAmount;
    }

    /**
     * 设置  字段：pur_stockout_order_trade.goods_total_amount
     *
     */
    public void setGoodsTotalAmount(BigDecimal goodsTotalAmount) {
        this.goodsTotalAmount = goodsTotalAmount;
    }

    /**
     * 获取  字段：pur_stockout_order_trade.goods_total_cost
     *
     */
    public BigDecimal getGoodsTotalCost() {
        return goodsTotalCost;
    }

    /**
     * 设置  字段：pur_stockout_order_trade.goods_total_cost
     *
     */
    public void setGoodsTotalCost(BigDecimal goodsTotalCost) {
        this.goodsTotalCost = goodsTotalCost;
    }

    /**
     * 获取  字段：pur_stockout_order_trade.post_fee
     *
     */
    public BigDecimal getPostFee() {
        return postFee;
    }

    /**
     * 设置  字段：pur_stockout_order_trade.post_fee
     *
     */
    public void setPostFee(BigDecimal postFee) {
        this.postFee = postFee;
    }

    /**
     * 获取  字段：pur_stockout_order_trade.paid
     *
     */
    public BigDecimal getPaid() {
        return paid;
    }

    /**
     * 设置  字段：pur_stockout_order_trade.paid
     *
     */
    public void setPaid(BigDecimal paid) {
        this.paid = paid;
    }

    /**
     * 获取  字段：pur_stockout_order_trade.trade_time
     *
     */
    public Date getTradeTime() {
        return tradeTime;
    }

    /**
     * 设置  字段：pur_stockout_order_trade.trade_time
     *
     */
    public void setTradeTime(Date tradeTime) {
        this.tradeTime = tradeTime;
    }

    /**
     * 获取  字段：pur_stockout_order_trade.remark
     *
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置  字段：pur_stockout_order_trade.remark
     *
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * 获取  字段：pur_stockout_order_trade.nick_name
     *
     */
    public String getNickName() {
        return nickName;
    }

    /**
     * 设置  字段：pur_stockout_order_trade.nick_name
     *
     */
    public void setNickName(String nickName) {
        this.nickName = nickName == null ? null : nickName.trim();
    }

    /**
     * 获取  字段：pur_stockout_order_trade.shop_name
     *
     */
    public String getShopName() {
        return shopName;
    }

    /**
     * 设置  字段：pur_stockout_order_trade.shop_name
     *
     */
    public void setShopName(String shopName) {
        this.shopName = shopName == null ? null : shopName.trim();
    }

    /**
     * 获取  字段：pur_stockout_order_trade.shop_no
     *
     */
    public String getShopNo() {
        return shopNo;
    }

    /**
     * 设置  字段：pur_stockout_order_trade.shop_no
     *
     */
    public void setShopNo(String shopNo) {
        this.shopNo = shopNo == null ? null : shopNo.trim();
    }

    /**
     * 获取  字段：pur_stockout_order_trade.created
     *
     */
    public Date getCreated() {
        return created;
    }

    /**
     * 设置  字段：pur_stockout_order_trade.created
     *
     */
    public void setCreated(Date created) {
        this.created = created;
    }

    /**
     * 获取  字段：pur_stockout_order_trade.src_order_no
     *
     */
    public String getSrcOrderNo() {
        return srcOrderNo;
    }

    /**
     * 设置  字段：pur_stockout_order_trade.src_order_no
     *
     */
    public void setSrcOrderNo(String srcOrderNo) {
        this.srcOrderNo = srcOrderNo == null ? null : srcOrderNo.trim();
    }

    /**
     * 获取  字段：pur_stockout_order_trade.trade_status
     *
     */
    public Integer getTradeStatus() {
        return tradeStatus;
    }

    /**
     * 设置  字段：pur_stockout_order_trade.trade_status
     *
     */
    public void setTradeStatus(Integer tradeStatus) {
        this.tradeStatus = tradeStatus;
    }

    /**
     * 获取  字段：pur_stockout_order_trade.shop_remark
     *
     */
    public String getShopRemark() {
        return shopRemark;
    }

    /**
     * 设置  字段：pur_stockout_order_trade.shop_remark
     *
     */
    public void setShopRemark(String shopRemark) {
        this.shopRemark = shopRemark == null ? null : shopRemark.trim();
    }

    /**
     * 获取  字段：pur_stockout_order_trade.trade_id
     *
     */
    public Integer getTradeId() {
        return tradeId;
    }

    /**
     * 设置  字段：pur_stockout_order_trade.trade_id
     *
     */
    public void setTradeId(Integer tradeId) {
        this.tradeId = tradeId;
    }

    /**
     * 获取  字段：pur_stockout_order_trade.discount
     *
     */
    public BigDecimal getDiscount() {
        return discount;
    }

    /**
     * 设置  字段：pur_stockout_order_trade.discount
     *
     */
    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    /**
     * 获取  字段：pur_stockout_order_trade.outer_no
     *
     */
    public String getOuterNo() {
        return outerNo;
    }

    /**
     * 设置  字段：pur_stockout_order_trade.outer_no
     *
     */
    public void setOuterNo(String outerNo) {
        this.outerNo = outerNo == null ? null : outerNo.trim();
    }

    /**
     * 获取 创建时间 字段：pur_stockout_order_trade.gmt_create
     *
     */
    public Date getGmtCreate() {
        return gmtCreate;
    }

    /**
     * 设置 创建时间 字段：pur_stockout_order_trade.gmt_create
     *
     */
    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    /**
     * 获取 修改时间 字段：pur_stockout_order_trade.gmt_modify
     *
     */
    public Date getGmtModify() {
        return gmtModify;
    }

    /**
     * 设置 修改时间 字段：pur_stockout_order_trade.gmt_modify
     *
     */
    public void setGmtModify(Date gmtModify) {
        this.gmtModify = gmtModify;
    }

    /**
     * 获取 有效性 字段：pur_stockout_order_trade.enabled
     *
     */
    public boolean isEnabled() {
        return enabled;
    }

    /**
     * 设置 有效性 字段：pur_stockout_order_trade.enabled
     *
     */
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    /**
     * 获取 是否已衍生erp内销退货出库单 字段：pur_stockout_order_trade.flag_derive
     *
     */
    public Integer getFlagDerive() {
        return flagDerive;
    }

    /**
     * 设置 是否已衍生erp内销退货出库单 字段：pur_stockout_order_trade.flag_derive
     *
     */
    public void setFlagDerive(Integer flagDerive) {
        this.flagDerive = flagDerive;
    }

    /**
     * 
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", warehouseNo=").append(warehouseNo);
        sb.append(", warehouseName=").append(warehouseName);
        sb.append(", orderNo=").append(orderNo);
        sb.append(", status=").append(status);
        sb.append(", consignTime=").append(consignTime);
        sb.append(", srcTradeNo=").append(srcTradeNo);
        sb.append(", tradeNo=").append(tradeNo);
        sb.append(", tradeType=").append(tradeType);
        sb.append(", stockoutId=").append(stockoutId);
        sb.append(", goodsCount=").append(goodsCount);
        sb.append(", weight=").append(weight);
        sb.append(", goodsTotalAmount=").append(goodsTotalAmount);
        sb.append(", goodsTotalCost=").append(goodsTotalCost);
        sb.append(", postFee=").append(postFee);
        sb.append(", paid=").append(paid);
        sb.append(", tradeTime=").append(tradeTime);
        sb.append(", remark=").append(remark);
        sb.append(", nickName=").append(nickName);
        sb.append(", shopName=").append(shopName);
        sb.append(", shopNo=").append(shopNo);
        sb.append(", created=").append(created);
        sb.append(", srcOrderNo=").append(srcOrderNo);
        sb.append(", tradeStatus=").append(tradeStatus);
        sb.append(", shopRemark=").append(shopRemark);
        sb.append(", tradeId=").append(tradeId);
        sb.append(", discount=").append(discount);
        sb.append(", outerNo=").append(outerNo);
        sb.append(", gmtCreate=").append(gmtCreate);
        sb.append(", gmtModify=").append(gmtModify);
        sb.append(", enabled=").append(enabled);
        sb.append(", flagDerive=").append(flagDerive);
        sb.append("]");
        return sb.toString();
    }

    /**
     * 
     */
    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        PurStockoutOrderTrade other = (PurStockoutOrderTrade) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getWarehouseNo() == null ? other.getWarehouseNo() == null : this.getWarehouseNo().equals(other.getWarehouseNo()))
            && (this.getWarehouseName() == null ? other.getWarehouseName() == null : this.getWarehouseName().equals(other.getWarehouseName()))
            && (this.getOrderNo() == null ? other.getOrderNo() == null : this.getOrderNo().equals(other.getOrderNo()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getConsignTime() == null ? other.getConsignTime() == null : this.getConsignTime().equals(other.getConsignTime()))
            && (this.getSrcTradeNo() == null ? other.getSrcTradeNo() == null : this.getSrcTradeNo().equals(other.getSrcTradeNo()))
            && (this.getTradeNo() == null ? other.getTradeNo() == null : this.getTradeNo().equals(other.getTradeNo()))
            && (this.getTradeType() == null ? other.getTradeType() == null : this.getTradeType().equals(other.getTradeType()))
            && (this.getStockoutId() == null ? other.getStockoutId() == null : this.getStockoutId().equals(other.getStockoutId()))
            && (this.getGoodsCount() == null ? other.getGoodsCount() == null : this.getGoodsCount().equals(other.getGoodsCount()))
            && (this.getWeight() == null ? other.getWeight() == null : this.getWeight().equals(other.getWeight()))
            && (this.getGoodsTotalAmount() == null ? other.getGoodsTotalAmount() == null : this.getGoodsTotalAmount().equals(other.getGoodsTotalAmount()))
            && (this.getGoodsTotalCost() == null ? other.getGoodsTotalCost() == null : this.getGoodsTotalCost().equals(other.getGoodsTotalCost()))
            && (this.getPostFee() == null ? other.getPostFee() == null : this.getPostFee().equals(other.getPostFee()))
            && (this.getPaid() == null ? other.getPaid() == null : this.getPaid().equals(other.getPaid()))
            && (this.getTradeTime() == null ? other.getTradeTime() == null : this.getTradeTime().equals(other.getTradeTime()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
            && (this.getNickName() == null ? other.getNickName() == null : this.getNickName().equals(other.getNickName()))
            && (this.getShopName() == null ? other.getShopName() == null : this.getShopName().equals(other.getShopName()))
            && (this.getShopNo() == null ? other.getShopNo() == null : this.getShopNo().equals(other.getShopNo()))
            && (this.getCreated() == null ? other.getCreated() == null : this.getCreated().equals(other.getCreated()))
            && (this.getSrcOrderNo() == null ? other.getSrcOrderNo() == null : this.getSrcOrderNo().equals(other.getSrcOrderNo()))
            && (this.getTradeStatus() == null ? other.getTradeStatus() == null : this.getTradeStatus().equals(other.getTradeStatus()))
            && (this.getShopRemark() == null ? other.getShopRemark() == null : this.getShopRemark().equals(other.getShopRemark()))
            && (this.getTradeId() == null ? other.getTradeId() == null : this.getTradeId().equals(other.getTradeId()))
            && (this.getDiscount() == null ? other.getDiscount() == null : this.getDiscount().equals(other.getDiscount()))
            && (this.getOuterNo() == null ? other.getOuterNo() == null : this.getOuterNo().equals(other.getOuterNo()))
            && (this.getGmtCreate() == null ? other.getGmtCreate() == null : this.getGmtCreate().equals(other.getGmtCreate()))
            && (this.getGmtModify() == null ? other.getGmtModify() == null : this.getGmtModify().equals(other.getGmtModify()))
            && (this.isEnabled() == other.isEnabled())
            && (this.getFlagDerive() == null ? other.getFlagDerive() == null : this.getFlagDerive().equals(other.getFlagDerive()));
    }

    /**
     * 
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getWarehouseNo() == null) ? 0 : getWarehouseNo().hashCode());
        result = prime * result + ((getWarehouseName() == null) ? 0 : getWarehouseName().hashCode());
        result = prime * result + ((getOrderNo() == null) ? 0 : getOrderNo().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getConsignTime() == null) ? 0 : getConsignTime().hashCode());
        result = prime * result + ((getSrcTradeNo() == null) ? 0 : getSrcTradeNo().hashCode());
        result = prime * result + ((getTradeNo() == null) ? 0 : getTradeNo().hashCode());
        result = prime * result + ((getTradeType() == null) ? 0 : getTradeType().hashCode());
        result = prime * result + ((getStockoutId() == null) ? 0 : getStockoutId().hashCode());
        result = prime * result + ((getGoodsCount() == null) ? 0 : getGoodsCount().hashCode());
        result = prime * result + ((getWeight() == null) ? 0 : getWeight().hashCode());
        result = prime * result + ((getGoodsTotalAmount() == null) ? 0 : getGoodsTotalAmount().hashCode());
        result = prime * result + ((getGoodsTotalCost() == null) ? 0 : getGoodsTotalCost().hashCode());
        result = prime * result + ((getPostFee() == null) ? 0 : getPostFee().hashCode());
        result = prime * result + ((getPaid() == null) ? 0 : getPaid().hashCode());
        result = prime * result + ((getTradeTime() == null) ? 0 : getTradeTime().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getNickName() == null) ? 0 : getNickName().hashCode());
        result = prime * result + ((getShopName() == null) ? 0 : getShopName().hashCode());
        result = prime * result + ((getShopNo() == null) ? 0 : getShopNo().hashCode());
        result = prime * result + ((getCreated() == null) ? 0 : getCreated().hashCode());
        result = prime * result + ((getSrcOrderNo() == null) ? 0 : getSrcOrderNo().hashCode());
        result = prime * result + ((getTradeStatus() == null) ? 0 : getTradeStatus().hashCode());
        result = prime * result + ((getShopRemark() == null) ? 0 : getShopRemark().hashCode());
        result = prime * result + ((getTradeId() == null) ? 0 : getTradeId().hashCode());
        result = prime * result + ((getDiscount() == null) ? 0 : getDiscount().hashCode());
        result = prime * result + ((getOuterNo() == null) ? 0 : getOuterNo().hashCode());
        result = prime * result + ((getGmtCreate() == null) ? 0 : getGmtCreate().hashCode());
        result = prime * result + ((getGmtModify() == null) ? 0 : getGmtModify().hashCode());
        result = prime * result + (isEnabled() ? 1231 : 1237);
        result = prime * result + ((getFlagDerive() == null) ? 0 : getFlagDerive().hashCode());
        return result;
    }
}