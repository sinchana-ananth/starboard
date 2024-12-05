/*
  Libby, Izma, Farah, Sinchana
  May 29th, 2023
  Swapster Class Page
  This page contains all the code to actually create our Swapster class.
*/
class Swapster extends Item {
  //instance variables 
  // constructors
  public Swapster() {
    itemName = "Swapster"; //type of itemName 
    uses++; //uses increases 
  }
  // methods
  protected void useItem(Character player) {
    System.out.println(player.getName() + " has used the item: " + this.itemName + ". 2 Players have been swapped!");//the item that has been uses 
    uses--; //uses decreases 
  }

  /* 
  protected void useItem
  */ 
  protected String viewItem()
  {
    return "This is a Swapster. You can use it to swap places on the board with another person. "; //viewing this item 
  }
}