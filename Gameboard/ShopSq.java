/*
  Libby, Izma, Farah, Sinchana
  May 29th, 2023
  Shop Square Class Page
  This page contains all the code to actually create our Shop Square class.
*/
class ShopSq extends EventSq implements Sq { 
  
  // instanace variables -------------------------------------------------------- 
  private int sqsBack = 0; 
  ItemDice dShop = new ItemDice(); //create a new item dice object  
  
  // constructors ---------------------------------------------------------------
  public ShopSq (String pos) {
    super(lgth, wdth, pos);//inhertited from EventSq
    this.pos = pos;//current position 
    this.color = "\u001B[43m";//color of square 
    this.eventMsg = "\u001B[35mYou landed on a Shop Square! Here you can get a random item! \u001B[0m"; //event message 
    this.space = "|" + "\u001B[45m" + "        " + "\u001B[0m"; //outside space of the square 
    this.body = "|" + "\u001B[45m" + "   " + pos + "   " + "\u001B[0m"; //middle body of the square 
  }

  // methods --------------------------------------------------------------------
  public String buyItem() {
    dShop.rollDice(); //roll the dice 
    return dShop.getRolledItem(); //get the rolled item 
    
  }
  
  public String viewPos() {
    System.out.println("You are currently on square " + this.pos);
    return this.pos;//return the current position 
  }
  protected void directToEvent(String eventName, Character player) {
    
  }
  public String message()
  {
    return this.eventMsg; //return the event message 
  }
}
