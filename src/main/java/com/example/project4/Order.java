package com.example.project4;

import java.util.ArrayList;

public class Order {
    private int orderNumber;
    private ArrayList<MenuItem> orderList;

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }
    public int getOrderNumber(){return orderNumber;}
    public Order(int orderNumber, ArrayList<MenuItem> orderList){
        this.orderNumber = orderNumber;
        this.orderList = orderList;
    }

    public ArrayList<MenuItem> getOrderList() {
        return orderList;
    }


}
