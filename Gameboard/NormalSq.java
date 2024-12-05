/*
  Libby, Izma, Farah, Sinchana
  May 29th, 2023
  Normal Square Class Page
  This page contains all the code to actually create our Normal Square class.
*/
class NormalSq extends Gameboard implements Sq { 
  // instance variables
  private String pos = "";

  // constructors
  public NormalSq(String pos)
  {
    super(lgth, wdth, pos);//inhertied from Gameboard 
    this.pos = pos;//position of square 
    this.space = "|" + "\u001B[47m" + "        " + "\u001B[0m";//outside of square 
    this.body = "|" + "\u001B[47m" + "   " + pos + "   " + "\u001B[0m";//middle of the square 
  }

  //methods 
  protected String nextTurn()
  {
    return "Your turn has ended. It is the next player's turn";//telling the user their turn is over 
  }
  public String getPos() {
    return this.pos;//the position of the square 
  }
  public String viewPos() {
    System.out.println("You are currently on square " + this.pos);
    return this.pos;//returning the position of the square 
  }
}