/*
  Libby, Izma, Farah, Sinchana
  May 29th, 2023
  Min1game 3 Class Page
  This page contains all the code to actually create our Rock, Paper, Scissors Minigame class.
*/
import java.util.*;
import java.util.Scanner;
class Minigame3 {
  public static final String ANSI_RESET = "\u001B[0m";//color code 
  public static final String PURPLE = "\033[0;35m";//color code 
  public static final String BLUE = "\033[0;34m";//color code 
  public static final String GREEN = "\033[0;32m";//color code 
  public static final String RED = "\033[0;31m";//color code
  public static void main(String[] args) {
    int gesture = 0, ai = 0, min = 0, max = 2, userWin = 0, aiWin = 0;//variables for the game 
    boolean win = false, bounds = false;//booleans used for the game 
    char rock = '✊', scissors = '✌', paper = '✋';//char emojis used 
    Random r = new Random();//generating a random number 
    char [] type = {'✊', '✌','✋' };//creating an array of the chars 
    Scanner scan = new Scanner(System.in);
    //welcoming the user to the game 
    System.out.println(PURPLE+":･ﾟ✧:･.☽˚｡･ﾟ✧:･.:☽˚｡･ﾟ⋆｡ ﾟ☁︎｡ ⋆｡ ﾟ☾ ﾟ｡ ⋆:･ﾟ✧:･.☽˚｡･ﾟ✧:･.:☽˚"+ANSI_RESET);
    System.out.println(PURPLE+ ":･ﾟ🥀 🧅 🍄  WELCOME TO ROCK, PAPER, SCISSORS!  🍄 🧄 🥀 ･.:" + ANSI_RESET);
    System.out.println(PURPLE+":･ﾟ✧:･.☽˚｡･ﾟ✧:･.:☽˚｡･ﾟ⋆｡ ﾟ☁︎｡ ⋆｡ ﾟ☾ ﾟ｡ ⋆:･ﾟ✧:･.☽˚｡･ﾟ✧:･.:☽˚"+ANSI_RESET); 
    System.out.println(BLUE+"First user to win three rounds wins!"+ANSI_RESET);
    do{
      do{
        //asking the user to enter the number beside the gesture 
        System.out.println(GREEN+"Please enter the number beside the hand gesture that you would like to enter: \n 0 - "+rock+" \n 1 - "+scissors+" \n 2 - "+paper+ANSI_RESET);
        try {
              gesture = Integer.parseInt(scan.nextLine());//parsing their answer to an int and printing it   
              System.out.println(BLUE+"You chose "+type[gesture]+ANSI_RESET);//telling the user what they chose
              bounds = false;
        }catch(NumberFormatException | IndexOutOfBoundsException ex){//try catch to avoid errors 
              System.out.println("Please enter an integer in the given range.");
              bounds = true;
            }
       }while(bounds == true);
       ai = (int)Math.floor(Math.random()*(max-min+1)+min);//generating a random number for the ai to pick 
       System.out.println(RED+"The AI chose "+type[ai]+ANSI_RESET); //displaying what the ai chose 
      if(gesture == 0 && ai == 0 || gesture == 1 && ai == 1 || gesture == 2 && ai == 2)
      {
        if(gesture == 0 && ai== 0)//if the ai and the player both chose rock 
          System.out.println(BLUE+"You both chose "+ type[0] +" and no one will be awarded a point."+ANSI_RESET);
        else if(gesture == 1 || ai == 1)//if the ai and the player both chose scissors 
          System.out.println(BLUE+"You both chose "+ type[1] +" and no one will be awarded a point."+ANSI_RESET);
        else if(gesture ==2 || ai==2)//if the ai and the player both chose paper 
          System.out.println(BLUE+"You both chose "+ type[2] +" and no one will be awarded a point."+ANSI_RESET);
      }
      else if(gesture == 0 && ai == 1 || gesture == 1 && ai==2 || gesture == 2 && ai==0)//if the ai and the player did not choose the same thing 
      {
        if(gesture == 0)//if player chose rock 
        {
          userWin++;
          System.out.println(PURPLE+type[0] +" defeats "+type[1] +". You win this round!"+ANSI_RESET);//rock defeates scissors 
        }
        else if(gesture == 1){//if player chose scissors 
          userWin++;
          System.out.println(PURPLE+type[1]+" defeats "+type[2]+". You win this round!"+ANSI_RESET);//scissors defeats paper 
        }
        else if(gesture == 2){//if player chose paper 
          userWin++;
          System.out.println(PURPLE+type[2]+" defeats "+type[0]+". You win this round!"+ANSI_RESET);//paper defeats rock 
        }
      }
      else if(ai == 0 && gesture == 1 || ai == 1 && gesture == 2 || ai == 2&& gesture == 0){//if ai and player did not chose the same thing 
        if(ai==0)//if ai chose rock 
        {
          aiWin++;
          System.out.println(GREEN+type[0] +" defeats "+type[1]+". The AI won this round."+ANSI_RESET);//rock defeats scissors 
        }
        else if(ai==1){//if ai chose scissors 
          aiWin++;
          System.out.println(GREEN+type[1]+" defeats "+type[2]+".The AI won this round."+ANSI_RESET); //scissors defeats paper 
        }
        else if(ai==2){//if ai chose rock 
          aiWin++;
          System.out.println(GREEN+type[2]+" defeats "+type[0]+". The AI won this round."+ANSI_RESET);//rock defeats scissors 
        } 
      }
      System.out.println(RED+"SCORE[YOU : AI] "+userWin+" : "+aiWin+ANSI_RESET);//displaying the score 
      if(userWin==3)
      {
          System.out.println("Congrats!! You won this minigame!");//if player won the game 
          win=true;
      }
      if(aiWin==3)
      {
        System.out.println("The AI beat you. Better luck next time!");//if ai won the game  
        win=true;
      }
    }while(win!=true);
    System.out.println("Thank you for playing!");//thanking the player for playing  
  }
}
