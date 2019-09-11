//-----------------------------------com.jsonpdf.model.Line.java-----------------------------------

package com.jsonpdf.model;

import org.apache.commons.lang.builder.ToStringBuilder;

public class Line {

    private String orderNo;
    private String customer;
    private String style;
    private String customerLeather;
    private String color;
    private String size;
    private Integer piece;
    private Integer pieces;

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getCustomerLeather() {
        return customerLeather;
    }

    public void setCustomerLeather(String customerLeather) {
        this.customerLeather = customerLeather;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Integer getPiece() {
        return piece;
    }

    public void setPiece(Integer piece) {
        this.piece = piece;
    }

    public Integer getPieces() {
        return pieces;
    }

    public void setPieces(Integer pieces) {
        this.pieces = pieces;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("orderNo", orderNo).append("customer", customer).append("style", style)
                .append("customerLeather", customerLeather).append("color", color).append("size", size)
                .append("piece", piece).append("pieces", pieces).toString();
    }

}