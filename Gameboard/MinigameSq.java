/*
  Libby, Izma, Farah, Sinchana
  May 29th, 2023
  Minigame Square Class Page
  This page contains all the code to actually create our Minigame Square class.
*/
class MinigameSq extends EventSq implements Sq { 
  
  // instanace variables -------------------------------------------------------- 
  
  // constructors ---------------------------------------------------------------
  public MinigameSq(String pos) {
    super(lgth, wdth, pos);//inhertited from EventSq
    this.pos = pos;//position variable 
    this.color = "\u001B[42m";//color of the square 
    this.eventMsg = "Yay you landed on a minigame square! you will get to compete in a random minigame.";//message when you land on this square 
    this.space = "|" + "\u001B[44m" + "        " + "\u001B[0m";//empty space of the square 
    this.body = "|" + "\u001B[44m" + "   " + pos + "   " + "\u001B[0m";//middle of the square 
  }

  // methods --------------------------------------------------------------------

  public String viewPos() {
    System.out.println("You are currently on square " + this.pos);//what position you are on 
    return this.pos;//return the current position 
  }
  public String message()
  {
    return this.eventMsg; //return the event message 
  }
  protected void directToEvent(String eventName, Character player) {
    
  }
}