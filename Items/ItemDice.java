/*
  Libby, Izma, Farah, Sinchana
  May 29th, 2023
  Item Dice Class Page
  This page contains all the code to actually create our Item Dice class.
*/
class ItemDice extends Dice {
  // instance variables
  private static final String[] ITEMLIST = {"Double Dice", "Swapster", "Banana Peel", "Immunity Potion"};//array of the items 

  // constructors
  public ItemDice() {
    this.maxValue = 4;//max number of the dice 
    itemName = "ItemDice";//type of itemName 
  }
  
  // methods
  public String getRolledItem() {
    return ITEMLIST[this.rNum];//return a random number of the ITEMLIST 
  }
  public int rollDice() {
    this.rNum = r.nextInt(maxValue - 1) + 1;//random number for the dice 
    System.out.println("The rolled item is " + ITEMLIST[rNum]); //displaying the rolled item 
    return rNum;//returning the random item 
  }
  protected void useItem(Character player) {
    
  }
  protected String viewItem() {
    return "This is an item dice. It is a type of dice that after being rolled will determine what item is given";//viewing this item 
  }
}