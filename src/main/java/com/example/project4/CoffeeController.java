package com.example.project4;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

import java.io.IOException;

public class CoffeeController {


    private ObservableList<Integer> numberList;
    private ObservableList<String> sizeList;
    @FXML
    private ComboBox<Integer> quantityCoffee;
    @FXML
    private ComboBox<String> sizeSelect;

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
}
