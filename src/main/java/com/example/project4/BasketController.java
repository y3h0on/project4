package com.example.project4;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class BasketController {

    private static final double SALES_TAX = 6.625;
   @FXML
    private TextField subTotal;
   @FXML
   private TextField salesTax;
   @FXML
   private TextField totalCost;
    @FXML
    private ListView<String> finalList;
    private ObservableList<String> base;
    MainController mainController = new MainController();

    private static final DecimalFormat df = new DecimalFormat("0.00");

    public void setMainController(MainController controller){
        mainController = controller;
    }

    public void displayName(ArrayList<String> ace, ArrayList<Double> cost){
        base = FXCollections.observableArrayList();
        if(ace.size()!=0){
            for (String name: ace){
                base.add(name);
            }
            double total = 0;
            for(double num : cost){
                total = total + num;
            }

            subTotal.setText(String.valueOf(Double.parseDouble(df.format(total))));
            double tax = ((total*SALES_TAX)/100);
            salesTax.setText(String.valueOf(Double.parseDouble(df.format(tax))));
            double u = tax + total;
            totalCost.setText(String.valueOf(Double.parseDouble(df.format(u))));
        finalList.setItems(base);}
    }


    @FXML
    void remove(ActionEvent event){
        if(!finalList.getSelectionModel().isEmpty()) {
            int a = finalList.getSelectionModel().getSelectedIndex();
            ObservableList<String> selected = finalList.getSelectionModel().getSelectedItems();
            finalList.getItems().removeAll(selected);
            //also need to remove the selected item from the main controller list.
            mainController.getList().remove(a);
            mainController.getMoreList().remove(a);
            double total = mainController.getTotal();
            subTotal.setText(String.valueOf(Double.parseDouble(df.format(total))));
            double tax = ((total * SALES_TAX) / 100);
            salesTax.setText(String.valueOf(Double.parseDouble(df.format(tax))));
            double u = tax + total;
            totalCost.setText(String.valueOf(Double.parseDouble(df.format(u))));
        }else{
            Alert error = new Alert(Alert.AlertType.ERROR);
            error.setTitle("ERROR!");
            error.setContentText("nothing to remove");
            error.showAndWait();
        }
    }

    @FXML
    void confirmOrder(ActionEvent event){
        if(!finalList.getItems().isEmpty()){
        int a = mainController.getOrder().getOrderNumber();
        mainController.getListForOrders().add(a);
        mainController.copy();
        mainController.clear();
        subTotal.setText("");
        salesTax.setText("");
        totalCost.setText("");
        finalList.getItems().removeAll(base);
        mainController.getOrder().setOrderNumber(a+1);}
        else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR!");
            alert.setContentText("order is empty!");
            alert.showAndWait();
        }


    }


}
