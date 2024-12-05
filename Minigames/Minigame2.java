/*
  Libby, Izma, Farah, Sinchana
  May 29th, 2023
  Minigame 2 Class Page
  This page contains all the code to actually create our Trivia Minigame class.
*/
import java.util.*;
import java.io.*;
class Minigame2 {

  //colour codes
  public static final String ANSI_RESET = "\u001B[0m";
  public static final String ANSI_BLACK = "\u001B[40m";
  public static final String ANSI_BLUE="\u001B[34m"; 
  public static final String ANSI_PURPLE="\u001B[35m"; 
  public static final String ANSI_GREEN = "\u001B[32m";
  public static final String ANSI_CYAN = "\u001B[36m";	
  public static final String ANSI_YELLOW = "\u001B[33m";
  
  public static void main(String[] args) {
    System.out.println();
    System.out.println(ANSI_GREEN + ":･ﾟ✧:･.☽˚｡･ﾟ✧:･.:☽˚｡･ﾟ⋆｡ ﾟ☁︎｡ ⋆｡ ﾟ☾ ﾟ｡ ⋆:･ﾟ✧:･.☽˚｡･ﾟ✧:･.:☽˚" + ANSI_RESET); 
    System.out.println(ANSI_GREEN+ ":･ﾟ🧩 ❔ 🧩  WELCOME TO THE TRIVIA MINI GAME!  🧩 ❔ 🧩 ･.:" + ANSI_RESET);
    System.out.println(ANSI_GREEN + ":･ﾟ✧:･.☽˚｡･ﾟ✧:･.:☽˚｡･ﾟ⋆｡ ﾟ☁︎｡ ⋆｡ ﾟ☾ ﾟ｡ ⋆:･ﾟ✧:･.☽˚｡･ﾟ✧:･.:☽˚" + ANSI_RESET); 
    System.out.println();
    System.out.println(ANSI_GREEN + "Get 3/5 to sucessfully complete this mini game." + ANSI_RESET);
    System.out.println();
    System.out.println();

    //variables
    String answer = ""; //stores player's answer
    int instructions = 0; //used to ask if a player wants to see the instructions
    boolean play = true; //boolean to run the game
    boolean check = false; //boolean for checking
    int ansCount = 0; //keeps tract of score
    int Q = 0; //generate a random number for questions
    String[][] fileQ = null; //stores question in 2d array
    String[][] fileA = null; //stores answer in 2d array

    Scanner scan = new Scanner(System.in); //scanner

    while(play == true){
      System.out.println("Would you like to read the instructions before we begin? \nEnter 1 for YES and 2 for NO."); //asking if player wants to see instructions
      try { //checking for valid input
      instructions = Integer.parseInt(scan.nextLine()); 
      }catch(NumberFormatException ex){
        System.out.println("Please enter a valid input.");
      }
      System.out.println();
      if(instructions == 1){
        System.out.println("The rules are simple! You will be presented with a question and 4 options to choose from. Choose the option that you think is right and see if you got it right! There will be 5 questions and you need to get at least 3 right to successfully complete this minigame. Good luck!");
        play = false;
      }
      else if(instructions == 2){
        play = false;
      }
      else{
        System.out.println("Please enter a valid input.");
        play = true;
      }
    }

    System.out.println();
    System.out.println(ANSI_GREEN + "Starting mini game..." + ANSI_RESET);
    System.out.println();

    //question 1
    System.out.println(ANSI_BLACK + "QUESTION 1:" + ANSI_RESET);
    System.out.println();
    ansCount = loadQuestion(1); //load question
    System.out.println();
    System.out.println(ANSI_YELLOW + "Score: " + ansCount + ANSI_RESET);
    System.out.println();

    //question 2
    System.out.println(ANSI_BLACK + "QUESTION 2:" + ANSI_RESET);
    System.out.println();
    ansCount += loadQuestion(2); //load question
    System.out.println();
    System.out.println(ANSI_YELLOW + "Score: " + ansCount + ANSI_RESET);
    System.out.println();

    //question 3
    System.out.println(ANSI_BLACK + "QUESTION 3:" + ANSI_RESET);
    System.out.println();
    ansCount += loadQuestion(3); //load question
    System.out.println();
    System.out.println(ANSI_YELLOW + "Score: " + ansCount + ANSI_RESET);
    System.out.println();

    //question 4
    System.out.println(ANSI_BLACK + "QUESTION 4:" + ANSI_RESET);
    System.out.println();
    ansCount += loadQuestion(4);
    System.out.println();
    System.out.println(ANSI_YELLOW + "Score: " + ansCount + ANSI_RESET);
    System.out.println();

    //question 5
    System.out.println(ANSI_BLACK + "QUESTION 5:" + ANSI_RESET);
    System.out.println();
    ansCount += loadQuestion(5);
    System.out.println();
    System.out.println(ANSI_YELLOW + "Score: " + ansCount + ANSI_RESET);
    System.out.println();

    //checking score
    if(ansCount >= 3)
      System.out.println("Your Score: " + ansCount + "/5. Congratulations! You have successfully completed this mini game!");
    else
      System.out.println("Your Score: " + ansCount + "/5. Sorry! You have not successfully completed this mini game!");
    
  }
  //FUNCTIONS
  static String[][] loadFileData(String fileName) {
    String[][] data = null; // initialize a string array to return
    try{

      // read the data from the file to get its dimensions
      BufferedReader br = new BufferedReader(new FileReader(fileName)); // initialize the reader with the name of the file 
      String line = null; // initialize a string to store the read in line
      int lineCount = 0, columnCount = 0; // line count counts the number of lines and column count counts the number of columns in the text file
      do {
        line = br.readLine(); // read in the first line 
        if(line != null) { 
          lineCount++; // if the line is not null increase the line counter
          columnCount = line.split(",").length; // count the number of columns in the line 
        }
        
      } while(line != null); // when the line is not null continue to run the loop
      br.close(); // close the buffered reader

      // create the 2D array based on the dimensions of the file data 
      data = new String[lineCount][columnCount];

      // go through the file and fill in the 2D array just built 
      br = new BufferedReader(new FileReader(fileName)); //initialize the buffered reader again
      lineCount = 0; // reset the variable storing the number of lines
      do {
        line = br.readLine();
        if(line != null) { // while the read in line is not null
          String[] lineData = line.split(","); // split each line by a comma
          for(int x = 0; x < lineData.length; x++)
            data[lineCount][x] = lineData[x]; // assign each split portion of the line into the data array
          lineCount++; // increase the line count
        }
      } while(line != null);
      br.close(); // close the buffered reader
      

    } catch(IOException err) { // catch any error and output it 
      System.out.println(err.getMessage());
    }
    // return the 2D array filled with the file data
    return data;
  }

  //function to display question
  public static void viewQuestion(String[][] question) {
    for(int y=0;y<question.length;y++) //go through each row of the new array called result
        for(int x=0;x<question[y].length;x++) //go through each column/cell of the current row in result
          System.out.println(question[y][x]); //print each element by [row][col] or [y][x]
  }

  //function to generate question
  static int generateQuestion() {
    int generateQ = 0;
    Random r = new Random();

    generateQ = r.nextInt(10);
    if(generateQ == 0){
      generateQ = 10;
    }
    return generateQ;
  }

  //function to check answer
  static boolean checkAns(String[][] file, String answer, int question) {
    if(file[question-1][0].equals(answer)){
      System.out.println("Yes! You are correct!");
      return true;
    }
    else{
      System.out.println("Sorry, you are incorrect! The correct answer is: " + file[question-1][0]);
      return false;
    }
  }

  //function to load question
  static int loadQuestion(int type){
    int Q = 0;
    int ansCount = 0;
    boolean enter = true;
    String[][] fileQ = null;
    String[][] fileA = null;
    String answer = null;
    boolean check = false;
    Scanner scan = new Scanner(System.in);
    
    Q = generateQuestion();
    //System.out.println(Q);
    if(type == 1){
      fileQ = loadFileData("Minigames/MATH/" + Q + ".txt");
    }
    else if(type == 2){
      fileQ = loadFileData("Minigames/GK/" + Q + ".txt");
    }
    else if(type == 3){
      fileQ = loadFileData("Minigames/RIDDLES/" + Q + ".txt");
    }
    else if(type == 4){
      fileQ = loadFileData("Minigames/COMP+SCI/" + Q + ".txt");
    }
    else if(type == 5){
      fileQ = loadFileData("Minigames/EMOJIS/" + Q + ".txt");
    }
    viewQuestion(fileQ);
    System.out.println();
    System.out.println(ANSI_GREEN + "What is the answer? Please enter the letter ONLY." + ANSI_RESET);
    while(enter == true){ 
      answer = scan.nextLine();
      System.out.println();
      answer = answer.toUpperCase();
      if((answer.equals("A")) || (answer.equals("B")) || (answer.equals("C")) || (answer.equals("D"))) {
        enter = false;
      }
      else{ 
        System.out.println(ANSI_GREEN + "Please enter a valid option." + ANSI_RESET);
        enter = true;
      }
    }
    if(type == 1){
      fileA = loadFileData("Minigames/MATH/answers.txt");
    }
    else if(type == 2){
      fileA = loadFileData("Minigames/GK/answers.txt");
    }
    else if(type == 3){
      fileA = loadFileData("Minigames/RIDDLES/answers.txt");
    }
    else if(type == 4){
      fileA = loadFileData("Minigames/COMP+SCI/answers.txt");
    }
    else if(type == 5){
      fileA = loadFileData("Minigames/EMOJIS/answers.txt");
    }
    check = checkAns(fileA, answer, Q);
    if(check == true)
      ansCount = 1;
    else
      ansCount = 0;
    return ansCount;
  }
}