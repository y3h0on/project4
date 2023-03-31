package com.example.project4;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
public class MainController {

    @FXML
    private Button coffeeButton;
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    public void switchToCoffeePage(ActionEvent event) throws IOException {
    Parent root = FXMLLoader.load(getClass().getResource("OrderingCoffeeView.fxml"));
    stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
    scene = new Scene(root);
    stage.setScene(scene);
    stage.show();
}

    @FXML
    public void switchToDonutPage(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("OrderingDonutsView.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void switchToBasketPage(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("OrderingBasketView.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void switchToStoreOrderPage(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("StoreOrderView.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }




}