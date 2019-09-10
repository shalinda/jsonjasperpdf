package com.jsonpdf.model;

public class Label {

    private String style;
    private String customerLeather;
    private String color;
    private String size;
    private String orderNo;

    public String getStyle() {
        return style;
    }

    public String getCustomerLeather() {
        return customerLeather;
    }

    public String getColor() {
        return color;
    }

    public String getSize() {
        return size;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public void setCustomerLeather(String customerLeather) {
        this.customerLeather = customerLeather;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }
}
