package com.example.dressupdate;
//Authors: Kel Knight, Kendall Ward-Hill
//Class: CS265-02
//Date: 12/7/25
//Purpose: this is a subclass to the super class person, it also utilizes queue and shows polymorphism by overriding the to string method
//there are get and set methods too
import java.util.Queue;
import java.util.LinkedList;

public class Sunshine extends Person {
    private String symbol, name, occupation;
    private Queue<String> sunQueue;
    public Sunshine() {
        super();
        symbol = " ";
        name=" ";
        occupation=" ";
        this.sunQueue = new LinkedList<>();
    }
    public Sunshine(String shirts, String pant, String shoe, String sSymbol, String sName, String sOccupation) {
        super(shirts, pant, shoe);
        this.symbol = sSymbol;
        this.name = sName;
        this.occupation = sOccupation;
    }
    public String getSymbol() {
        return symbol;
    }
    public void setSymbol(String symbols) {
        this.symbol = symbols;
    }
    public String getName() {
        return name;
    }
    public void setName(String sName) {
        this.name = sName;
    }
    public String getOccupation() {
        return occupation;
    }
    public void setOccupation(String sOccupation) {
        this.occupation = sOccupation;
    }
    public void addQueue(String element){
        sunQueue.add(element);
    }
    public String removeQueue(){
        if(!sunQueue.isEmpty()){
            String removed = sunQueue.remove();
            System.out.println("The removed item was: " + removed);
            return removed;
        }
        System.out.println("The queue is empty.");
        return null;
    }
    public Queue<String> getSunQueue() {
        return sunQueue;
    }
    public boolean isEmpty(){
        return sunQueue.isEmpty();
    }
    @Override
    public String toString() {
        return super.toString() + "Sunshine's info [symbol = " + symbol + ", name = " + name + ", occupation = " + occupation + "]\n"
                + "The queue(current outfit) is: " + sunQueue;
    }
}
