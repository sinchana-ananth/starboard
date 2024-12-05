/*
  Libby, Izma, Farah, Sinchana
  May 29th, 2023
  Gameboard Class Page
  This page contains all the code to actually create our Gameboard class.
*/
import java.util.*;
import java.io.*;

class Gameboard {
  // instance variables
  protected int length = 0;//variable to store length of gameboard 
  protected int width = 0;//variable to store width of gameboard
  int dimensions = 0;//variable to store dimensions of gameboard
  public String color = "\u001B[0m";//variable to store color of gameboard
  protected String gameType = "";//variable to store gameboard type 
  public String fileName = "Gameboard/board.txt";//variable to store where we are reading from 
  public String border = "|--------" ;//border of the square 
  public String space = "|" + "\u001B[41m" + "        " + "\u001B[0m";//outside space of square 
  public String body = "";//space 

  // constructors
  public Gameboard(int length, int width, String pos) {
    this.length = length;//length of gameboard 
    this.width = width;//width of gameboard 
      
    gameType = "Standard";//gametype  
    String[][] gameBoard = loadFileData("Gameboard/board.txt"); //load the gameboard as a 2D array!
    this.body = "|" + "\u001B[41m" + "   " + pos + "   " + "\u001B[0m"; //middle of the square  
  }
    
  // methods
  public int getLength() {
    return this.length;//method to get the length of the gameboard 
  }
  public int getWidth() {
    return this.width;//method to get the width of the gameboard 
  }
  public String getGameType() {
    return this.gameType;//returning the game type 
  }  
  public void displaySquare(int num, String type) {
    System.out.println("\u001B[41m"+"|--------|\n|        |\n|   " + num + "  |\n|        |\n|--------| \u001B[0m "); //display the square 
  }
  public void displayBoard(int length, int width, Gameboard[][] gameboard) { //display the whole gameboard 
    int count = 0;
    for(int w = 0; w < width; w++) {
      for(int l = 0; l < length; l++) {
        System.out.print(border); //displaying the border 
      }
      System.out.print("|"); //adding one border line 
      System.out.println();
      for(int l = 0; l < length; l++) {
        System.out.print(gameboard[w][l].space); //displaying the outside space of the board 
      }
      System.out.print("|");
      System.out.println();
      for(int l = 0; l < length; l++) {
        System.out.print(gameboard[w][l].body); //displaying the body of the board 
      }
      System.out.print("|");
      System.out.println();
      for(int l = 0; l < length; l++) {
        System.out.print(gameboard[w][l].space);//displaing the outside space of the board 
      }
      System.out.print("|");//adding one border line 
      System.out.println();
    }
    for(int l = 0; l < length; l++) {
      System.out.print(border);//displaying the border of the square 
    }
    System.out.print("|");//adding one border line 
    System.out.println();
    
  }
  static String[][] loadFileData(String fileName)
  {
      String[][] data=null;
      try{
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        String line=null;
        int lineCount=0; //variable to store the line count 
        int columnCount=0; //variable to store the count line 
        do{
          line=br.readLine(); //read through each line 
          if(line!=null)
          {
            lineCount++;
            columnCount=line.split("").length; //split the data into columns to count 
          }
        }while(line!=null);
        br.close(); //close the buffered reader 
       
        //create the 2D array based on the dimensions of the file data
        data=new String[lineCount][columnCount];
  
        //Go through the file and fill in the 2D array just built
        br =new BufferedReader(new FileReader(fileName)); //open buffered reader 
        lineCount=0;
        do{
          line=br.readLine();
          if(line!=null)
          {
            String[] lineData=line.split("--------"); //split the line contents into an array for each word 
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
      return data; //end of load file data 
    }  
} 