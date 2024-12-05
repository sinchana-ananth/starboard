/*
  Libby, Izma, Farah, Sinchana
  May 29th, 2023
  Item Class Page
  This page contains all the code to actually create our Item class.
*/
abstract class Item {
  // instance variable
  public String itemName;//itemName type 
  protected int uses = 0;//number of times itemName is used 

  // methods
  public int getUses() {
    return this.uses;//return the number of uses 
  }
  protected abstract void useItem(Character player);//using the item 
  protected abstract String viewItem();//viewing the item 
}