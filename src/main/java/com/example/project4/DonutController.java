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
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.ArrayList;

public class DonutController {
    @FXML
    private ComboBox<String> donutSelect;
    @FXML
    private ComboBox<Integer> quantity;
    @FXML
    private ListView<String> flavorList;
    @FXML
    private ListView<String> finalList;  // has quantity and which donuts
    private ObservableList<String> colorList;
    private ObservableList<String> yeastList;
    private ObservableList<String> cakeList;
    private ObservableList<String> donutHoleList;
    private ObservableList<Integer> numberList;
    private ObservableList<String> containsQuantityDonut;
    @FXML
    private TextField subTotal;

    ArrayList<yeastDonut> listOfYeastDonuts = new ArrayList<>();
    ArrayList<cakeDonut> listOfCakeDonuts = new ArrayList<>();
    ArrayList<donutHoles> listOfDonutHoles = new ArrayList<>();

    public void initialize(){
        colorList = FXCollections.observableArrayList("Yeast Donuts", "Cake Donuts", "Donut Holes");
        donutSelect.setItems(colorList);
        yeastList =  FXCollections.observableArrayList("glazed Donuts" , "frosted Donuts", "rainbow sprinkles Donuts", "chocolate glazed Donuts");
        cakeList =  FXCollections.observableArrayList("powdered Donuts" , "apple sliced Donuts", "rainbow sprinkles Donuts", "chocolate covered Donuts");
        donutHoleList = FXCollections.observableArrayList("churro Donut Holes" , "Nutella Donut Holes", "peanut butter Donut Holes", "chocolate glazed Donut Holes");
        numberList = FXCollections.observableArrayList(1, 2, 3, 4, 5, 6);
        quantity.setItems(numberList);
        containsQuantityDonut = FXCollections.observableArrayList();

    }


    @FXML
    public void switchToMainPage(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("main-view.fxml"));
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    @FXML
    public void displayDonuts(ActionEvent event){
        if(donutSelect.getSelectionModel().getSelectedItem().equalsIgnoreCase("Yeast Donuts")){
            flavorList.setItems( yeastList);
        }
        if(donutSelect.getSelectionModel().getSelectedItem().equalsIgnoreCase("Cake Donuts")){
            flavorList.setItems(cakeList);
        }
        if(donutSelect.getSelectionModel().getSelectedItem().equalsIgnoreCase("Donut Holes")){
            flavorList.setItems(donutHoleList);
        }

    }

    /*public String kindOfDonut(){
        if(donutSelect.getSelectionModel().getSelectedItem().equalsIgnoreCase("Yeast Donuts")){
            return "Yeast Donut";
        }
        if(donutSelect.getSelectionModel().getSelectedItem().equalsIgnoreCase("Cake Donuts")){
            return "Cake Donut";
        }
        if(donutSelect.getSelectionModel().getSelectedItem().equalsIgnoreCase("Donut Holes")){
            return "Donut Holes";
        }
        return null;
    }*/

    private double calculateAmount(){
        int a = listOfYeastDonuts.size();
        int b = listOfDonutHoles.size();
        int c  = listOfCakeDonuts.size();
        yeastDonut y = new yeastDonut();
        cakeDonut u = new cakeDonut();
        donutHoles h = new donutHoles();

        double amount = (a*y.itemPrice()) + (b*h.itemPrice()) + (c*u.itemPrice());
        return amount;
    }

    @FXML
    void add(ActionEvent event){
        if(donutSelect.getSelectionModel().getSelectedItem().equalsIgnoreCase("Yeast Donuts")) {
            if (!flavorList.getSelectionModel().isEmpty()) {
                int b = quantity.getSelectionModel().getSelectedItem();
                for (int i = 0; i < b; i++) {
                    yeastDonut z = new yeastDonut();
                    listOfYeastDonuts.add(z);
                }
                int a = flavorList.getSelectionModel().getSelectedIndex();
                String c = flavorList.getSelectionModel().getSelectedItem();
                yeastList.remove(a);
                flavorList.setItems(yeastList);
                String j = b + " " + c;
                containsQuantityDonut.add(j);
                finalList.setItems(containsQuantityDonut);
            } else {
                Alert error = new Alert(Alert.AlertType.ERROR);
                error.setTitle("ERROR!");
                error.setContentText("select a different type of donut.");
                error.showAndWait();
            }
            subTotal.setText(String.valueOf(calculateAmount()));
        }
            if(donutSelect.getSelectionModel().getSelectedItem().equalsIgnoreCase("Cake Donuts")) {
                if (!flavorList.getSelectionModel().isEmpty()) {
                    int b = quantity.getSelectionModel().getSelectedItem();
                    for (int i = 0; i < b; i++) {
                        cakeDonut v = new cakeDonut();
                        listOfCakeDonuts.add(v);
                    }
                    int a = flavorList.getSelectionModel().getSelectedIndex();
                    String c = flavorList.getSelectionModel().getSelectedItem();
                    cakeList.remove(a);
                    flavorList.setItems(cakeList);
                    String j = b + " " + c;
                    containsQuantityDonut.add(j);
                    finalList.setItems(containsQuantityDonut);
                } else {
                    Alert error = new Alert(Alert.AlertType.ERROR);
                    error.setTitle("ERROR!");
                    error.setContentText("select a different type of donut.");
                    error.showAndWait();
                }
                subTotal.setText(String.valueOf(calculateAmount()));
            }
                if(donutSelect.getSelectionModel().getSelectedItem().equalsIgnoreCase("Donut Holes")){
                    if(!flavorList.getSelectionModel().isEmpty()) {
                        int b = quantity.getSelectionModel().getSelectedItem();
                        for (int i = 0; i < b; i++) {
                            donutHoles x = new donutHoles();
                            listOfDonutHoles.add(x);
                        }
                        int a = flavorList.getSelectionModel().getSelectedIndex();
                        String c = flavorList.getSelectionModel().getSelectedItem();
                        donutHoleList.remove(a);
                        flavorList.setItems(donutHoleList);
                        String j = b + " " + c;
                        containsQuantityDonut.add(j);
                        finalList.setItems(containsQuantityDonut);
                    }else{
                        Alert error = new Alert(Alert.AlertType.ERROR);
                        error.setTitle("ERROR!");
                        error.setContentText("select a different type of donut.");
                        error.showAndWait();
                    }
                    subTotal.setText(String.valueOf(calculateAmount()));
                }
    }


    @FXML
    void remove(ActionEvent event){
        if(!finalList.getSelectionModel().isEmpty()){
            if(donutSelect.getSelectionModel().getSelectedItem().equalsIgnoreCase("Yeast Donuts")){
                String a = finalList.getSelectionModel().getSelectedItem();
                String[] b = a.split(" ");
                int k = listOfYeastDonuts.size()-1;
                listOfYeastDonuts.clear();
                containsQuantityDonut.remove(a);
                yeastList.add(b[1] + " " + b[2]);
                flavorList.setItems(yeastList);
                subTotal.setText(String.valueOf(calculateAmount()));
            }





        }else{
            Alert error = new Alert(Alert.AlertType.ERROR);
            error.setTitle("ERROR!");
            error.setContentText("no donuts to remove from cart!");
            error.showAndWait();
        }
    }






}
