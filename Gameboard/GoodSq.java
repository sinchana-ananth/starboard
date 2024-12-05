/*
  Libby, Izma, Farah, Sinchana
  May 29th, 2023
  Good Square Class Page
  This page contains all the code to actually create our Good Square class.
*/
class GoodSq extends EventSq implements Sq { 
  
  // instanace variables -------------------------------------------------------- 
  private int sqsFwd = 0; 
  
  // constructors ---------------------------------------------------------------
  public GoodSq (String pos, int sqsFwd) {
    super(lgth, wdth, pos);//inherited of EventSq 
    this.pos = pos; //posiiton of the player 
    this.color = "\u001B[42m"; //color of the square 
    this.sqsFwd = sqsFwd;
    this.eventMsg = "\u001B[32mYay you landed on a good square! you will move " + this.sqsFwd + " squares forward. \u001B[0m";//event message 
    this.space = "|" + "\u001B[42m" + "        " + "\u001B[0m"; //outside spaces of the square
    this.body = "|" + "\u001B[42m" + "   " + pos + "   " + "\u001B[0m"; //middle of the square 
  }

  // methods --------------------------------------------------------------------
  public int moveFwd() {
    return (Integer.parseInt(this.pos) + this.sqsFwd);//player moves forward
  }
  public int moveFwd(int sqsFwdL, int posL) {
    return posL + sqsFwdL;//player moves forward 
  }
  public String viewPos() {
    System.out.println("You are now on square " + (Integer.parseInt(this.pos) + 4));
    return this.pos;//the position of the player 
  }
  public String message()
  {
    return this.eventMsg; //returning the event message 
  }
  protected void directToEvent(String eventName, Character player) {
    
  }
}