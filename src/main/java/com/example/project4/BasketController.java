package com.example.project4;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
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
            subTotal.setText(String.valueOf(total));
            double tax = ((total*SALES_TAX)/100);
            salesTax.setText(String.valueOf(tax));
            double u = tax + total;
            totalCost.setText(String.valueOf(u));

        finalList.setItems(base);}
    }
    @FXML
    public void switchToMainPage(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("main-view.fxml"));
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    MainController mainController = new MainController();

    /*public void initialize(){
        setMainController(mainController);
        base = FXCollections.observableArrayList();
        base.add(0, mainController.getList().toString());
        base.add(mainController.getList().toString());
        finalList.setItems(base);
    }*/
    @FXML
    void remove(ActionEvent event){
        int a = finalList.getSelectionModel().getSelectedIndex();
        ObservableList<String> selected = finalList.getSelectionModel().getSelectedItems();
        finalList.getItems().removeAll(selected);
        //also need to remove the selected item from the main controller list.
        mainController.getList().remove(a);

        //make a getCost method  for whatever string we are deleting.
        mainController.getMoreList().remove(a);
        double total = mainController.getTotal();
        subTotal.setText(String.valueOf(total));
        double tax = ((total*SALES_TAX)/100);
        salesTax.setText(String.valueOf(tax));
        double u = tax + total;
        totalCost.setText(String.valueOf(u));

    }
}
