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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.File;
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
    private MainController mainController = new MainController();
    @FXML
    private ImageView donutImage;

    ArrayList<MenuItem> orderList = new ArrayList<>();
    ArrayList<yeastDonut> listOfYeastDonuts = new ArrayList<>();
    ArrayList<cakeDonut> listOfCakeDonuts = new ArrayList<>();
    ArrayList<donutHoles> listOfDonutHoles = new ArrayList<>();


    public void setMainController(MainController controller) {
        mainController = controller;
    }

    public void initialize(){
        colorList = FXCollections.observableArrayList("Yeast Donuts", "Cake Donuts", "Donut Holes");
        donutSelect.setItems(colorList);
        yeastList =  FXCollections.observableArrayList("glazed Donuts" , "frosted Donuts", "rainbow Donuts", "chocolate Donuts");
        cakeList =  FXCollections.observableArrayList("powdered Donuts" , "apple sliced", "rainbow sprinkles", "chocolate covered");
        donutHoleList = FXCollections.observableArrayList("churro Donut" , "Nutella Donut", "peanut butter", "chocolate glazed");
        numberList = FXCollections.observableArrayList(1, 2, 3, 4, 5, 6);
        quantity.setItems(numberList);
        containsQuantityDonut = FXCollections.observableArrayList();
        Order order = new Order(0, orderList);

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
            File file = new File("yeastDonut.jpg");
            Image image1 = new Image(file.toURI().toString());
            donutImage.setImage(image1);
            flavorList.setItems(yeastList);
        }
        if(donutSelect.getSelectionModel().getSelectedItem().equalsIgnoreCase("Cake Donuts")){
            File file = new File("cakeDonut.jpg");
            Image image1 = new Image(file.toURI().toString());
            donutImage.setImage(image1);
            flavorList.setItems(cakeList);
        }
        if(donutSelect.getSelectionModel().getSelectedItem().equalsIgnoreCase("Donut Holes")){
            File file = new File("donutHole.jpg");
            Image image1 = new Image(file.toURI().toString());
            donutImage.setImage(image1);
            flavorList.setItems(donutHoleList);
        }

    }


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
        if(!donutSelect.getSelectionModel().isEmpty()) {
            if (!quantity.getSelectionModel().isEmpty()) {
                if (donutSelect.getSelectionModel().getSelectedItem().equalsIgnoreCase("Yeast Donuts")) {
                    if (!flavorList.getSelectionModel().isEmpty()) {
                        int b = quantity.getSelectionModel().getSelectedItem();
                        for (int i = 0; i < b; i++) {
                            yeastDonut z = new yeastDonut();
                            listOfYeastDonuts.add(z);
                            orderList.add(z);
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

                if (donutSelect.getSelectionModel().getSelectedItem().equalsIgnoreCase("Cake Donuts")) {
                    if (!flavorList.getSelectionModel().isEmpty()) {
                        int b = quantity.getSelectionModel().getSelectedItem();
                        for (int i = 0; i < b; i++) {
                            cakeDonut v = new cakeDonut();
                            listOfCakeDonuts.add(v);
                            orderList.add(v);
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

                if (donutSelect.getSelectionModel().getSelectedItem().equalsIgnoreCase("Donut Holes")) {
                    if (!flavorList.getSelectionModel().isEmpty()) {
                        int b = quantity.getSelectionModel().getSelectedItem();
                        for (int i = 0; i < b; i++) {
                            donutHoles x = new donutHoles();
                            listOfDonutHoles.add(x);
                            orderList.add(x);
                        }
                        int a = flavorList.getSelectionModel().getSelectedIndex();
                        String c = flavorList.getSelectionModel().getSelectedItem();
                        donutHoleList.remove(a);
                        flavorList.setItems(donutHoleList);
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
            } else {
                Alert error = new Alert(Alert.AlertType.ERROR);
                error.setTitle("ERROR!");
                error.setContentText("select a quantity.");
                error.showAndWait();
            }

        }else{
            Alert error = new Alert(Alert.AlertType.ERROR);
            error.setTitle("ERROR!");
            error.setContentText("select a donut Type");
            error.showAndWait();
        }
    }


    @FXML
    void remove(ActionEvent event){
        if(!finalList.getSelectionModel().isEmpty()){
            String a = finalList.getSelectionModel().getSelectedItem();
            String[] b = a.split(" ");
            String temp = b[1] + " " +b[2];
            int num = Integer.parseInt(b[0]);
            subTotal.setText(temp);

            if(temp.equalsIgnoreCase("glazed Donuts") || temp.equalsIgnoreCase("frosted Donuts") || temp.equalsIgnoreCase("rainbow Donuts") || temp.equalsIgnoreCase("chocolate Donuts")  ){
                for(int i = 0; i < num; i++){
                    listOfYeastDonuts.remove(listOfYeastDonuts.size()-1);
                    listOfYeastDonuts.trimToSize();
                }
                containsQuantityDonut.remove(a);
                yeastList.add(b[1] + " " + b[2]);
                flavorList.setItems(yeastList);
                subTotal.setText(String.valueOf(calculateAmount()));
            }


            if(temp.equalsIgnoreCase("powdered Donuts") || temp.equalsIgnoreCase("apple sliced") || temp.equalsIgnoreCase("rainbow sprinkles") || temp.equalsIgnoreCase("chocolate covered")  ){
                for(int i = 0; i < num; i++){
                    listOfCakeDonuts.remove(listOfCakeDonuts.size()-1);
                    listOfCakeDonuts.trimToSize();
                }
                containsQuantityDonut.remove(a);
                cakeList.add(b[1] + " " + b[2]);
                flavorList.setItems(cakeList);
                subTotal.setText(String.valueOf(calculateAmount()));
            }

            if(temp.equalsIgnoreCase("churro Donut") || temp.equalsIgnoreCase("Nutella Donut") || temp.equalsIgnoreCase("peanut butter") || temp.equalsIgnoreCase("chocolate glazed")  ){
                for(int i = 0; i < num; i++){
                    listOfDonutHoles.remove(listOfDonutHoles.size()-1);
                    listOfDonutHoles.trimToSize();
                }
                containsQuantityDonut.remove(a);
                donutHoleList.add(b[1] + " " + b[2]);
                flavorList.setItems(donutHoleList);
                //set it to the respective type of donut here its donut holes
                subTotal.setText(String.valueOf(calculateAmount()));
            }
        }else{
            Alert error = new Alert(Alert.AlertType.ERROR);
            error.setTitle("ERROR!");
            error.setContentText("no donuts to remove from cart!");
            error.showAndWait();
        }
    }

    /*public double getCost(String a){
        if()
    }*/


    @FXML
    void addToOrder(ActionEvent event){
        Order order = new Order(0, orderList);

        if(!finalList.getItems().isEmpty()){
            yeastDonut y = new yeastDonut();
            donutHoles d = new donutHoles();
            cakeDonut c = new cakeDonut();
            for (String name: containsQuantityDonut){
                mainController.getList().add(name);
            }
            mainController.getMoreList().add(calculateAmount());

        }else{
            Alert error = new Alert(Alert.AlertType.ERROR);
            error.setTitle("ERROR!");
            error.setContentText("nothing to add to the cart.");
            error.showAndWait();
        }
    }











}
