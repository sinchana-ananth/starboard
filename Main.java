/*
  Libby, Izma, Farah, Sinchana
  May 29th, 2023
  Main page
  This page contains all the code to actually create our game
*/
import java.io.IOException;
import java.io.*;
import java.net.URL;
import java.net.*;
import java.util.*;
class Main {

  //colour codes
  public static final String ANSI_RESET = "\u001B[0m";
  public static final String ANSI_BLACK = "\u001B[40m";
  public static final String ANSI_BLUE="\u001B[34m"; 
  public static final String ANSI_PURPLE="\u001B[35m"; 
  public static final String ANSI_GREEN = "\u001B[32m";
  public static final String ANSI_CYAN = "\u001B[36m";	
  public static final String ANSI_YELLOW = "\u001B[33m";
  
  public static void main(String[] args) {
    /*01 - Start Square 1
    05, 36, 22, 74, 59, 81, 92, 23, 38, 65, 52, 98 - Good Squares 12 
    10, 14, 45, 60, 5, 94, 55, 73, 82, 41- Trouble Squares 10 
    07, 33, 21, 42, 56, 95, 77, 83, 90, 11, 14, 29, 40, 53, 66, 84 - Mini Games 16 
    09, 13, 27, 38, 47, 53, 66, 73, 80, 92 - Items/Shops 10
    [Everything else] - Normal Square 50
    100 - End Square 1 */
    
System.out.println();    System.out.println("░██████╗████████╗░█████╗░██████╗░██████╗░░█████╗░░█████╗░██████╗░██████╗░");
    System.out.println("██╔════╝╚══██╔══╝██╔══██╗██╔══██╗██╔══██╗██╔══██╗██╔══██╗██╔══██╗██╔══██╗");
    System.out.println("╚█████╗░░░░██║░░░███████║██████╔╝██████╦╝██║░░██║███████║██████╔╝██║░░██║");
    System.out.println("░╚═══██╗░░░██║░░░██╔══██║██╔══██╗██╔══██╗██║░░██║██╔══██║██╔══██╗██║░░██║");
    System.out.println("██████╔╝░░░██║░░░██║░░██║██║░░██║██████╦╝╚█████╔╝██║░░██║██║░░██║██████╔╝");
    System.out.println("╚═════╝░░░░╚═╝░░░╚═╝░░╚═╝╚═╝░░╚═╝╚═════╝░░╚════╝░╚═╝░░╚═╝╚═╝░░╚═╝╚═════╝░");
    String playerName = " ";
    String dice = "";
    /*
      position - an integer storing the position of the player
      cChoice - integer to store what character the user wants to represent them
      count1 - a counter variable that starts at 1
      position1 - an integer storing the position of the 1st npc
      position 2 - an integer storing the position of the 2nd npc
      points - an integer storing the players points
      points1 - an integer storing the first npc's points
      points2 - an integer storing the second npc's
    */
    int position = 1, cChoice = 0, count1 = 0, position1 = 1, position2 = 1, points = 0, points1 = 0, points2 = 0, playerUseItemAgainst = 0; 
    int mini = 0; //variable to store which minigame the player lands on 
    int special = 0; //variable to store which store the player lands on 
    String inv = ""; //variblae to store the player's inventory 
    String itemName = ""; //variable to store the item name from the shop 
    String itemNum=""; //varible to store the number that corresponds to the item name 
    int player1x = 0; //variable to store x coordinate of player 
    int player1y = 0; //variable to store the y coordinate of the player 
    boolean play = true; //boolean stores 
    boolean dubDice = false; // this boolean stores if the double dice has been used or not. If true, the normal dice will not be rolled
    boolean ignore = false;

    String[] cChars = {"🧚", "🧙", "🧛", "🧝"};
    String[] NPCnames = {"Glinda", "Sherbert", "Pablo", "Evie"};
    int charPos[] = new int[2]; // array of integers to store 2 coordinates to the board on the square
    int charPos1[] = new int[2]; // second array of integers to store 2 coordinates to the board on the square
    int charPos2[] = new int[2]; // third array of integers to store 2 coordinates to the board on the square
    int charPos3[] = new int[2]; // fourth array of integers to store 2 coordinates to the board on the square
    
    Scanner scan = new Scanner(System.in);  //create a new scanner item
    /*Choose to */ 
    System.out.println("Welcome to STARBOARD! Please enter your name!"); //greeting the user to our game
    playerName=scan.nextLine(); //scanning the users name to the next line 
    System.out.println();
    System.out.println(ANSI_GREEN + "Welcome "+playerName+" Best of luck!" + ANSI_RESET);//wishing the user the best of luck 
    System.out.println();
    System.out.println("-------------------------------------------------");
    System.out.println();
    Gameboard[][] g = new Gameboard[10][10];//creating the gameboard 
    Gameboard[] storedSqs = new Gameboard[4];//creatign the squares of where the characters are located 

    /*the following 100 lines of codes creates objects of different squares for each square on our board*/
    StartingSq s1 = new StartingSq("01");
    NormalSq s2 = new NormalSq("02");
    NormalSq s3 = new NormalSq("03");
    NormalSq s4 = new NormalSq("04");
    GoodSq s5 = new GoodSq("05", 4);
    NormalSq s6 = new NormalSq("06");
    TroubleSq s7 = new TroubleSq("07", 4);
    NormalSq s8 = new NormalSq("08");
    MinigameSq s9 = new MinigameSq("09");
    NormalSq s10 = new NormalSq("10");
    NormalSq s11 = new NormalSq("11");
    NormalSq s12 = new NormalSq("12");
    ShopSq s13 = new ShopSq("13");
    TroubleSq s14 = new TroubleSq("14", 4);
    NormalSq s15 = new NormalSq("15");
    NormalSq s16 = new NormalSq("16");
    GoodSq s17 = new GoodSq("17", 4);
    NormalSq s18 = new NormalSq("18");
    NormalSq s19 = new NormalSq("19");
    MinigameSq s20 = new MinigameSq("20");
    NormalSq s21 = new NormalSq("21");
    NormalSq s22 = new NormalSq("22");
    TroubleSq s23 = new TroubleSq("23", 4);
    NormalSq s24 = new NormalSq("24");
    NormalSq s25 = new NormalSq("25");
    ShopSq s26 = new ShopSq("26");
    NormalSq s27 = new NormalSq("27");
    GoodSq s28 = new GoodSq("28", 4);
    NormalSq s29 = new NormalSq("29");
    NormalSq s30 = new NormalSq("30");
    NormalSq s31 = new NormalSq("31");
    MinigameSq s32 = new MinigameSq("32");
    NormalSq s33 = new NormalSq("33");
    NormalSq s34 = new NormalSq("34");
    GoodSq s35 = new GoodSq("35", 4);
    NormalSq s36 = new NormalSq("36");
    NormalSq s37 = new NormalSq("37");
    TroubleSq s38 = new TroubleSq("38", 4);
    NormalSq s39 = new NormalSq("39");
    NormalSq s40 = new NormalSq("40");
    ShopSq s41 = new ShopSq("41");
    NormalSq s42 = new NormalSq("42");
    MinigameSq s43 = new MinigameSq("43");
    NormalSq s44 = new NormalSq("44");
    NormalSq s45 = new NormalSq("45");
    GoodSq s46 = new GoodSq("46", 4);
    NormalSq s47 = new NormalSq("47");
    TroubleSq s48 = new TroubleSq("48", 4);
    NormalSq s49 = new NormalSq("49");
    NormalSq s50 = new NormalSq("50");
    MinigameSq s51 = new MinigameSq("51");
    NormalSq s52 = new NormalSq("52");
    NormalSq s53 = new NormalSq("53");
    ShopSq s54 = new ShopSq("54");
    NormalSq s55 = new NormalSq("55");
    NormalSq s56 = new NormalSq("56");
    TroubleSq s57 = new TroubleSq("57", 4);
    NormalSq s58 = new NormalSq("58");
    NormalSq s59 = new NormalSq("59");
    MinigameSq s60 = new MinigameSq("60");
    NormalSq s61 = new NormalSq("61");
    NormalSq s62 = new NormalSq("62");
    GoodSq s63 = new GoodSq("63", 4);
    NormalSq s64 = new NormalSq("64");
    NormalSq s65 = new NormalSq("65");
    TroubleSq s66 = new TroubleSq("66", 4);
    NormalSq s67 = new NormalSq("67");
    NormalSq s68 = new NormalSq("68");
    MinigameSq s69 = new MinigameSq("69");
    NormalSq s70 = new NormalSq("70");
    NormalSq s71 = new NormalSq("71");
    ShopSq s72 = new ShopSq("72");
    NormalSq s73 = new NormalSq("73");
    NormalSq s74 = new NormalSq("74");
    TroubleSq s75 = new TroubleSq("75", 4);
    NormalSq s76 = new NormalSq("76");
    NormalSq s77 = new NormalSq("77");
    ShopSq s78 = new ShopSq("78");
    NormalSq s79 = new NormalSq("79");
    NormalSq s80 = new NormalSq("80");
    GoodSq s81 = new GoodSq("81", 4);
    NormalSq s82 = new NormalSq("82");
    NormalSq s83 = new NormalSq("83");
    MinigameSq s84 = new MinigameSq("84");
    NormalSq s85 = new NormalSq("85");
    NormalSq s86 = new NormalSq("86");
    TroubleSq s87 = new TroubleSq("87", 4);
    NormalSq s88 = new NormalSq("88");
    ShopSq s89 = new ShopSq("89");
    NormalSq s90 = new NormalSq("90");
    NormalSq s91 = new NormalSq("91");
    GoodSq s92 = new GoodSq("92", 4);
    NormalSq s93 = new NormalSq("93");
    NormalSq s94 = new NormalSq("94");
    TroubleSq s95 = new TroubleSq("95", 4);
    NormalSq s96 = new NormalSq("96");
    MinigameSq s97 = new MinigameSq("97");
    NormalSq s98 = new NormalSq("98");
    TroubleSq s99 = new TroubleSq("99", 4);
    EndingSq s100 = new EndingSq("100");
    Gameboard gb = new Gameboard(10, 10, "5");

    DoubleDice dd1 = new DoubleDice(12); //Creating an object for the double dice 

    /*the following lines of code assigns each object a position on the board*/
    g[0][0] = s1;
    g[0][1] = s2;
    g[0][2] = s3;
    g[0][3] = s4;
    g[0][4] = s5;
    g[0][5] = s6;
    g[0][6] = s7;
    g[0][7] = s8;
    g[0][8] = s9;
    g[0][9] = s10;
    g[1][0] = s11;
    g[1][1] = s12;
    g[1][2] = s13;
    g[1][3] = s14;
    g[1][4] = s15;
    g[1][5] = s16;
    g[1][6] = s17;
    g[1][7] = s18;
    g[1][8] = s19;
    g[1][9] = s20;
    g[2][0] = s21;
    g[2][1] = s22;
    g[2][2] = s23;
    g[2][3] = s24;
    g[2][4] = s25;
    g[2][5] = s26;
    g[2][6] = s27;
    g[2][7] = s28;
    g[2][8] = s29;
    g[2][9] = s30;
    g[3][0] = s31;
    g[3][1] = s32;
    g[3][2] = s33;
    g[3][3] = s34;
    g[3][4] = s35;
    g[3][5] = s36;
    g[3][6] = s37;
    g[3][7] = s38;
    g[3][8] = s39;
    g[3][9] = s40;
    g[4][0] = s41;
    g[4][1] = s42;
    g[4][2] = s43;
    g[4][3] = s44;
    g[4][4] = s45;
    g[4][5] = s46;
    g[4][6] = s47;
    g[4][7] = s48;
    g[4][8] = s49;
    g[4][9] = s50;
    g[5][0] = s51;
    g[5][1] = s52;
    g[5][2] = s53;
    g[5][3] = s54;
    g[5][4] = s55;
    g[5][5] = s56;
    g[5][6] = s57;
    g[5][7] = s58;
    g[5][8] = s59;
    g[5][9] = s60;
    g[6][0] = s61;
    g[6][1] = s62;
    g[6][2] = s63;
    g[6][3] = s64;
    g[6][4] = s65;
    g[6][5] = s66;
    g[6][6] = s67;
    g[6][7] = s68;
    g[6][8] = s69;
    g[6][9] = s70;
    g[7][0] = s71;
    g[7][1] = s72;
    g[7][2] = s73;
    g[7][3] = s74;
    g[7][4] = s75;
    g[7][5] = s76;
    g[7][6] = s77;
    g[7][7] = s78;
    g[7][8] = s79;
    g[7][9] = s80;
    g[8][0] = s81;
    g[8][1] = s82;
    g[8][2] = s83;
    g[8][3] = s84;
    g[8][4] = s85;
    g[8][5] = s86;
    g[8][6] = s87;
    g[8][7] = s88;
    g[8][8] = s89;
    g[8][9] = s90;
    g[9][0] = s91;
    g[9][1] = s92;
    g[9][2] = s93;
    g[9][3] = s94;
    g[9][4] = s95;
    g[9][5] = s96;
    g[9][6] = s97;
    g[9][7] = s98;
    g[9][8] = s99;
    g[9][9] = s100;
    /*let the player choose their avatar character */ 
    while(true) {
      System.out.println("Please select from the following characters by entering the corresponding integer: \n 1 - 🧚\n 2 - 🧙 \n 3 - 🧛 \n 4 - 🧝");
      try {
        cChoice = Integer.parseInt(scan.nextLine()); //displays the choice of the player's character 
        if(cChoice >= 1 && cChoice <= 4) //choose the character choice 
          break;
      }catch(NumberFormatException ex) {
      }
      System.out.println("Please enter an integer from 1-4!"); //try catch if they enter an invalud input 
    }
    Player player = new Player("Player", playerName, cChars[cChoice - 1]); //create a player object with their name and character 
    if(count1 == cChoice - 1)
      count1++;
    NPC npc1 = new NPC("NPC", NPCnames[count1], cChars[count1]); //create an NPC object with their name and character 
    count1++;
    if(count1 == cChoice - 1)
      count1++;
    NPC npc2 = new NPC("NPC", NPCnames[count1], cChars[count1]); //create an NPC object with their name and character 
    count1++;
    if(count1 == cChoice - 1)
      count1++;
    NPC npc3 = new NPC("NPC", NPCnames[count1], cChars[count1]); //create an NPC object with their name and character 
    count1 = 0;

    //displaying the players and their symbols
    System.out.println();
    System.out.println("Here are the players:"); //printing the players 
    System.out.println(player.getName() + ": " + player.getSymbol()); //player and symbol 
    System.out.println(npc1.getName() + ": " + npc1.getSymbol()); //npc1 name and symbol 
    System.out.println(npc2.getName() + ": " + npc2.getSymbol()); //npc2 name and symbol 
    System.out.println();
    
    Dice d1 = new Dice(6); //Create general dice
    MinigameDice md = new MinigameDice(); //Create a mini game dice 
    ItemDice id = new ItemDice(); //Create an item dice 
    DoubleDice dd = new DoubleDice(); //Create a double dice 

    /*---------------------------MAIN GAME LOOP---------------------------------------------------*/ 
    do{
      
      // display the updated gameboard
      
      CharacterSq c = new CharacterSq(String.valueOf(position), player.getSymbol()); //character square for player 
      CharacterSq c1 = new CharacterSq(String.valueOf(position), npc1.getSymbol()); //character square for npc1
      CharacterSq c2 = new CharacterSq(String.valueOf(position), npc2.getSymbol()); //character square for npc2
      storedSqs[0]  = g[charPos[0]][charPos[1]]; //the stored square in the array gets assigned to the characters position on board 
      storedSqs[1]  = g[charPos1[0]][charPos1[1]]; //the stored square in the array gets assigned to the npc1 position on board 
      storedSqs[2]  = g[charPos2[0]][charPos2[1]]; //the stored square in the array gets assigned to the npc2 position on board 
      g[charPos[0]][charPos[1]] = c; //assigning the position to the object 
      g[charPos1[0]][charPos1[1]] = c1; //assigning the position to the object
      g[charPos2[0]][charPos2[1]] = c2; //assigning the position to the object
      
      
      gb.displayBoard(10, 10, g); //display the gameboard   
      
      g[charPos[0]][charPos[1]] = storedSqs[0]; //assigning the position to the character square in the array 
      g[charPos1[0]][charPos1[1]] = storedSqs[1];  //assigning the position to the character square in the array
      g[charPos2[0]][charPos2[1]] = storedSqs[2]; //assigning the position to the character square in the array
  
      // display information about the player
      System.out.println();
      System.out.println(ANSI_CYAN + player.getName() + "'s STATS ~-~-~-~-~-~-~-~-~-~-~" + ANSI_RESET);
      System.out.println();
      
      System.out.println("CURRENT POSITION: " + position);  // access and display the players position

      System.out.println("ENTER IN [I] OR [i] TO VIEW YOUR INVENTORY OR ANYTHING ELSE TO SKIP: "); //ask if user wants to look at their inventory 
      inv = scan.nextLine(); //output their answer on the next line 
      if(inv.equals("I") || inv.equals("i") ) //if they want to view their invenory 
        {
          System.out.println("\u001B[36mINVENTORY: "); 
          System.out.println("1. You have "+player.getInventory(0)+" Double Dice ⚅⚁!");  //view how many double dice they have 
          System.out.println("2. You have "+player.getInventory(1)+" Swapsters 🔮!");  //view how many swapsters they have 
          System.out.println("3. You have "+player.getInventory(2)+" Banana Peels 🍌!");  //view how many banana peels they have 
          System.out.println("Would you like to use an item? (Enter in a number from 1-3 or enter anything else to exit): \u001B[0m"); //ask them if they would like to use an item from their inventory (a numeber from 1-5)
          
          itemNum = scan.nextLine(); 
          
          /*assign item names to the item number */ 
          if(itemNum.equals("1")) 
          {
            itemName="Double Dice"; //the double dice item 
            player.useItem(player, itemName, new DoubleDice()); //if the user wants to use the item 
            if(player.getInventory(0)>0)
            {
              position += dd.rollDice(); //the users updated position 
              System.out.println("Congrats! You've moved to "+ position+"!"); //where the user is currently on the board
              dubDice = true;         
            }          
          }
          if(itemNum.equals("2")) 
          {
            itemName="Swapster"; //the swapster item 
            player.useItem((Character)player, itemName, new Swapster()); //if the user wants to use this item 
      
            if(player.getInventory(1)>0)  
            {
              do {
                try {
                  System.out.println("\nEnter the player you would like to swap positions with: "); //asking the user who they want to swap with 
                  System.out.println("1. " + npc1.getName() + " " + npc1.getSymbol()); //swapping with NPC #1
                  System.out.println("2. " + npc2.getName() + " " + npc2.getSymbol()); //swapping with NPC #2
                  playerUseItemAgainst=Integer.parseInt(scan.nextLine()); //displaying their answer on the next line 
                  if(playerUseItemAgainst > 0 && playerUseItemAgainst < 3) //if user does not want to swap 
                    break;
                }catch(NumberFormatException ex) {//try and catch to get rid of any errors 
                  System.out.println("Please enter a number within the range.");
                }
              }while(true);
              if(playerUseItemAgainst == 1) {//if the player wants to swap with NPC #1
                player1x = position;//swap their positions 
                position = position1;
                position1 = player1x;
              }
              else if(playerUseItemAgainst == 2) {//if the player wants to swap with NPC #2
                player1x = position;//swap their positions 
                position = position2;
                position2 = player1x;
              }
            }
          }
          if(itemNum.equals("3")) 
          {
            itemName="Banana Peel"; //the banana peel item  
            player.useItem((Character)player, itemName, new BananaPeel()); //if the user wants to use this item  
            if(player.getInventory(2)>0)
            {
              System.out.println("Om nom nom! By eating the banana peel, you just gained 3 points! "); 
              points+=3; 
            }
          }
        }
      // inform the user they must roll the dice
      if(dubDice == false) {
        System.out.println("Press enter to roll the dice🎲🎲"); //player rolling the dice 
        dice = scan.nextLine(); // with any user input roll the dice
        position += d1.rollDice(); //position increases as player rolls the dice 
      }
      else
        dubDice = false; 
      play = true;
      System.out.println();
      System.out.println(ANSI_GREEN + "YOUR TURN" + ANSI_RESET);
      /*
      // inform the user they must roll the dice
      System.out.println("Press enter to roll the dice🎲🎲"); 
      dice = scan.nextLine(); // with any user input roll the dice
      position += d1.rollDice();
      play = true;
      */
      if(position == 100){  //if player reaches the end of the board 
        System.out.println("You landed on square " + position); //they landed on square 100 
        points += 100;
        System.out.println("Congratulations! You are the STAR WINNER! Goodbye!"); //they won the game 
        break;
      }
      else if(position > 100){ //if the user rolled a number greater than 100
        System.out.println("Sorry, you rolled more than you're allowed to go!"); //if the user rolled a number greater than 100
        play = false; 
      }
      if(play == true){ 
      System.out.println("You landed on square " + position); 
      // get the index of the characters position for the gameboard array
      charPos[0] = (position - 1) / 10; // when 1 is subtracted, the first digit is the row or x value
      charPos[1] = (position - 1) % 10; // when 1 is subtracted, the second value is the column or y value
      if(count1 == 0) {
        
      }
      else if((charPos[0] == charPos2[0] && charPos[1] == charPos2[1]) || (charPos2[0] == charPos1[0] && charPos2[1] == charPos1[1])) {
        do {
          position--;
          System.out.println("You moved back to square " + position + " because somebody was already on that square!");
          // get the index of the characters position for the gameboard array
            charPos[0] = (position - 1) / 10; // when 1 is subtracted, the first digit is the row or x value
            charPos[1] = (position - 1) % 10; // when 1 is subtracted, the second value is the column or y value
        }while((charPos[0] == charPos2[0] && charPos[1] == charPos2[1]) || (charPos2[0] == charPos1[0] && charPos2[1] == charPos1[1]));
      }
      
      if(g[charPos[0]][charPos[1]] instanceof GoodSq)
        {
          System.out.println(((GoodSq) g[charPos[0]][charPos[1]]).message());
          position=((GoodSq) g[charPos[0]][charPos[1]]).moveFwd();
          ((GoodSq) g[charPos[0]][charPos[1]]).viewPos(); 
          charPos[0] = (position - 1) / 10; // when 1 is subtracted, the first digit is the row or x value
          charPos[1] = (position - 1) % 10; // when 1 is subtracted, the second value is the column or y value
          if(count1 == 0) {
        
          }
          else if((charPos[0] == charPos2[0] && charPos[1] == charPos2[1]) || (charPos2[0] == charPos1[0] && charPos2[1] == charPos1[1])) {
            do {
              position--;
              System.out.println("You moved back to square " + position + " because somebody was already on that square!");
              // get the index of the characters position for the gameboard array
              charPos[0] = (position - 1) / 10; // when 1 is subtracted, the first digit is the row or x value
              charPos[1] = (position - 1) % 10; // when 1 is subtracted, the second value is the column or y value
            }while((charPos[0] == charPos2[0] && charPos[1] == charPos2[1]) || (charPos2[0] == charPos1[0] && charPos2[1] == charPos1[1]));
          }
          System.out.println("Your turn is now over!"); 
          points+=4;
        }
      else if(g[charPos[0]][charPos[1]] instanceof TroubleSq && player.getInventory(3) > 0) { //if the square landed on is a trouble square  but they have 1  or more immunity potions 
        System.out.println(((TroubleSq) g[charPos[0]][charPos[1]]).message()); //tell the user they landed on a trouble square 
        player.useItem(player, "Immunity Potion", new ImmunityPotion()); //use the immunity potion if they have it automatically  
        ((TroubleSq) g[charPos[0]][charPos[1]]).viewPos();
      }
      else if(g[charPos[0]][charPos[1]] instanceof TroubleSq) //if the square landed on is a trouble square 
        {
          System.out.println(((TroubleSq) g[charPos[0]][charPos[1]]).message()); ///tell the user they landed on a trouble square 
          position = ((TroubleSq) g[charPos[0]][charPos[1]]).moveBack(); ///the user has to move back 
          ((TroubleSq) g[charPos[0]][charPos[1]]).viewPos();  
          charPos[0] = (position - 1) / 10; // when 1 is subtracted, the first digit is the row or x value
          charPos[1] = (position - 1) % 10; // when 1 is subtracted, the second value is the column or y value
          if(count1 == 0) {
            
          }
          else if((charPos[0] == charPos2[0] && charPos[1] == charPos2[1]) || (charPos2[0] == charPos1[0] && charPos2[1] == charPos1[1])) {
            do {
              position--;
              System.out.println("You moved back to square " + position + " because somebody was already on that square!");
              // get the index of the characters position for the gameboard array
              charPos[0] = (position - 1) / 10; // when 1 is subtracted, the first digit is the row or x value
              charPos[1] = (position - 1) % 10; // when 1 is subtracted, the second value is the column or y value
            }while((charPos[0] == charPos2[0] && charPos[1] == charPos2[1]) || (charPos2[0] == charPos1[0] && charPos2[1] == charPos1[1]));
          }
          points -= 2;
        }
      else if(g[charPos[0]][charPos[1]] instanceof MinigameSq) //if the square is of type minigame 
        {
          System.out.println(((MinigameSq) g[charPos[0]][charPos[1]]).message()); 
          mini = md.rollDice(); //player rolls the dice
          
          if(mini == 0) 
          {
            System.out.println("\u001B[34m You will be playing the Matching Minigame! \u001B[0m");
            Minigame1.main(args); //direct the user to the matching minigame 
          }
          else if(mini == 1)
          {
            System.out.println("\u001B[34m You will be playing the Trivia Minigame! \u001B[0m");
            Minigame2.main(args); //direct the user to the trivia game 
          }
          else if(mini == 2)
          {
            System.out.println("\u001B[34m You will be playing the Rock, Paper and Scissors Minigame! \u001B[0m");
            Minigame3.main(args); //direct player to the rock paper scissors minigame 
          }
          else if(mini == 3)
          {
            System.out.println("\u001B[34m You will be playing the Tic Tac Toe Minigame! \u001B[0m");
            Minigame4.main(args); //direct player to tic tac toe 
          }
        }
      else if(g[charPos[0]][charPos[1]] instanceof ShopSq) //if somone lands on a shop 
        {  
          System.out.println(((ShopSq) g[charPos[0]][charPos[1]]).message()); //display the shop square 
          {
            special = id.rollDice(); //player rolls the dice 
            if(special == 0) 
            {
              System.out.println("\u001B[35mYou got a double ⚅⚁.\u001B[0m");
              player.giveItem(player, "Double Dice"); 
            }
            else if(special == 1)
            {
              System.out.println("\u001B[35mYou got a Swapster 🔮.\u001B[0m");
              player.giveItem(player, "Swapster");
            }
            else if(special == 2)
            {
              System.out.println("\u001B[35mYou got a  Banana Peel 🍌.\u001B[0m");
              player.giveItem(player, "Banana Peel");
            }
            else if(special == 3)
            {
              System.out.println("\u001B[35mYou got an Immunity Potion ⚗️.\u001B[0m");
              player.giveItem(player, "Immunity Potion");
            }
          }
        }
      else{
        System.out.println("You landed on a normal square. Unfortunately, nothing happens here!");
        ((NormalSq) g[charPos[0]][charPos[1]]).nextTurn();
      }
      }
      System.out.println("Press enter to continue!"); 
      scan.nextLine();

      System.out.println(ANSI_GREEN + npc1.getName() + "'s TURN" + ANSI_RESET);
      position1 += d1.rollDice();
      play = true;
      if(position1 == 100){
        System.out.println(npc1.getName() + " landed on square " + position1); 
        points1 += 100;
        System.out.println(npc1.getName() + " is the STAR WINNER! Goodbye!");
        break;
      }
      else if(position1 > 100){ 
        System.out.println(npc1.getName() + " rolled more than they're allowed to go!");
        play = false;
      }
      if(play == true){ 
      System.out.println(npc1.getName() + " landed on square " + position1); 
      // get the index of the characters position for the gameboard array
      charPos1[0] = (position1 - 1) / 10; // when 1 is subtracted, the first digit is the row or x value
      charPos1[1] = (position1 - 1) % 10; // when 1 is subtracted, the second value is the column or y value
      if(count1 == 0 && (charPos[0] == charPos1[0] && charPos[1] == charPos1[1])) {
        do {
          position1--;
          System.out.println(npc1.getName() + " moved back to square " + position1 + " because somebody was already on that square!");
          // get the index of the characters position for the gameboard array
          charPos1[0] = (position1 - 1) / 10; // when 1 is subtracted, the first digit is the row or x value
          charPos1[1] = (position1 - 1) % 10; // when 1 is subtracted, the second value is the column or y value
        }while(count1 == 0 && (charPos[0] == charPos1[0] && charPos[1] == charPos1[1]));
      }
      else if((charPos[0] == charPos1[0] && charPos[1] == charPos1[1]) || (charPos2[0] == charPos1[0] && charPos2[1] == charPos1[1])) {
        do {
          position1--;
          System.out.println(npc1.getName() + " moved back to square " + position1 + " because somebody was already on that square!");
          // get the index of the characters position for the gameboard array
          charPos1[0] = (position1 - 1) / 10; // when 1 is subtracted, the first digit is the row or x value
          charPos1[1] = (position1 - 1) % 10; // when 1 is subtracted, the second value is the column or y value
        }while((charPos[0] == charPos1[0] && charPos[1] == charPos1[1]) || (charPos2[0] == charPos1[0] && charPos2[1] == charPos1[1]));
      }
      
      if(g[charPos1[0]][charPos1[1]] instanceof GoodSq) //if square landed on is good square 
        {
          System.out.println(((GoodSq) g[charPos1[0]][charPos1[1]]).message()); //tell the NPC they landed on a good square 
          position1 = ((GoodSq) g[charPos1[0]][charPos1[1]]).moveFwd(); //NPC moved forward 
          ((GoodSq) g[charPos1[0]][charPos1[1]]).viewPos(); //NPC can see the square they are on now 
          charPos1[0] = (position1 - 1) / 10; // when 1 is subtracted, the first digit is the row or x value
          charPos1[1] = (position1 - 1) % 10; // when 1 is subtracted, the second value is the column or y value
          if(count1 == 0 && (charPos[0] == charPos1[0] && charPos[1] == charPos1[1])) { //if two people are on the square 
            do {
              position1--;
              System.out.println(npc1.getName() + " moved back to square " + position1 + " because somebody was already on that square!");
              // get the index of the characters position for the gameboard array
              charPos1[0] = (position1 - 1) / 10; // when 1 is subtracted, the first digit is the row or x value
              charPos1[1] = (position1 - 1) % 10; // when 1 is subtracted, the second value is the column or y value
            }while(count1 == 0 && (charPos[0] == charPos1[0] && charPos[1] == charPos1[1]));
          }
          else if((charPos[0] == charPos1[0] && charPos[1] == charPos1[1]) || (charPos2[0] == charPos1[0] && charPos2[1] == charPos1[1])) { //if two people are on the same square 
            do {
              position1--;  //subtract the position by one 
              System.out.println(npc1.getName() + " moved back to square " + position1 + " because somebody was already on that square!"); //NPC #1 moves back 
              // get the index of the characters position for the gameboard array
              charPos1[0] = (position1 - 1) / 10; // when 1 is subtracted, the first digit is the row or x value
              charPos1[1] = (position1 - 1) % 10; // when 1 is subtracted, the second value is the column or y value
            }while((charPos[0] == charPos1[0] && charPos[1] == charPos1[1]) || (charPos2[0] == charPos1[0] && charPos2[1] == charPos1[1])); //do this until no two people are on the same square 
          }
          points1 += 4;
          System.out.println(npc1.getName() + "'s turn is now over!"); 
          
        }
      else if(g[charPos1[0]][charPos1[1]] instanceof TroubleSq && npc1.getInventory(3) > 0) { //if the square landed on is a trouble square (but they have immunity)
        System.out.println(((TroubleSq) g[charPos1[0]][charPos1[1]]).message()); //telling the NPC they landed on a trouble square 
        player.useItem(npc1, "Immunity Potion", new ImmunityPotion()); //use the immunity potion 
        ((TroubleSq) g[charPos1[0]][charPos1[1]]).viewPos();
      }
      else if(g[charPos1[0]][charPos1[1]] instanceof TroubleSq) //telling the NPC they landed on a trouble square 
        {
          System.out.println(((TroubleSq) g[charPos1[0]][charPos1[1]]).message()); //tell them they landed on a trouble square 
          position1 = ((TroubleSq) g[charPos1[0]][charPos1[1]]).moveBack(); //the NPC moves back 
          ((TroubleSq) g[charPos1[0]][charPos1[1]]).viewPos(); //NPC can see which posiiton they are on 
          charPos1[0] = (position1 - 1) / 10; // when 1 is subtracted, the first digit is the row or x value
          charPos1[1] = (position1 - 1) % 10; // when 1 is subtracted, the second value is the column or y value
          if(count1 == 0 && (charPos[0] == charPos1[0] && charPos[1] == charPos1[1])) { //if two people are on the same position
            do {
              position1--;
              System.out.println(npc1.getName() + " moved back to square " + position1 + " because somebody was already on that square!"); //tell them that they move back 
              // get the index of the characters position for the gameboard array
              charPos1[0] = (position1 - 1) / 10; // when 1 is subtracted, the first digit is the row or x value
              charPos1[1] = (position1 - 1) % 10; // when 1 is subtracted, the second value is the column or y value
            }while(count1 == 0 && (charPos[0] == charPos1[0] && charPos[1] == charPos1[1]));
          }
          else if((charPos[0] == charPos1[0] && charPos[1] == charPos1[1]) || (charPos2[0] == charPos1[0] && charPos2[1] == charPos1[1])) {  //if two people are on the same square 
            do {
              position1--; //NPC moves back one
              System.out.println(npc1.getName() + " moved back to square " + position1 + " because somebody was already on that square!"); //telling why the NPC has to move back one 
              // get the index of the characters position for the gameboard array
              charPos1[0] = (position1 - 1) / 10; // when 1 is subtracted, the first digit is the row or x value
              charPos1[1] = (position1 - 1) % 10; // when 1 is subtracted, the second value is the column or y value
            }while((charPos[0] == charPos1[0] && charPos[1] == charPos1[1]) || (charPos2[0] == charPos1[0] && charPos2[1] == charPos1[1])); 
          }
          points1 += 4;
        }
      else if(g[charPos1[0]][charPos1[1]] instanceof MinigameSq)  //if NPC lands on a Minigame Square 
        {
          System.out.println(((MinigameSq) g[charPos1[0]][charPos1[1]]).message()); //tell NPC they landed on a minigame 
          if(d1.rollDice() % 2 == 0)
            System.out.println(npc1.getName() + " won the minigame");
          else
            System.out.println(npc1.getName() + " lost the minigame");
        }
      else if(g[charPos1[0]][charPos1[1]] instanceof ShopSq) //tell the NPC they landed on a shop square 
        {  
          System.out.println(((ShopSq) g[charPos1[0]][charPos1[1]]).message()); 
          {
            special = id.rollDice(); //NPC rolls the dice 
            if(special == 0) 
            {
              System.out.println("\u001B[35m"+npc1.getName()+" got a double ⚅⚁.\u001B[0m"); 
              npc1.giveItem(npc1, "Double Dice");
            }
            else if(special == 1)
            {
              System.out.println("\u001B[35m"+npc1.getName()+" got a Swapster 🔮.\u001B[0m");
              npc1.giveItem(npc1, "Swapster");
            }
            else if(special == 2)
            {
              System.out.println("\u001B[35m"+npc1.getName()+" got a  Banana Peel 🍌.\u001B[0m");
              npc1.giveItem(npc1, "Banana Peel");
            }
            else if(special == 3)
            {
              System.out.println("\u001B[35m"+npc1.getName()+" got an Immunity Potion ⚗️.\u001B[0m");
              npc1.giveItem(npc1, "Immunity Potion");
            }
          }
        }
      else{
        System.out.println("You landed on a normal square. Unfortunately, nothing happens here!"); //if the npc lands on a normal square 
        ((NormalSq) g[charPos1[0]][charPos1[1]]).nextTurn(); //the next persons turn 
      }
      }

      System.out.println("Press enter to continue!"); //player presses enter to continue 
      scan.nextLine();

      System.out.println(ANSI_GREEN + npc2.getName() + "'s TURN" + ANSI_RESET); //diplsay who's turn it is 
      position2 += d1.rollDice(); //npc #2 rolls the dice  
      play = true;
      if(position2 == 100){ //if npc lands on square 100
        System.out.println("You landed on square " + position2); //telling the npc they landed on position 100 
        points2 += 100;
        System.out.println("Congratulations! You are the STAR WINNER! Goodbye!"); //telling the npc they won the game  
        break; //game is over 
      }
      else if(position2 > 100){ //if their position is greater than 100 
        System.out.println(npc2.getName() + " rolled more than they're allowed to go!"); //telling the npc they rolled more than 100
        play = false;
      }
      if(play == true){ 
      System.out.println(npc2.getName() + " landed on square " + position2); 
      // get the index of the characters position for the gameboard array
      charPos2[0] = (position2 - 1) / 10; // when 1 is subtracted, the first digit is the row or x value
      charPos2[1] = (position2 - 1) % 10; // when 1 is subtracted, the second value is the column or y value
      if((charPos[0] == charPos2[0] && charPos[1] == charPos2[1]) || (charPos2[0] == charPos1[0] && charPos2[1] == charPos1[1])) {
        do {
          position2--;
          System.out.println(npc2.getName() + " moved back to square " + position2 + " because somebody was already on that square!");
          // get the index of the characters position for the gameboard array
          charPos2[0] = (position2 - 1) / 10; // when 1 is subtracted, the first digit is the row or x value
          charPos2[1] = (position2 - 1) % 10; // when 1 is subtracted, the second value is the column or y value
        }while((charPos[0] == charPos2[0] && charPos[1] == charPos2[1]) || (charPos2[0] == charPos1[0] && charPos2[1] == charPos1[1]));
      }
      
      if(g[charPos2[0]][charPos2[1]] instanceof GoodSq)
        {
          System.out.println(((GoodSq) g[charPos2[0]][charPos2[1]]).message());
          position2=((GoodSq) g[charPos2[0]][charPos2[1]]).moveFwd();
          ((GoodSq) g[charPos2[0]][charPos2[1]]).viewPos(); 
          charPos2[0] = (position2 - 1) / 10; // when 1 is subtracted, the first digit is the row or x value
          charPos2[1] = (position2 - 1) % 10; // when 1 is subtracted, the second value is the column or y value
          if((charPos[0] == charPos2[0] && charPos[1] == charPos2[1]) || (charPos2[0] == charPos1[0] && charPos2[1] == charPos1[1])) {
            do {
              position2--;
              System.out.println(npc2.getName() + " moved back to square " + position2 + " because somebody was already on that square!");
              charPos2[0] = (position2 - 1) / 10; // when 1 is subtracted, the first digit is the row or x value
              charPos2[1] = (position2 - 1) % 10; // when 1 is subtracted, the second value is the column or y value  
          }while((charPos[0] == charPos2[0] && charPos[1] == charPos2[1]) || (charPos2[0] == charPos1[0] && charPos2[1] == charPos1[1]));
          points2 += 4;
          System.out.println(npc2.getName() + "'s turn is now over!");
        }
          
      }
      else if(g[charPos2[0]][charPos2[1]] instanceof TroubleSq && npc2.getInventory(3) > 0) {
        System.out.println(((TroubleSq) g[charPos2[0]][charPos2[1]]).message());
        player.useItem(npc2, "Immunity Potion", new ImmunityPotion());
        ((TroubleSq) g[charPos2[0]][charPos2[1]]).viewPos();
      }
      else if(g[charPos2[0]][charPos2[1]] instanceof TroubleSq)
        {
          System.out.println(((TroubleSq) g[charPos2[0]][charPos2[1]]).message()); ///tell the npc they landed on a trouble square           position2 = ((TroubleSq) g[charPos2[0]][charPos2[1]]).moveBack();
          ((TroubleSq) g[charPos2[0]][charPos2[1]]).viewPos();  
          charPos2[0] = (position2 - 1) / 10; // when 1 is subtracted, the first digit is the row or x value
          charPos2[1] = (position2 - 1) % 10; // when 1 is subtracted, the second value is the column or y value
        if((charPos[0] == charPos2[0] && charPos[1] == charPos2[1]) || (charPos2[0] == charPos1[0] && charPos2[1] == charPos1[1])) {
            do {
              position2--;//npc2 moves back one square 
              System.out.println(npc2.getName() + " moved back to square " + position2 + " because somebody was already on that square!");//reason why npc2 moved back 1 square 
              charPos2[0] = (position2 - 1) / 10; // when 1 is subtracted, the first digit is the row or x value
              charPos2[1] = (position2 - 1) % 10; // when 1 is subtracted, the second value is the column or y value
            }while((charPos[0] == charPos2[0] && charPos[1] == charPos2[1]) || (charPos2[0] == charPos1[0] && charPos2[1] == charPos1[1])); //do this until no two players have the same posiiton 
          }
          points2 -= 2; //decrease number of points 
        }
      else if(g[charPos2[0]][charPos2[1]] instanceof MinigameSq)
        {
          System.out.println(((MinigameSq) g[charPos2[0]][charPos2[1]]).message()); //if npc2 lands on a minigame square 
          if(d1.rollDice() % 2 == 0)
            System.out.println(npc2.getName() + " won the minigame");//npc2 won the minigame 
          else
            System.out.println(npc2.getName() + " lost the minigame");//npc2 lost the minigame 
        }
      else if(g[charPos2[0]][charPos2[1]] instanceof ShopSq)
        {  
          System.out.println(((ShopSq) g[charPos2[0]][charPos2[1]]).message()); //if npc2 lands on a shop square 
          {
            special = id.rollDice();//npc2 rolling the dice 
            if(special == 0)
            {
              System.out.println("\u001B[35m"+npc2.getName()+" got a double ⚅⚁.\u001B[0m");//which item they got
              npc2.giveItem(npc2, "Double Dice");//giving the double dice item 
            }
            else if(special == 1)
            {
              System.out.println("\u001B[35m"+npc2.getName()+ " got a Swapster 🔮.\u001B[0m");//which item they got
              npc2.giveItem(npc2, "Swapster");//giving the swapster item 
            }
            else if(special == 2)
            {
              System.out.println("\u001B[35m"+npc2.getName()+" got a  Banana Peel 🍌.\u001B[0m");//which item they got
              npc2.giveItem(npc2, "Banana Peel");//giving the banana peel item 
            }
            else if(special == 3)
            {
              System.out.println("\u001B[35m"+npc2.getName()+" got an Immunity Potion ⚗️.\u001B[0m");//which item they got
              npc2.giveItem(npc2, "Immunity Potion"); //giving the immunity potion item 
            }
          }
        }
      else{
        System.out.println(npc2.getName()+" landed on a normal square. Unfortunately, nothing happens here!");//normal square
        ((NormalSq) g[charPos2[0]][charPos2[1]]).nextTurn();//next person's turn 
      }
      }
      
      System.out.println("Press enter to continue!"); //to continue the game 
      scan.nextLine();

      count1++;
    }while(position <= 100); //while poistion is less than 100

    int[] pointsArray = {points, points1, points2};//array to hold all points 
    String[] playersArray = {playerName, npc1.getName(), npc2.getName()};//array to hold all players 

    System.out.println();
    System.out.println(ANSI_GREEN + "FINAL SCORES:" + ANSI_RESET);
    pointsArray = leaderboard(pointsArray); //calling the leaderboard function to sort the points 
    for(int x=0;x<pointsArray.length;x++){
      System.out.println(ANSI_GREEN +(x+1) + ". " + playersArray[x] + ": " + pointsArray[x] + " points" + ANSI_RESET); //all characters name and number of points 
    }
  }
  //the function below is a sorting algorithm used to display the final sc
  static int[] leaderboard (int[] points){
    int temp = 0, iterations = 0, swaps = 0;//variables 
    for(int x = points.length - 1; x > 0; x--) {
      for(int y = 0; y < x; y++) {
        if(points[y] < points[y + 1]) {
          temp = points[y + 1];//temp variable for swaps 
          points[y + 1] = points[y];//swaping places 
          points[y] = temp;//swapping places 
          swaps++;//number of swaps increases 
        }
        iterations++;
      }
      if(swaps == 0) //if swaps are zero 
        break;
      else
        swaps = 0;
    }
    return points; //return the points in sorted order 
  }
}