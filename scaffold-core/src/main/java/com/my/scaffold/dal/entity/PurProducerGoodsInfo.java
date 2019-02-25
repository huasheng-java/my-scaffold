package com.my.scaffold.dal.entity;

import java.math.BigDecimal;
import java.util.Date;

public class PurProducerGoodsInfo {
    /**
     * 注释
     */
    private Long id;

    /**
     * 供应商货品名
     */
    private String goodsName;

    /**
     * 供应商货品编码（针对供应商唯一，无则自动生成）
     */
    private String goodsNo;

    /**
     * 品牌编码
     */
    private String brandNo;

    /**
     * 品牌名
     */
    private String brandName;

    /**
     * 
     */
    private Date createTime;

    /**
     * 
     */
    private Date modifyTime;

    /**
     * 
     */
    private boolean enabled;

    /**
     * 基本单位
     */
    private String unit;

    /**
     * 最低价
     */
    private BigDecimal lowestPrice;

    /**
     * 图片链接
     */
    private String imgUrl;

    /**
     * 市场价
     */
    private BigDecimal marketPrice;

    /**
     * 零售价
     */
    private BigDecimal retailPrice;

    /**
     * 重量
     */
    private Double weight;

    /**
     * 长
     */
    private Double length;

    /**
     * 宽
     */
    private Double width;

    /**
     * 高
     */
    private Double height;

    /**
     * 税率
     */
    private Double taxRate;

    /**
     * 开票名称
     */
    private String invoiceName;

    /**
     * 开票规格码
     */
    private String invoiceCode;

    /**
     * 供应商编码
     */
    private String providerNo;

    /**
     * 供应商名称
     */
    private String providerName;

    /**
     * 规格码
     */
    private String goodsCode;

    /**
     * 注释
     * @return id 注释
     */
    public Long getId() {
        return id;
    }

    /**
     * 注释
     * @param id 注释
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 供应商货品名
     * @return goods_name 供应商货品名
     */
    public String getGoodsName() {
        return goodsName;
    }

    /**
     * 供应商货品名
     * @param goodsName 供应商货品名
     */
    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName == null ? null : goodsName.trim();
    }

    /**
     * 供应商货品编码（针对供应商唯一，无则自动生成）
     * @return goods_no 供应商货品编码（针对供应商唯一，无则自动生成）
     */
    public String getGoodsNo() {
        return goodsNo;
    }

    /**
     * 供应商货品编码（针对供应商唯一，无则自动生成）
     * @param goodsNo 供应商货品编码（针对供应商唯一，无则自动生成）
     */
    public void setGoodsNo(String goodsNo) {
        this.goodsNo = goodsNo == null ? null : goodsNo.trim();
    }

    /**
     * 品牌编码
     * @return brand_no 品牌编码
     */
    public String getBrandNo() {
        return brandNo;
    }

    /**
     * 品牌编码
     * @param brandNo 品牌编码
     */
    public void setBrandNo(String brandNo) {
        this.brandNo = brandNo == null ? null : brandNo.trim();
    }

    /**
     * 品牌名
     * @return brand_name 品牌名
     */
    public String getBrandName() {
        return brandName;
    }

    /**
     * 品牌名
     * @param brandName 品牌名
     */
    public void setBrandName(String brandName) {
        this.brandName = brandName == null ? null : brandName.trim();
    }

    /**
     * 
     * @return create_time 
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 
     * @param createTime 
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 
     * @return modify_time 
     */
    public Date getModifyTime() {
        return modifyTime;
    }

    /**
     * 
     * @param modifyTime 
     */
    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    /**
     * 
     * @return enabled 
     */
    public boolean isEnabled() {
        return enabled;
    }

    /**
     * 
     * @param enabled 
     */
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    /**
     * 基本单位
     * @return unit 基本单位
     */
    public String getUnit() {
        return unit;
    }

    /**
     * 基本单位
     * @param unit 基本单位
     */
    public void setUnit(String unit) {
        this.unit = unit == null ? null : unit.trim();
    }

    /**
     * 最低价
     * @return lowest_price 最低价
     */
    public BigDecimal getLowestPrice() {
        return lowestPrice;
    }

    /**
     * 最低价
     * @param lowestPrice 最低价
     */
    public void setLowestPrice(BigDecimal lowestPrice) {
        this.lowestPrice = lowestPrice;
    }

    /**
     * 图片链接
     * @return img_url 图片链接
     */
    public String getImgUrl() {
        return imgUrl;
    }

    /**
     * 图片链接
     * @param imgUrl 图片链接
     */
    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl == null ? null : imgUrl.trim();
    }

    /**
     * 市场价
     * @return market_price 市场价
     */
    public BigDecimal getMarketPrice() {
        return marketPrice;
    }

    /**
     * 市场价
     * @param marketPrice 市场价
     */
    public void setMarketPrice(BigDecimal marketPrice) {
        this.marketPrice = marketPrice;
    }

    /**
     * 零售价
     * @return retail_price 零售价
     */
    public BigDecimal getRetailPrice() {
        return retailPrice;
    }

    /**
     * 零售价
     * @param retailPrice 零售价
     */
    public void setRetailPrice(BigDecimal retailPrice) {
        this.retailPrice = retailPrice;
    }

    /**
     * 重量
     * @return weight 重量
     */
    public Double getWeight() {
        return weight;
    }

    /**
     * 重量
     * @param weight 重量
     */
    public void setWeight(Double weight) {
        this.weight = weight;
    }

    /**
     * 长
     * @return length 长
     */
    public Double getLength() {
        return length;
    }

    /**
     * 长
     * @param length 长
     */
    public void setLength(Double length) {
        this.length = length;
    }

    /**
     * 宽
     * @return width 宽
     */
    public Double getWidth() {
        return width;
    }

    /**
     * 宽
     * @param width 宽
     */
    public void setWidth(Double width) {
        this.width = width;
    }

    /**
     * 高
     * @return height 高
     */
    public Double getHeight() {
        return height;
    }

    /**
     * 高
     * @param height 高
     */
    public void setHeight(Double height) {
        this.height = height;
    }

    /**
     * 税率
     * @return tax_rate 税率
     */
    public Double getTaxRate() {
        return taxRate;
    }

    /**
     * 税率
     * @param taxRate 税率
     */
    public void setTaxRate(Double taxRate) {
        this.taxRate = taxRate;
    }

    /**
     * 开票名称
     * @return invoice_name 开票名称
     */
    public String getInvoiceName() {
        return invoiceName;
    }

    /**
     * 开票名称
     * @param invoiceName 开票名称
     */
    public void setInvoiceName(String invoiceName) {
        this.invoiceName = invoiceName == null ? null : invoiceName.trim();
    }

    /**
     * 开票规格码
     * @return invoice_code 开票规格码
     */
    public String getInvoiceCode() {
        return invoiceCode;
    }

    /**
     * 开票规格码
     * @param invoiceCode 开票规格码
     */
    public void setInvoiceCode(String invoiceCode) {
        this.invoiceCode = invoiceCode == null ? null : invoiceCode.trim();
    }

    /**
     * 供应商编码
     * @return provider_no 供应商编码
     */
    public String getProviderNo() {
        return providerNo;
    }

    /**
     * 供应商编码
     * @param providerNo 供应商编码
     */
    public void setProviderNo(String providerNo) {
        this.providerNo = providerNo == null ? null : providerNo.trim();
    }

    /**
     * 供应商名称
     * @return provider_name 供应商名称
     */
    public String getProviderName() {
        return providerName;
    }

    /**
     * 供应商名称
     * @param providerName 供应商名称
     */
    public void setProviderName(String providerName) {
        this.providerName = providerName == null ? null : providerName.trim();
    }

    /**
     * 规格码
     * @return goods_code 规格码
     */
    public String getGoodsCode() {
        return goodsCode;
    }

    /**
     * 规格码
     * @param goodsCode 规格码
     */
    public void setGoodsCode(String goodsCode) {
        this.goodsCode = goodsCode == null ? null : goodsCode.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", goodsName=").append(goodsName);
        sb.append(", goodsNo=").append(goodsNo);
        sb.append(", brandNo=").append(brandNo);
        sb.append(", brandName=").append(brandName);
        sb.append(", createTime=").append(createTime);
        sb.append(", modifyTime=").append(modifyTime);
        sb.append(", enabled=").append(enabled);
        sb.append(", unit=").append(unit);
        sb.append(", lowestPrice=").append(lowestPrice);
        sb.append(", imgUrl=").append(imgUrl);
        sb.append(", marketPrice=").append(marketPrice);
        sb.append(", retailPrice=").append(retailPrice);
        sb.append(", weight=").append(weight);
        sb.append(", length=").append(length);
        sb.append(", width=").append(width);
        sb.append(", height=").append(height);
        sb.append(", taxRate=").append(taxRate);
        sb.append(", invoiceName=").append(invoiceName);
        sb.append(", invoiceCode=").append(invoiceCode);
        sb.append(", providerNo=").append(providerNo);
        sb.append(", providerName=").append(providerName);
        sb.append(", goodsCode=").append(goodsCode);
        sb.append("]");
        return sb.toString();
    }

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
        PurProducerGoodsInfo other = (PurProducerGoodsInfo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getGoodsName() == null ? other.getGoodsName() == null : this.getGoodsName().equals(other.getGoodsName()))
            && (this.getGoodsNo() == null ? other.getGoodsNo() == null : this.getGoodsNo().equals(other.getGoodsNo()))
            && (this.getBrandNo() == null ? other.getBrandNo() == null : this.getBrandNo().equals(other.getBrandNo()))
            && (this.getBrandName() == null ? other.getBrandName() == null : this.getBrandName().equals(other.getBrandName()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getModifyTime() == null ? other.getModifyTime() == null : this.getModifyTime().equals(other.getModifyTime()))
            && (this.isEnabled() == other.isEnabled())
            && (this.getUnit() == null ? other.getUnit() == null : this.getUnit().equals(other.getUnit()))
            && (this.getLowestPrice() == null ? other.getLowestPrice() == null : this.getLowestPrice().equals(other.getLowestPrice()))
            && (this.getImgUrl() == null ? other.getImgUrl() == null : this.getImgUrl().equals(other.getImgUrl()))
            && (this.getMarketPrice() == null ? other.getMarketPrice() == null : this.getMarketPrice().equals(other.getMarketPrice()))
            && (this.getRetailPrice() == null ? other.getRetailPrice() == null : this.getRetailPrice().equals(other.getRetailPrice()))
            && (this.getWeight() == null ? other.getWeight() == null : this.getWeight().equals(other.getWeight()))
            && (this.getLength() == null ? other.getLength() == null : this.getLength().equals(other.getLength()))
            && (this.getWidth() == null ? other.getWidth() == null : this.getWidth().equals(other.getWidth()))
            && (this.getHeight() == null ? other.getHeight() == null : this.getHeight().equals(other.getHeight()))
            && (this.getTaxRate() == null ? other.getTaxRate() == null : this.getTaxRate().equals(other.getTaxRate()))
            && (this.getInvoiceName() == null ? other.getInvoiceName() == null : this.getInvoiceName().equals(other.getInvoiceName()))
            && (this.getInvoiceCode() == null ? other.getInvoiceCode() == null : this.getInvoiceCode().equals(other.getInvoiceCode()))
            && (this.getProviderNo() == null ? other.getProviderNo() == null : this.getProviderNo().equals(other.getProviderNo()))
            && (this.getProviderName() == null ? other.getProviderName() == null : this.getProviderName().equals(other.getProviderName()))
            && (this.getGoodsCode() == null ? other.getGoodsCode() == null : this.getGoodsCode().equals(other.getGoodsCode()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getGoodsName() == null) ? 0 : getGoodsName().hashCode());
        result = prime * result + ((getGoodsNo() == null) ? 0 : getGoodsNo().hashCode());
        result = prime * result + ((getBrandNo() == null) ? 0 : getBrandNo().hashCode());
        result = prime * result + ((getBrandName() == null) ? 0 : getBrandName().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getModifyTime() == null) ? 0 : getModifyTime().hashCode());
        result = prime * result + (isEnabled() ? 1231 : 1237);
        result = prime * result + ((getUnit() == null) ? 0 : getUnit().hashCode());
        result = prime * result + ((getLowestPrice() == null) ? 0 : getLowestPrice().hashCode());
        result = prime * result + ((getImgUrl() == null) ? 0 : getImgUrl().hashCode());
        result = prime * result + ((getMarketPrice() == null) ? 0 : getMarketPrice().hashCode());
        result = prime * result + ((getRetailPrice() == null) ? 0 : getRetailPrice().hashCode());
        result = prime * result + ((getWeight() == null) ? 0 : getWeight().hashCode());
        result = prime * result + ((getLength() == null) ? 0 : getLength().hashCode());
        result = prime * result + ((getWidth() == null) ? 0 : getWidth().hashCode());
        result = prime * result + ((getHeight() == null) ? 0 : getHeight().hashCode());
        result = prime * result + ((getTaxRate() == null) ? 0 : getTaxRate().hashCode());
        result = prime * result + ((getInvoiceName() == null) ? 0 : getInvoiceName().hashCode());
        result = prime * result + ((getInvoiceCode() == null) ? 0 : getInvoiceCode().hashCode());
        result = prime * result + ((getProviderNo() == null) ? 0 : getProviderNo().hashCode());
        result = prime * result + ((getProviderName() == null) ? 0 : getProviderName().hashCode());
        result = prime * result + ((getGoodsCode() == null) ? 0 : getGoodsCode().hashCode());
        return result;
    }
}