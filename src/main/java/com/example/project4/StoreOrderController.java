package com.example.project4;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.text.DecimalFormat;
import java.util.ArrayList;


public class StoreOrderController {
    @FXML
    private TextField totalPrice;
    private static final double SALES_TAX = 6.625;

    MainController mainController = new MainController();
    private static final DecimalFormat df = new DecimalFormat("0.00");

    @FXML
    private ListView<String> orderList;
    private ObservableList<String> base;
    @FXML
    private ComboBox<Integer> select;
    ObservableList<Integer> smallList;
    public void setMainController(MainController controller){
        mainController = controller;
    }

    public void initialize(ArrayList<Integer> list){
        smallList = FXCollections.observableArrayList();
        for(Integer a : list){
            smallList.add( a);
        }
        select.setItems(smallList);
    }



    public void newDisplay(ArrayList<String> ace, ArrayList<Double> cost){
            base = FXCollections.observableArrayList();
            if (ace.size() != 0) {
                for (String a : ace) {
                    base.add(a);
                }
                double total = 0;
                for (double num : cost) {
                    total = total + num;
                }
                double tax = ((total * SALES_TAX) / 100);
                double u = tax + total;
                totalPrice.setText(String.valueOf(Double.parseDouble(df.format(u))));
                orderList.setItems(base);
            }
    }

    @FXML
    void storeOrder(ActionEvent event){
        /*if(select.getSelectionModel().getSelectedItem()==1){
            base = FXCollections.observableArrayList();
        }*/
    }


    @FXML
    void export(ActionEvent event){
        mainController.internalExport();
    }























}
