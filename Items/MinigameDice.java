/*
  Libby, Izma, Farah, Sinchana
  May 29th, 2023
  Minigame Dice Class Page
  This page contains all the code to actually create our Minigame Dice class.
*/
class MinigameDice extends Dice {
  // instance variables
  private static final String[] MGLIST = {"Matching Game", "Trivia", "Rock, Paper, Scissors", "Tic Tac Tow"};//array of all of the minigames 
  // constructors
  public MinigameDice() {
    this.maxValue = 3;//max value that can be rolled 
    itemName = "Minigame Dice";//type of itemName 
  }
  // methods
  public String getRolledMG() {
    return MGLIST[this.rNum];//return the rolled minigame 
  }
  public int rollDice() {
    this.rNum = r.nextInt(maxValue - 1) + 1;//random number to roll the dice 
    System.out.println("You rolled a " +rNum +" ! Time to play " + MGLIST[rNum]+"!");//displaying the number of the dice rolled 
    return rNum;//returning the random number
  }
  protected void useItem(Character player) {
    
  }
  protected String viewItem() {
    return "This is a minigame dice. It is rolled to determine what minigame the player will participate in!"; //view this item 
  }
}