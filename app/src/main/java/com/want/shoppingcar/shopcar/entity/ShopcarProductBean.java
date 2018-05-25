package com.want.shoppingcar.shopcar.entity;


public class ShopcarProductBean {
    private String goodsName;
    private String goodsPrice;
    private String imgUrl;
    private int sellNum;
    private String goodsSize;
    private boolean isChoosed;
    private int buyNum;
    private boolean isOutOfStock;

    public ShopcarProductBean(String goodsName, String goodsPrice, String imgUrl, int sellNum, String goodsSize, boolean isChoosed, int buyNum, boolean isOutOfStock) {
        this.goodsName = goodsName;
        this.goodsPrice = goodsPrice;
        this.imgUrl = imgUrl;
        this.sellNum = sellNum;
        this.goodsSize = goodsSize;
        this.isChoosed = isChoosed;
        this.buyNum = buyNum;
        this.isOutOfStock = isOutOfStock;
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

    public int getSellNum() {
        return sellNum;
    }

    public void setSellNum(int sellNum) {
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

    public int getBuyNum() {
        return buyNum;
    }

    public void setBuyNum(int buyNum) {
        this.buyNum = buyNum;
    }

    public boolean isOutOfStock() {
        return isOutOfStock;
    }

    public void setOutOfStock(boolean outOfStock) {
        isOutOfStock = outOfStock;
    }
}
