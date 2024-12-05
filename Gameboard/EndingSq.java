/*
  Libby, Izma, Farah, Sinchana
  May 29th, 2023
  Ending Square Class Page
  This page contains all the code to actually create our Ending Square class.
*/
class EndingSq extends Gameboard implements Sq {
  // instance variables
  private String pos = ""; //stores the character's position

  // constructors
  /*public EndingSq(int pos) {
    this.pos = pos;
    this.length = lgth;
    this.width = wdth;
  }*/
  public EndingSq(String pos) { //creating the ending square with 1 parameter
    super(lgth, wdth, pos);//inhertit from gameboard 
    this.pos = pos; //assigining the position of the character to a variable 
    this.color = "\u001B[46m"; //color of square 
    this.space = "|" + "\u001B[41m" + "        " + "\u001B[0m"; //outside of square 
    this.body = "|" + "\u001B[41m" + "   " + pos + "  " + "\u001B[0m"; //middle of square 
  }

  // methods
  public String viewPos() {
    return this.pos;//return and view the position of the player 
  }
}