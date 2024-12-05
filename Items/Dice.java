/*
  Libby, Izma, Farah, Sinchana
  May 29th, 2023
  Dice Class Page
  This page contains all the code to actually create our Dice class.
*/
import java.util.*;
class Dice extends Item {
  // variable declarations
  protected int maxValue = 0;
  public Random r = new Random();
  protected int rNum;
  
  // constructors
  public Dice() {
    this.maxValue = 6; // maxvalue fo dice 
    itemName = "Dice"; //type of itemname 
    uses++; //uses increases 
    
  }
  public Dice(int maxValue) {
    this.maxValue = maxValue; //maxvalue of dice 
    itemName = "Dice"; //type of itemname 
    uses++; //uses increases 
  }
  // methods
  public int getRNum() {
    return this.rNum;//return the random number 
  }
  public int rollDice() {
    this.rNum = r.nextInt(maxValue - 1) + 1; //get the random item 
    System.out.println("You rolled a " + rNum);//the number the user rolled 
    return rNum; //return the rolled item 
  }
  protected void useItem(Character player) {
    
  }
  protected String viewItem() {
    return "This is a dice. It rolls a random number from 1 to the maximum number"; //return what this item does 
  }
}