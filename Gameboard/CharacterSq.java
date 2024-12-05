/*
  Libby, Izma, Farah, Sinchana
  May 29th, 2023
  Character Square Class Page
  This page contains all the code to actually create our Character Square class.
*/
class CharacterSq extends Gameboard implements Sq { 
  //instance variables 
  private String pos = ""; //stores the character's position

  //constructors 
  public CharacterSq (String pos, String symbol) { //creating the square with 2 variables
    super(lgth, wdth, pos);//inhertiting length width and position form gameboad 
    this.pos = pos; //assigining the position of the character to a variable 
    this.color = "\u001B[45m";//the color of the square 
    this.space = "|" + "\u001B[46m" + "        " + "\u001B[0m"; //the outside of the square 
    this.body = "|" + "\u001B[46m" + "   " + symbol + "   " + "\u001B[0m";//the middle of the square 
  }
  //methods 
  public String viewPos() {
    return this.pos;//return the position of the character
  }
}