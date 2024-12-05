/*
  Libby, Izma, Farah, Sinchana
  May 29th, 2023
  Character Class Page
  This page contains all the code to actually create our Character class.
*/
import java.util.*; // importing java.util
class Character { //parent class

  //INSTANCE VARIABLES
  protected boolean useItem = false; //checks to see if the character uses an item
  protected String typeOfCharacter = null; //assigns a type of character
  protected String characterName = null; //stores the character's name
  protected String symbol = "s"; //stores the character's emoji
  public Random r = new Random(); //stores a random generated number
  protected int rSymbol = 0; //stores the option for a symbol
  private String specialFeatures = null; //stores the special features of that character
  private int position = 0; //stores the position of the character
  private String winningDialouge = null; //stores the winning dialouge of the character
  private String losingDialouge = null; //stores the losing dialouge of the character 
  private int[] inventory = new int[5]; //stores the inventory of the character
  static private int numberOfPlayers = 0; //stores the number of players
  public static final String[] ITEMLIST = {"Double Dice", "Swapster", "Banana Peel", "Immunity Potion"}; //stores the item list 
  
  //CONSTRUCTORS
  Character() { //if no parameters are provided, a player will be constructed with default characteristics
    this.typeOfCharacter = "Player"; //default type
    this.characterName = "Unkown Player"; //default name
    this.symbol = "🧟"; //default symbol
  }
  Character(String type, String name) { //when 2 parameters are provided
    this.typeOfCharacter = type; //type given in parameters
    this.characterName = name; //name given in parameters
    this.symbol = "🧟"; //default symbol
  }
  Character(String type, String name, String symbol) { //when 3 parameters are provided
    this.typeOfCharacter = type; //type given in parameters
    this.characterName = name; //name given in parameters
    this.symbol = symbol; //symbol given in parameters
  }
  
  //ACCESS METHODS
  public String getType() {return this.typeOfCharacter;} //access the type of character
  public String getName() {return this.characterName;} //access the name of character
  public String getSymbol() {return this.symbol;} //access the character's symbol
  public int getPosition() {return this.position+1;} //access the position of character
  public String getSpecialFeatures() {return this.specialFeatures;} //access special features of the character
  public String getWinningDialouge() {return this.winningDialouge;} //access the winning dialouge
  public String getLosingDialouge() {return this.losingDialouge;} //access the losing dialouge
  public int getInventory(int inx) {return this.inventory[inx];} //access the inventory
  public int getNumOfPlayers() {return this.numberOfPlayers;} //access the number of players
  public String getITEMLIST(int x) {return this.ITEMLIST[x];}

  //METHODS
  public int move(int rolledNum) { //method to move characters on the board
    position += rolledNum; //from their current position, move them the number of steps stated on the dice
    return this.position; //return the new position
  }
  public int moveTo(int newPos) { //method to move characters on the board from a particular position
    return this.position = newPos; //set the old position equal to new position
  }
  public void giveItem(Character player, String itemName) { //method to give a character an item
    for(int x = 0; x < 4; x++) { //for loop to run 6 times
      if(ITEMLIST[x].equals(itemName)) { //checks to see which position the itemName belongs to in the ITEMLIST array
        System.out.println("Item: " + itemName + " has been added to " + player + "'s inventory."); //message to let character know that the item is added
        player.inventory[x]++;
        break;
      }
    }
  }
  public void useItem(Character pers, String itemName, Item item1) { //method to allow character to use item (with 3 parameters)
    item1.viewItem(); // run the item's method viewItem to display information about the item
    for(int x = 0; x < 4; x++) { 
      if(ITEMLIST[x].equals(itemName) && this.inventory[x] > 0) {
        item1.useItem(pers); 
        this.inventory[x]--;
        useItem = true; 
      }
      if(ITEMLIST[x].equals(itemName) && this.inventory[x] < 1) {
        System.out.println("Uh Oh! You don't have any of this item in your inventory! "); 
        useItem = false; 
      }
    }
  }

  public boolean useItemDisplay() { 
    return this.useItem; 
  }

  public void useItem(Character pers, Item item1) { //method to allow character to use item (with 2 parameters)
    item1.useItem(pers); 
    for(int x = 0; x < 4; x++)
      if(ITEMLIST[x].equals(item1.itemName) && this.inventory[x] > 0) 
        this.inventory[x]--; 
  }
}