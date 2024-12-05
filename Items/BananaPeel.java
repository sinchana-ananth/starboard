/*
  Libby, Izma, Farah, Sinchana
  May 29th, 2023
  Banana Peel Class Page
  This page contains all the code to actually create our Banana Peel class.
*/
class BananaPeel extends Item { 
  // instance variables 
  private Dice d1 = new Dice();
  
  // constructors
  public BananaPeel() {
    itemName = "Banana Peel"; //itemname 
    uses++; //uses increases 
  }

  // methods 
  protected void useItem(Character player) {
    System.out.println(player.getName() + " has used the item: " + this.itemName + "!"); //the player has used the item 
    uses--; //uses decreases 
  }
  
  protected String viewItem()
  {
    return "This is a Banana Peel! You can use this to gain 3 points!  "; //output what this item is 
  }
}
