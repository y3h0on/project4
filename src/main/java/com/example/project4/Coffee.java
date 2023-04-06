package com.example.project4;

import java.util.ArrayList;

public class Coffee extends MenuItem{

    private String cupSize;
    private ArrayList<String> addIns;


    public Coffee(){
        this.cupSize=null;
        this.addIns = null;
    }
    public Coffee(String cupSize, ArrayList<String> addIns){
        this.cupSize=cupSize;
        this.addIns=addIns;
    }

    @Override
    public double itemPrice() {
        return 1.89;}


    @Override
    public String toString(){
        String a = "";
        for(String name: addIns){
            a = a + name + " ";
        }
        return cupSize + " ( "+ a + ")";
    }





}
