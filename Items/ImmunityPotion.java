/*
  Libby, Izma, Farah, Sinchana
  May 29th, 2023
  Immunity Potion Class Page
  This page contains all the code to actually create our Immunity Potion class.
*/
class ImmunityPotion extends Item { 

  //consttructors
  ImmunityPotion () {
    itemName = "Immunity Potion"; //itemName type  
    uses++; //uses increases 
  }

  //methods 
  protected void useItem(Character player) {
    System.out.println(player.getName() + " has used the item: " + this.itemName);//if player has used this item 
    uses--; //uses decreases 
  }
  
  protected String viewItem()
  {
    return "This is an immunity potion! You can use this item to grant yourself immunity to losing points from the mini games! "; //view what this item does 
  }
}