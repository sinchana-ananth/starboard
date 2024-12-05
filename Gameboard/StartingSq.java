/*
  Libby, Izma, Farah, Sinchana
  May 29th, 2023
  Starting Square Class Page
  This page contains all the code to actually create our Starting Square class.
*/
class StartingSq extends Gameboard implements Sq {
  //intance variables 
  private String pos = ""; 
  // constructors
  public StartingSq (String pos) {
    super(lgth, wdth, pos);//inhertited from Gameboard 
    this.pos = pos; //current position 
    this.color = "\u001B[45m"; //color of squares 
    //this.sqsIncrease = sqsIncrease;
    this.space = "|" + "\u001B[46m" + "        " + "\u001B[0m"; //outside space of a square 
    this.body = "|" + "\u001B[46m" + "   " + pos + "   " + "\u001B[0m"; //middle space of a square 
  }
  // methods
  public String viewPos() {
    return this.pos;//return the current position 
  }
  public String positionIncrease(int sqsIncrease) {
    return pos+sqsIncrease;//increase the position of the character 
  }
}