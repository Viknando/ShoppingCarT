package com.want.shoppingcar.shopcar.entity;


public class GuessULikeBean {
    private String goodsName;
    private String goodsPrice;
    private String imgUrl;
    private String sellNum;

    public GuessULikeBean(String goodsName, String goodsPrice, String imgUrl, String sellNum) {
        this.goodsName = goodsName;
        this.goodsPrice = goodsPrice;
        this.imgUrl = imgUrl;
        this.sellNum = sellNum;
    }

    public GuessULikeBean() {
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
}
