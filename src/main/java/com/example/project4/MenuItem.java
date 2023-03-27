package com.example.project4;

public  class MenuItem {

    private int quantity;
    private double totalPrice;

    /**
     * Constructor to create instance of MenuItem class.
     * @param quantity Quantity field associated with this item.
     */
    public MenuItem(int quantity){
        this.quantity = quantity;
    }


    /**
     * this method for calculating the item's price.
     * @return the itme's price based on quantity
     */
    public double itemPrice(){  //subclasses must implements this
        return 0;
    }

    /**
     * Getter method to get a quantity of item
     * @return quantity of the menuItem
     */
    public int getQuantity(){
        return this.quantity;
    }

    /**
     * setter method to update the total price of the menuItem
     * @param price is the new price to update the item price with menuItem.
     */
    public void setTotalPrice(double price){
        this.totalPrice = price;
    }
    /**
     * Getter mothod to get a total price of items
     * @return total price of the menuItem
     */
    public double getTotalPrice(){
        return this.totalPrice;
    }

    /**
     * update the quantity of items and get a total price and quantity that chose by user
     * @param quantityOfItem is the amount of the menuItem chose by user.
     */
    public void update(int quantityOfItem){
        this.totalPrice += quantityOfItem * (this.totalPrice / quantity);
        this.quantity += quantityOfItem;
    }

    /**
     * override method to print the # of quantity
     * @return this.quantity
     */
    @Override
    public String toString(){
        return "Quantity: " +this.quantity;
    }

}
