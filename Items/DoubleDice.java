/*
  Libby, Izma, Farah, Sinchana
  May 29th, 2023
  Double Dice Class Page
  This page contains all the code to actually create our Double Dice class.
*/
class DoubleDice extends Dice {
  // instance variables
  private int rNum2 = 0; //random number variable 
  private int total = 0; //total variable 
  
  // constructors
  public DoubleDice() {
    super();//inherited from Dice 
    itemName = "Double Dice";//type of itemname 
  }

  public DoubleDice(int maxValue) {
    super(maxValue);
    itemName = "Double Dice";//type of itemname 
  }
  
  // methods
  public int getRNum2() {
    return this.rNum2;//return the random number 
  }
  public int getTotal() {
    return this.total; //return the total value of the dice 
  }
  public int rollDice() {
    this.rNum = r.nextInt(maxValue - 1) + 1; //random variable #1
    this.rNum2 = r.nextInt(maxValue - 1) + 1; //random variable #2
    this.total = rNum + rNum2;//total dice number 
    return total;//return dice number 
  }
  protected void useItem(Character player) {
  }
  protected String viewItem() {
    return "This is a double dice. Two dice are rolled and the number returned is the sum of the two. This dice can be attianed through landing on a shop square and paying points to roll the item dice.";//what this dice does 
  }
}