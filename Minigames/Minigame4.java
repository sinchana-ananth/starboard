/*
  Libby, Izma, Farah, Sinchana
  May 29th, 2023
  Minigame 4 Class Page
  This page contains all the code to actually create our Tic Tac Toe Minigame class.
*/
import java.util.*;
import java.io.*;
import javax.sound.sampled.*; 
//Class Main for Minigame 4 
class Minigame4 {

  //set all of the colors to use 
  public static final String ANSI_RESET = "\u001B[0m";
  public static final String ANSI_BLACK = "\u001B[40m";
  public static final String ANSI_BLUE="\u001B[34m"; 
  public static final String ANSI_PURPLE="\u001B[35m"; 
  public static final String ANSI_GREEN = "\u001B[32m";
  public static final String ANSI_CYAN = "\u001B[36m";	
  public static final String ANSI_YELLOW = "\u001B[33m";
  
  //display everything in the public void 
  public static void main(String[] args) {
    playGame(); 
  }

  /*this function will help us split the ticTacToeBoard into a 2D array*/ 
  static String[][] loadFileData(String ticTacToeBoard)
  {
    String[][] data=null;
    try{
      BufferedReader br = new BufferedReader(new FileReader(ticTacToeBoard));
      String line=null;
      int lineCount=0;
      int columnCount=0;
      do{
        line=br.readLine(); //read through each line 
        if(line!=null)
        {
          lineCount++;
          columnCount=line.split(",").length; //split the data into columns to count 
        }
      }while(line!=null);
      br.close();
     
      //create the 2D array based on the dimensions of the file data
      data=new String[lineCount][columnCount];

      //Go through the file and fill in the 2D array just built
      br =new BufferedReader(new FileReader("Minigames/ticTacToeBoard.txt")); //open buffered reader 
      lineCount=0;
      do{
        line=br.readLine();
        if(line!=null)
        {
          String[] lineData=line.split(","); //split the line contents into an array for each word 
          for(int x=0;x<lineData.length;x++) 
            data[lineCount][x]=lineData[x]; //fill the array with the contents of the lineData 
          lineCount++; 
        }
      }while(line!=null);
      br.close(); //close buffered reader 
      
    }catch(IOException err)
    {
        System.out.println(err.getMessage());
    }

    return data; 
  } //end of load file data 
  
  /*Print the tic tac toe board */ 
  public static void viewTable(String[][] ticTacToeBoard) {
    for (int i=0; i<3; i++)
    {
      String rowString=""; 
      for (int y=0; y<3; y++)
      {
        rowString=rowString+ticTacToeBoard[i][y]; 
        if(y==2)
        {
          System.out.println(rowString);          
        } 
      }
    }
  }

  /*Check if the winner is player 1 */ 
  static public boolean player1WinCheck(boolean player1Win, String[][] ticTacToeBoard)
  {
    /*check rows*/
    if( (ticTacToeBoard[0][0]=="🌸" && ticTacToeBoard[0][1]=="🌸" && ticTacToeBoard[0][2]=="🌸")||(ticTacToeBoard[2][0]=="🌸" && ticTacToeBoard[2][1]=="🌸" && ticTacToeBoard[2][2]=="🌸")||(ticTacToeBoard[1][0]=="🌸" && ticTacToeBoard[1][1]=="🌸" && ticTacToeBoard[1][2]=="🌸"))
     {
      return player1Win = true; 
     }
    /*check columns*/    
    if( (ticTacToeBoard[0][0]=="🌸" && ticTacToeBoard[1][0]=="🌸" && ticTacToeBoard[2][0]=="🌸")||(ticTacToeBoard[0][1]=="🌸" && ticTacToeBoard[1][1]=="🌸" && ticTacToeBoard[2][1]=="🌸")||(ticTacToeBoard[0][2]=="🌸" && ticTacToeBoard[1][2]=="🌸" && ticTacToeBoard[2][2]=="🌸"))
     {
      return player1Win = true; 
     }    
    /*check diagonals*/ 
    if((ticTacToeBoard[0][0]=="🌸" && ticTacToeBoard[1][1]=="🌸" && ticTacToeBoard[2][2]=="🌸") || (ticTacToeBoard[0][2]=="🌸" && ticTacToeBoard[1][1]=="🌸" && ticTacToeBoard[2][0]=="🌸"))
     {
      return player1Win = true; 
     }    
  
    return player1Win = false;    
  }

  /*Check if the winner is player 2*/ 
  static public boolean player2WinCheck(boolean player2Win, String[][] ticTacToeBoard)
  {
    /*check rows*/
    if( (ticTacToeBoard[0][0]=="🌹" && ticTacToeBoard[0][1]=="🌹" && ticTacToeBoard[0][2]=="🌹")||(ticTacToeBoard[2][0]=="🌹" && ticTacToeBoard[2][1]=="🌹" && ticTacToeBoard[2][2]=="🌹")||(ticTacToeBoard[1][0]=="🌹" && ticTacToeBoard[1][1]=="🌹" && ticTacToeBoard[1][2]=="🌹"))
     {
      return player2Win = true; 
     }
    /*check columns*/    
    if( (ticTacToeBoard[0][0]=="🌹" && ticTacToeBoard[1][0]=="🌹" && ticTacToeBoard[2][0]=="🌹")||(ticTacToeBoard[0][1]=="🌹" && ticTacToeBoard[1][1]=="🌹" && ticTacToeBoard[2][1]=="🌹")||(ticTacToeBoard[0][2]=="🌹" && ticTacToeBoard[1][2]=="🌹" && ticTacToeBoard[2][2]=="🌹"))
     {
      return player2Win = true; 
     }    
    /*check diagonals*/     
    if((ticTacToeBoard[0][0]=="🌹" && ticTacToeBoard[1][1]=="🌹" && ticTacToeBoard[2][2]=="🌹") || (ticTacToeBoard[0][2]=="🌹" && ticTacToeBoard[1][1]=="🌹" && ticTacToeBoard[2][0]=="🌹"))
     {
      return player2Win = true; 
     }    
  
    return player2Win = false;    
  }
  
  /*Create the game*/ 
  public static void playGame()
  {
   //initialize variables 
    boolean player1Win = false; //see if player 1 has won 
    boolean player2Win = false; //see if player 2 has won 
    int xCoord = 0; //get the xcoord from the user 
    int yCoord = 0; //get the ycoord from the user 
    int rand1 = 0; //get random #1 
    int rand2 = 0; //get random #2 
    
    //load the gameboard as a 2D array! 
    String[][] ticTacToeBoard = loadFileData("Minigames/ticTacToeBoard.txt"); 

    Scanner scan=new Scanner(System.in);
    /* INTRO */ 
    System.out.println(" "); 
    System.out.println(ANSI_GREEN+":･ﾟ✧:･.☽˚｡･ﾟ✧:･.:☽˚｡･ﾟ⋆｡ ﾟ☁︎｡ ⋆｡ ﾟ☾ ﾟ｡ ⋆:･ﾟ✧:･.☽˚｡･ﾟ✧:･.:☽˚"+ANSI_RESET); 
    System.out.println(ANSI_GREEN+ ":･ﾟ🥀 🧅 🍄  WELCOME TO GARDEN TIC TAC TOE!  🍄 🧄 🥀 ･.:" + ANSI_RESET);
    System.out.println(ANSI_GREEN+":･ﾟ✧:･.☽˚｡･ﾟ✧:･.:☽˚｡･ﾟ⋆｡ ﾟ☁︎｡ ⋆｡ ﾟ☾ ﾟ｡ ⋆:･ﾟ✧:･.☽˚｡･ﾟ✧:･.:☽˚"+ANSI_RESET); 
    System.out.println(" ");  
    System.out.println(ANSI_YELLOW+"1. Player 1 will be 🌸 and player 2 will be 🌹"+ANSI_RESET); 
    System.out.println(ANSI_YELLOW+"2. Enter in an x and y coordinate for the gameboard below to plant your flower in the spot!  "+ANSI_RESET);       
    viewTable(ticTacToeBoard); 
    System.out.println(ANSI_YELLOW+"3. To win, you must have 3 flowers in a row, column, or diagonal! "+ANSI_RESET); 
    System.out.println(" "); 

    /* While loop to check if someone has already won */
    while(player1Win!=true && player2Win!=true)
    {
      do{

        System.out.println(ANSI_CYAN+"\nPLAYER 1 TURN: "+ANSI_RESET); 
        try{ 
          System.out.println(ANSI_PURPLE + "\nWhat is the row you'd like to place your flower 🌸?"+ANSI_RESET); 
          yCoord = Integer.parseInt(scan.nextLine());
        }catch(NumberFormatException ex){
          System.out.println(ANSI_YELLOW+"Please enter an integer from 1-3!"+ANSI_RESET);
        }
        try {
          System.out.println(ANSI_PURPLE + "What is the column you'd like to place your flower 🌸?"+ANSI_RESET); 
          xCoord = Integer.parseInt(scan.nextLine());  
        }catch(NumberFormatException ex) {
          System.out.println(ANSI_YELLOW+"Please enter an integer from 1-3!"+ANSI_RESET);
        }

          if(xCoord<1 || yCoord<1 || xCoord>3 || yCoord>3)
          {
           System.out.println(ANSI_YELLOW+ "You chose an invalid range for one of your coordinates! Please choose a number from 1-3!"+ANSI_RESET); 
          }
        
          else if(ticTacToeBoard[xCoord-1][yCoord-1]=="🌸" || ticTacToeBoard[xCoord-1][yCoord-1]=="🌹")
          {
           System.out.println(ANSI_YELLOW+ "You chose a coordinate where there is already a flower! Please choose another coordinate! "+ANSI_RESET);       
          }
   
          else
          {
            break; 
          }
        
      } while (xCoord<1 || yCoord<1 || xCoord>3 || yCoord>3 || ticTacToeBoard[xCoord-1][yCoord-1]=="🌸" || ticTacToeBoard[xCoord-1][yCoord-1]=="🌹"); //check to see if input is valid for user 1 (no invalid or occupied coordinates)
      
      //add the flower to the board if it is valid 
      ticTacToeBoard[xCoord-1][yCoord-1]="🌸"; 

      //view the table 
      viewTable(ticTacToeBoard);   

      //See if player 1 wins 
      if(player1WinCheck(player1Win, ticTacToeBoard)==true)
      {
        System.out.println(ANSI_GREEN+":･ﾟ✧🍐 Congrats to you player 1! You've won! 🍓:･ﾟ✧"+ANSI_RESET); 
        break; 
      }
      //PLAYER 2's TURN! 
      System.out.println(ANSI_CYAN+"\nPLAYER 2 TURN: "+ANSI_RESET); 
      Random rand = new Random(); //create random object 
      do{
          rand1 = rand.nextInt(3); //generate a random integer from 0 to 2+
          rand2 = rand.nextInt(3); //generate a random integer from 0 to 2      
      }while(ticTacToeBoard[rand1][rand2]=="🌸" || ticTacToeBoard[rand1][rand2]=="🌹");  
      
      //add the flower to the board if it is valid 
      ticTacToeBoard[rand1][rand2]="🌹"; 

      //view the table 
      viewTable(ticTacToeBoard);   

      //check to see if player 2 wins 
      if(player2WinCheck(player2Win, ticTacToeBoard)==true)
      {
        System.out.println(ANSI_GREEN+":･ﾟ✧🍐 Congrats to you player 2! You've won! 🍓:･ﾟ✧"+ANSI_RESET); 
        break; 
      }     
    }//end of game when someone wins 
     
  } //end of play Game 
  
}//end of class 