/*
  Libby, Izma, Farah, Sinchana
  May 29th, 2023
  Minigame 1 Class Page
  This page contains all the code to actually create our Matching Minigame class.
*/
import java.util.*;
import java.util.concurrent.TimeUnit;
class Minigame1 {
  public static void main(String[] args) {
    int[][] memBoard = new int[4][4]; //array that stores the memory board #1
    int[][] memBoard2 = new int[4][4]; //array that stores the memory board #2
    int[][] memBoard3 = new int[4][4]; //array that stores the memory board #3
    int[] coord1 = new int[2]; //
    int[] coord2 = new int[2];
    int count = 1, gamePoints = 0, turns = 0, count2 = 0;
    boolean win = false;
    Random r = new Random();
    System.out.println("WELCOME TO MEMORY ----------------------- \n HOW TO PLAY: \n" + "The goal of the game is to guess all the matches. You gain points for guessing correctly, and lose points for guessing incorrectly. \n 1. Guess an x-coordinate from 1-4 (going down the column) \n 2. Guess a y-coordinate from 1-4 (going across the row) \n 3. Repeat for the second coordinate \n 4. Memorize where the numbers you guessed are before the screen is cleared! \n 5. Your points will be calculated \n 6. Repeat until you clear the board");
    displayBoard(memBoard);
    memBoard2 = createBoard(memBoard2, r, count);
    displayBoard(memBoard2);
    do {
      coord1 = getCoordinates(4, memBoard);
      while(true) {
        coord2 = getCoordinates(4, memBoard);
        if(coord1[0] == coord2[0] && coord1[1] == coord2[1]) {
          System.out.println("Please enter different coordinates");
        }
        else 
          break;
      }
      memBoard = guess(memBoard, memBoard2, coord1, coord2);
      if(memBoard2[coord1[0]][coord1[1]] == memBoard2[coord2[0]][coord2[1]]) {
        gamePoints+= 5;
        count2++;
      }
      else
        gamePoints-= 2;
      System.out.println("Current points: " + gamePoints);
      turns++;
      System.out.println("Turns left: " + (14 - turns));
      if(count2 >= 8) 
        win = true;
      else if((14 - turns) < 1) {
        break;
      }
      
    }while(win == false);
    if(win)
      System.out.println("Congrats! You won the game. The total amount of points you collected are " + gamePoints);
    else if(win == false) {
      System.out.println("Sorry you ran out of turns and lost. Better luck next time!");
    }
    
  }
  static int[][] createBoard(int[][] memBoard, Random r, int count) {
    int x = 0, y = 0;
    for(int z = 0; z < 2; z++) {
      while(true) {
        x = r.nextInt(4);
        y = r.nextInt(4);
        if(memBoard[x][y] == 0) {
          memBoard[x][y] = count;
          break;
        }
      }
    }
    if(count < 8)
      return createBoard(memBoard, r, count + 1);
    else
      return memBoard;
  }
  static void displayBoard(int[][] memBoard) {
    for(int x = 0; x < memBoard.length; x++) {
      for(int y = 0; y < memBoard[x].length; y++) {
        if(memBoard[x][y] < 10)
          System.out.print(memBoard[x][y] + "  ");
        else
          System.out.print(memBoard[x][y] + " ");
      }
      System.out.println();
    }
  }
  static int[][] guess(int[][] memBoard, int[][] memBoard2, int[] coord1, int[] coord2) {
    memBoard[coord1[0]][coord1[1]] = memBoard2[coord1[0]][coord1[1]];
    memBoard[coord2[0]][coord2[1]] = memBoard2[coord2[0]][coord2[1]];
    displayBoard(memBoard);
    if(memBoard[coord1[0]][coord1[1]] == memBoard[coord2[0]][coord2[1]]) {
      try {
        TimeUnit.SECONDS.sleep(2);
      }catch(InterruptedException err) {
        System.out.println(err.getMessage());
      }
      System.out.print("\033[H\033[2J");  
      System.out.flush();  
      displayBoard(memBoard);
    }
    else {
      memBoard[coord1[0]][coord1[1]] = 0; 
      memBoard[coord2[0]][coord2[1]] = 0;
      try {
        TimeUnit.SECONDS.sleep(4);
      }catch(InterruptedException err) {
        System.out.println(err.getMessage());
      }
      System.out.print("\033[H\033[2J");  
      System.out.flush();  
      displayBoard(memBoard);
    }
    return memBoard;
  }
  static int[] getCoordinates(int max, int[][] memBoard) {
    int coord[] = new int[2];
    boolean catchMe = true;
    Scanner scan = new Scanner(System.in);
    do{ 
      try {
        System.out.println("Please enter an x-coordinate");
        coord[0] = Integer.parseInt(scan.nextLine()) - 1; // read in the coordinate
        System.out.println("Please enter a y-coordinate");
        coord[1] = Integer.parseInt(scan.nextLine()) - 1; // read in the coordinate
        if(coord[0] >= 0 && coord[0] < max || coord[1] >= 0 && coord[1] < max) 
          catchMe = false; // indicate that the coordinate was read and there were no errors
        else {
          catchMe = true; // indicate the coordinate was outside the range and the loop should repeat
          System.out.println("Sorry! That coordinate is not within the acceptable range. Please enter a coordinate from 1 -> " + max); // inform the user they need to enter an int in the range
        }
        if(memBoard[coord[0]][coord[1]] > 0) {
          catchMe = true; // indicate the coordinate was already entered and the loop should repeat
          System.out.println("Sorry! You already entered this coordinate. Please enter a new one! "); // inform the user they already entered this coordinate
        }
          
      }catch(NumberFormatException ex){ // if there was an error (i.e an integer was not entered) 
        System.out.println("Sorry! That is not a valid coordinate. Please enter a coordinate from 1 -> " + max); // ask the user to enter a coord within the range
        catchMe = true; // indicate the loop should be repeated
      }
    }while(catchMe == true); // repeat if an invalid coordinate was entered
    return coord; // if a coordinate was selected, return this
  }
}