package com.want.shoppingcar.shopcar.entity;


public class ShopcarProductBean {
    private String goodsName;
    private String goodsPrice;
    private String imgUrl;
    private String sellNum;
    private String goodsSize;
    private boolean isChoosed;
    private String buyNum;

    public ShopcarProductBean(String goodsName, String goodsPrice, String imgUrl, String sellNum, String goodsSize, boolean isChoosed, String buyNum) {
        this.goodsName = goodsName;
        this.goodsPrice = goodsPrice;
        this.imgUrl = imgUrl;
        this.sellNum = sellNum;
        this.goodsSize = goodsSize;
        this.isChoosed = isChoosed;
        this.buyNum = buyNum;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(String goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getSellNum() {
        return sellNum;
    }

    public void setSellNum(String sellNum) {
        this.sellNum = sellNum;
    }

    public String getGoodsSize() {
        return goodsSize;
    }

    public void setGoodsSize(String goodsSize) {
        this.goodsSize = goodsSize;
    }

    public boolean isChoosed() {
        return isChoosed;
    }

    public void setChoosed(boolean choosed) {
        isChoosed = choosed;
    }

    public String getBuyNum() {
        return buyNum;
    }

    public void setBuyNum(String buyNum) {
        this.buyNum = buyNum;
    }
}
