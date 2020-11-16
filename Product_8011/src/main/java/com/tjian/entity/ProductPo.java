package com.tjian.entity;

public class ProductPo {

    private Long productId;
    private String productName;
    private Double proructPrice;
    private int productClassify;
    private String productionPlace;

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getProructPrice() {
        return proructPrice;
    }

    public void setProructPrice(Double proructPrice) {
        this.proructPrice = proructPrice;
    }

    public int getProductClassify() {
        return productClassify;
    }

    public void setProductClassify(int productClassify) {
        this.productClassify = productClassify;
    }

    public String getProductionPlace() {
        return productionPlace;
    }

    public void setProductionPlace(String productionPlace) {
        this.productionPlace = productionPlace;
    }
}
