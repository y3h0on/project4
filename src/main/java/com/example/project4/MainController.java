package com.example.project4;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class MainController {

    @FXML
    private Button coffeeButton;
    private Stage stage;
    private Scene scene;
    private Parent root;

    private ArrayList<String> items = new ArrayList<>();
    private ArrayList<Double> costOfCoffee = new ArrayList<>();

    public ArrayList getList(){
        return items;
    }
    public ArrayList getMoreList(){return costOfCoffee;}

    @FXML
    protected void switchToCoffeePage() {
        Stage view1 = new Stage();
        VBox root;
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("OrderingCoffeeView.fxml"));
            root = (VBox) loader.load();
            Scene scene = new Scene(root, 700, 700);
            view1.setScene(scene);
            view1.show();
            CoffeeController coffeeController = loader.getController();
            /*
              The statement below is to pass the reference of the MainController object
              to the View1Controller object so the View1Controller can call the
              public methods in the MainController.
             */
            coffeeController.setMainController(this);
        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setHeaderText("Loading View1.fxml.");
            alert.setContentText("Couldn't load View1.fxml.");
            alert.showAndWait();
        }
    }

    /*@FXML
    public void switchToDonutPage(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("OrderingDonutsView.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }*/
    @FXML
    protected void switchToDonutPage() {
        Stage view1 = new Stage();
        VBox root;
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("OrderingDonutsView.fxml"));
            root = (VBox) loader.load();
            Scene scene = new Scene(root, 700, 700);
            view1.setScene(scene);
            view1.show();
            DonutController donutController = loader.getController();
            /*
              The statement below is to pass the reference of the MainController object
              to the View1Controller object so the View1Controller can call the
              public methods in the MainController.
             */
            donutController.setMainController(this);
        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setHeaderText("Loading View1.fxml.");
            alert.setContentText("Couldn't load View1.fxml.");
            alert.showAndWait();
        }
    }




    @FXML
    protected void switchToBasketPage() {
        Stage view1 = new Stage();
        VBox root;
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("OrderingBasketView.fxml"));
            root = (VBox) loader.load();
            Scene scene = new Scene(root, 700, 700);
            view1.setScene(scene);
            view1.show();
            BasketController basketController = loader.getController();
            basketController.displayName(items, costOfCoffee);
            /*
              The statement below is to pass the reference of the MainController object
              to the View1Controller object so the View1Controller can call the
              public methods in the MainController.
             */
            basketController.setMainController(this);
        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setHeaderText("Loading View1.fxml.");
            alert.setContentText("Couldn't load View1.fxml.");
            alert.showAndWait();
        }
    }
    /*@FXML
    public void switchToBasketPage(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("OrderingBasketView.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }*/

    @FXML
    public void switchToStoreOrderPage(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("StoreOrderView.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }



    /*@FXML
    protected void display(ActionEvent event){
        System.out.println(items.size());
        for(String name : items){
            System.out.println(name);
        }
    }*/










}