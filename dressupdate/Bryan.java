package com.example.dressupdate;
//Authors: Kel Knight, Kendall Ward-Hill
//Class: CS265-02
//Date: 12/7/25
//Purpose: this is a subclass that inherits from the superclass, person. it has the appropriate get and set methods, utilizes stack, and displays polymorphism by overriding the
//to string method
import java.util.Stack;
public class Bryan extends Person {
    private String symbol,name,species;
    Stack<String> bryStack = new Stack<>();
    public Bryan(){
        super();
        symbol = " ";
        name=" ";
        species=" ";
    }
    public Bryan(String shirts, String pant, String shoe, String symbols, String bName, String bSpecies) {
        super(shirts, pant, shoe);
        this.symbol = symbols;
        this.name = bName;
        this.species = bSpecies;
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
    public void setName(String nameb) {
        this.name = nameb;
    }
    public String getSpecies() {
        return species;
    }
    public void setSpecies(String speciesb) {
        this.species = speciesb;
    }
    public void pushStack(String element){
        bryStack.push(element);
        System.out.println("The push was sucessful. " + element  + " was pushed to: " + bryStack);
    }
    public String popStack(){
        if(!bryStack.isEmpty()){
            String removed = bryStack.pop();
            System.out.println("The removed item was: " + removed);
            return removed;
        }
        System.out.println("The stack is empty.");
        return null;
    }
    public Stack<String> getbryStack() {
        return bryStack;
    }
    public boolean isEmpty(){
        return bryStack.isEmpty();
    }
    @Override
    public String toString() {
        return super.toString() + "Bryan's info [symbol = " + symbol + ", name = " + name + ", species = " + species + "]\n"
                + "The stack(current outfit) is: " + bryStack;
    }
}
