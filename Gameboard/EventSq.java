/*
  Libby, Izma, Farah, Sinchana
  May 29th, 2023
  Event Square Class Page
  This page contains all the code to actually create our Event Square class.
*/
abstract class EventSq extends Gameboard { 
  // instance variables
  protected String pos = ""; //stores the character's position
  protected String eventMsg = ""; //stores the event message

  // constructor
  public EventSq(int length, int width, String pos) { //creates the event square
    super(length, width, pos); //inhertits from Gameboard 
  }

  // methods
  abstract protected void directToEvent(String eventName, Character player);
  public String getEventMessage() { //prints out the event message
    return this.eventMsg;//returns the event message 
  }
}