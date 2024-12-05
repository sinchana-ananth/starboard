/*
  Libby, Izma, Farah, Sinchana
  May 29th, 2023
  Character Class Page
  This page contains all the code to actually create our Character class.
*/
import java.util.*;
class Player extends Character { //child class

  //INSTANCE VARIABLES
  private String specialFeatures = "Player Power"; //default features
  private String winningDialouge = "I, " + characterName + ", have won this round! HOORAY!"; //winning dialouge
  private String losingDialouge = "Sadly, I have lost."; //losing dialouge
  
  //CONSTRUCTORS
  Player() { //if no parameters are provided, a player will be constructed with default characteristics
    super();
  }
  Player(String type, String name) { //creating the player with 2 parameters
    super(type, name);
  }
  Player(String type, String name, String symbol) { //creating the player with 3 parameters
    super(type, name, symbol);
  }
}