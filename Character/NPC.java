/*
  Libby, Izma, Farah, Sinchana
  May 29th, 2023
  NPC Class Page
  This page contains all the code to actually create our NPC class.
*/
import java.util.*;
class NPC extends Character { //child class

  //INSTANCE VARIABLES
  protected String characterName = "AICrusher"; //default name
  protected String symbol = "🤖"; //default symbol
  private String specialFeatures = "AI Manipulation"; //default features
  private String winningDialouge = "Your fellow AI bot has DEFEATED you! MWAHAHAHAHAHA!"; //winning dialouge
  private String losingDialouge = "NOOOOO!!! Watch out human, AI will take over the world one day!"; //losing dialouge

  //CONSTRUCTORS
  NPC() { //if no parameters are provided, a player will be constructed with default characteristics
    super();
  }
  NPC(String type, String name) { //creating the NPC with 2 parameters
    super(type, name);
  }
  NPC(String type, String name, String symbol) { //creating the NPC with 3 parameters
    super(type, name, symbol);
  }
}