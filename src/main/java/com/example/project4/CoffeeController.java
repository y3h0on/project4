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
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.text.DecimalFormat;
import java.io.IOException;
import java.util.ArrayList;

public class CoffeeController {


    private ObservableList<Integer> numberList;
    private ObservableList<String> sizeList;
    @FXML
    private ComboBox<Integer> quantityCoffee;
    @FXML
    private ComboBox<String> sizeSelect;
    @FXML
    private CheckBox sweetCream;
    @FXML
    private CheckBox frenchVanilla;
    @FXML
    private CheckBox irishCream;
    @FXML
    private CheckBox caramel;
    @FXML
    private CheckBox mocha;
    @FXML
    private TextField subTotal;

    private static final DecimalFormat df = new DecimalFormat("0.00");
    private ArrayList<MenuItem> menuItems = new ArrayList<>();

    public void initialize(){
        numberList = FXCollections.observableArrayList(1, 2, 3, 4, 5, 6);
        quantityCoffee.setItems(numberList);
        sizeList = FXCollections.observableArrayList("Short", "Tall", "Grande", "Venti");
        sizeSelect.setItems(sizeList);
    }

    @FXML
    public void switchToMainPage(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("main-view.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    private boolean checkErrors(){
        if(!sizeSelect.getSelectionModel().isEmpty() && !quantityCoffee.getSelectionModel().isEmpty()){
            return true;
        }
        if(sizeSelect.getSelectionModel().isEmpty() && quantityCoffee.getSelectionModel().isEmpty()){
            Alert error = new Alert(Alert.AlertType.ERROR);
            error.setTitle("ERROR!");
            error.setContentText("select a size and the quantity");
            error.showAndWait();
            return false;
        }
        if(sizeSelect.getSelectionModel().isEmpty() && !quantityCoffee.getSelectionModel().isEmpty()){
            Alert error = new Alert(Alert.AlertType.ERROR);
            error.setTitle("ERROR!");
            error.setContentText("select a size");
            error.showAndWait();
            return false;
        }
        if(!sizeSelect.getSelectionModel().isEmpty() && quantityCoffee.getSelectionModel().isEmpty()){
            Alert error = new Alert(Alert.AlertType.ERROR);
            error.setTitle("ERROR!");
            error.setContentText("select the quantity.");
            error.showAndWait();
            return false;
        }
        return false;
    }

    @FXML
    void displayAmount(ActionEvent event){
        subTotal.setText(df.format(amt()));
    }

     private double amt(){
        if(checkErrors()) {
            double total = 0;
            Coffee c = new Coffee();
            int a = quantityCoffee.getSelectionModel().getSelectedItem();
            if (sizeSelect.getSelectionModel().getSelectedItem().equalsIgnoreCase("short")) {
                total = c.itemPrice() * a;
            }
            if (sizeSelect.getSelectionModel().getSelectedItem().equalsIgnoreCase("tall")) {
                total = (c.itemPrice() + 0.40) * a;
            }
            if (sizeSelect.getSelectionModel().getSelectedItem().equalsIgnoreCase("grande")) {
                total = (c.itemPrice() + 0.80) * a;
            }
            if (sizeSelect.getSelectionModel().getSelectedItem().equalsIgnoreCase("venti")) {
                total = (c.itemPrice() + 1.20) * a;
            }
            subTotal.setText(String.valueOf(df.format(total)));
            if (sweetCream.isSelected()) {
                total = total + 0.30;
            }
            subTotal.setText(String.valueOf(df.format(total)));

            if (frenchVanilla.isSelected()) {
                total = total + 0.30;
            }
            subTotal.setText(String.valueOf(df.format(total)));

            if (irishCream.isSelected()) {
                total = total + 0.30;
            }
            subTotal.setText(String.valueOf(df.format(total)));

            if (caramel.isSelected()) {
                total = total + 0.30;
            }
            subTotal.setText(String.valueOf(df.format(total)));

            if (mocha.isSelected()) {
                total = total + 0.30;
            }
            subTotal.setText(String.valueOf(df.format(total)));
            return total;
        }
        return 0;
    }


    /*private boolean checkErrors(){
        if(!sizeSelect.getSelectionModel().isEmpty() && !quantityCoffee.getSelectionModel().isEmpty()){
            return true;
        }
        if(sizeSelect.getSelectionModel().isEmpty() && quantityCoffee.getSelectionModel().isEmpty()){
            Alert error = new Alert(Alert.AlertType.ERROR);
            error.setTitle("ERROR!");
            error.setContentText("select a size and the quantity");
            error.showAndWait();
            return false;
        }
        if(sizeSelect.getSelectionModel().isEmpty() && !quantityCoffee.getSelectionModel().isEmpty()){
            Alert error = new Alert(Alert.AlertType.ERROR);
            error.setTitle("ERROR!");
            error.setContentText("select a size");
            error.showAndWait();
            return false;
        }
        if(!sizeSelect.getSelectionModel().isEmpty() && quantityCoffee.getSelectionModel().isEmpty()){
            Alert error = new Alert(Alert.AlertType.ERROR);
            error.setTitle("ERROR!");
            error.setContentText("select the quantity.");
            error.showAndWait();
            return false;
        }
        return false;
    }*/

    @FXML
    void addToCart(ActionEvent event){
        if(checkErrors()){
            int a = quantityCoffee.getSelectionModel().getSelectedItem();
            for(int i = 0; i < a; i++){
                Coffee c = new Coffee();
                menuItems.add(c);
            }
            Coffee c = new Coffee();
        }
    }















}
