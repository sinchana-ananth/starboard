/*
  Libby, Izma, Farah, Sinchana
  May 29th, 2023
  Trouble Square Class Page
  This page contains all the code to actually create our Trouble Square class.
*/
class TroubleSq extends EventSq implements Sq { 
  
  // instanace variables -------------------------------------------------------- 
  private int sqsBack = 0; 
  
  // constructors ---------------------------------------------------------------
  public TroubleSq (String pos, int sqsBack) {
    super(lgth, wdth, pos);//inherited from EventSq
    this.pos = pos;//position of the player 
    this.color = "\u001B[41m";//color of the square 
    this.sqsBack = sqsBack;
    this.eventMsg = "\u001b[31mOh no you landed on a trouble square! you will move " + this.sqsBack + " squares backwards. \u001B[0m";//message to tell player to go back 
    this.space = "|" + "\u001B[41m" + "        " + "\u001B[0m";//space outside the square 
    this.body = "|" + "\u001B[41m" + "   " + pos + "   " + "\u001B[0m";//space in the middle of the square 
  }

  // methods --------------------------------------------------------------------
  public int moveBack() {
    return (Integer.parseInt(this.pos) - this.sqsBack);//return the position after going back a certain number of squares
  }
  public int moveBack(int sqsBackL, int posL) {
    return posL - sqsBackL;//return the position after going back a certain number of squares 
  }

  public String viewPos() {
    System.out.println("You are currently on square " + (Integer.parseInt(this.pos) - 4));
    return this.pos;//return the position the character is on 
  }
  protected void directToEvent(String eventName, Character player) {
    
  }
  public String message()
  {
    return this.eventMsg; //return the event message 
  }
}