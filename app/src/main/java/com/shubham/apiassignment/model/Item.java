package com.shubham.apiassignment.model;

public class Item {

    private String firmid;
    private int orderNO;
    private String  orderDate;
    private String partyCode;
    private String productCode;
    private int itemsNo;
    private int salesManCode;
    private int qty;

    private String deliveryMode;
    private String remark;
    private int free;

    public String getDeliveryMode() {
        return deliveryMode;
    }

    public void setDeliveryMode(String deliveryMode) {
        this.deliveryMode = deliveryMode;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public int getFree() {
        return free;
    }

    public void setFree(int free) {
        this.free = free;
    }

    public Item() {
    }

    public String getFirmid() {
        return firmid;
    }

    public void setFirmid(String firmid) {
        this.firmid = firmid;
    }

    public int getOrderNO() {
        return orderNO;
    }

    public void setOrderNO(int orderNO) {
        this.orderNO = orderNO;
    }

    public String getOrderDate() {
        return orderDate;
    }

    @Override
    public String toString() {
        return "Item{" +
                "firmid='" + firmid + '\'' +
                ", orderNO=" + orderNO +
                ", orderDate=" + orderDate +
                ", partyCode='" + partyCode + '\'' +
                ", productCode='" + productCode + '\'' +
                ", itemsNo=" + itemsNo +
                ", salesManCode=" + salesManCode +
                ", qty=" + qty +
                '}';
    }

    public String getPartyCode() {
        return partyCode;
    }

    public void setPartyCode(String partyCode) {
        this.partyCode = partyCode;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public int getItemsNo() {
        return itemsNo;
    }

    public void setItemsNo(int itemsNo) {
        this.itemsNo = itemsNo;
    }

    public int getSalesManCode() {
        return salesManCode;
    }

    public void setSalesManCode(int salesManCode) {
        this.salesManCode = salesManCode;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

}
