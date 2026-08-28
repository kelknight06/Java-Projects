package com.example.dressupdate;
//Authors: Kel Knight, Kendall Ward-Hill
//Class: CS265-02
//Date: 12/7/25
//Purpose: this is the superclass for the two subclasses. the instance variables are inhereited by default however, they become replaced
//with get and set methods according to what clothing piece is chosen. the to string sets the format for console display
public class Person {
    protected String shirt,pants,shoes;
    public Person() {
        shirt = " ";
        pants = " ";
        shoes = " ";
    }
    public Person(String shirts, String pant, String shoe) {
        this.shirt = shirts;
        this.pants = pant;
        this.shoes = shoe;
    }
    public String getShirt() {
        return shirt;
    }
    public void setShirt(String shirts) {
        this.shirt = shirts;
    }
    public String getPants() {
        return pants;
    }
    public void setPants(String pant) {
        this.pants = pant;
    }
    public String getShoes() {
        return shoes;
    }
    public void setShoes(String shoe) {
        this.shoes = shoe;
    }
    @Override
    public String toString() {
        return "\nThe outfit\n----------\nShirt: " + shirt + " \tPants:  " + pants + "\tShoes: " + shoes + "\n";
    }
}
