package com.example.project4;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;


import java.util.ArrayList;

public class StoreOrderController {

    @FXML
    private TextField totalPrice;
    private static final double SALES_TAX = 6.625;

    MainController mainController = new MainController();

    @FXML
    private ListView<String> orderList;
    private ObservableList<String> base;
    @FXML
    private ComboBox<Integer> select;
    private ObservableList<Integer> orderNumber;
    public void setMainController(MainController controller){
        mainController = controller;
    }

    /*public void display(ArrayList<String> ace, ArrayList<Double> cost ) {
        base = FXCollections.observableArrayList();
        if (ace.size() != 0) {
            for (String name : ace) {
                base.add(name);
            }
            double total = 0;
            for (double num : cost) {
                total = total + num;
            }
            double tax = ((total * SALES_TAX) / 100);
            double u = tax + total;
            totalPrice.setText(String.valueOf(u));
            orderList.setItems(base);
        }*/

    //do not need a display method here




    public void newDisplay(ArrayList<MenuItem> ace, ArrayList<Double> cost){
        base = FXCollections.observableArrayList();
        if(ace.size()!=0){
            for(MenuItem a : ace){
                base.add(a.toString());
            }
            double total = 0;
            for (double num : cost) {
                total = total + num;
            }
            double tax = ((total * SALES_TAX) / 100);
            double u = tax + total;
            totalPrice.setText(String.valueOf(u));
            orderList.setItems(base);
        }

    }

    public void initialize(){
        orderNumber = FXCollections.observableArrayList();
        orderNumber.add(mainController.getOrder().getOrderNumber());
        select.setItems(orderNumber);
    }
    @FXML
    void selectOrder(ActionEvent event){
        /*orderNumber = FXCollections.observableArrayList();
        orderNumber.add(mainController.getOrder().getOrderNumber());
        select.setItems(orderNumber);
        System.out.println(mainController.getOrder().getOrderNumber());*/
    }




















}
