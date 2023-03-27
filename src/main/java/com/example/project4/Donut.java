package com.example.project4;

public class Donut extends MenuItem{


    private String flavor; //flavor of donut
    /**
     * Constructor to initialize the donut's flavor and quantity
     * @param flavor donut's flavor - string field
     * @param quantity inherited from MenuItem class
     */
    public Donut(String flavor, int quantity){
        super(quantity);
        this.flavor = flavor;
    }

    /**
     * this method for calculating the item's price.
     * @return the item's price based on quantity
     */
    @Override
    public double itemPrice(){
        return 0;
    }

    /**
     * Check two donuts are equal
     * @param obj to be compared with Donut
     * @return true if donuts are equals, false otherwise.
     */
    @Override
    public boolean equals(Object obj){
        if( obj instanceof Donut){
            Donut donut = (Donut) obj;
            return donut.flavor.equals((this.flavor));
        }
        return false;
    }

    @Override
    public String toString(){
        return this.flavor + "  " +super.toString();
    }


}
