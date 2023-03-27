package com.example.project4;

public class Coffee extends MenuItem{

    private int size;
    private final static double SHORT_PRICE = 1.89; //base price for a short black coffee
    private final static double SIZE_INCREASE = 0.40; //increase 0.40 for the next cup size
    private final static double ADD_IN = 0.30;  //add-in cost


    /**
     * Constructor to create instance of MenuItem class.
     *
     * @param quantity Quantity field associated with this item.
     */
    public Coffee(int quantity) {
        super(quantity);

    }


}
