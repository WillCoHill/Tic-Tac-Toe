import java.util.Scanner;
import java.util.ArrayList;

class Main {

  static char[][] tttBoard = new char[3][3];
  
  static ArrayList<Integer> takenSpaces = new ArrayList<>();
  static int turnsLeft = 9;

  public static void printBoard() {
    System.out.println("|" + tttBoard[0][0] + "|" + tttBoard[0][1] + "|" + tttBoard[0][2] + "|");
    System.out.println("|" + tttBoard[1][0] + "|" + tttBoard[1][1] + "|" + tttBoard[1][2] + "|");
    System.out.println("|" + tttBoard[2][0] + "|" + tttBoard[2][1] + "|" + tttBoard[2][2] + "|");
  }

  public static void placeMark(int space, char mark) {

    if (space == 1) {
      tttBoard[0][0] = mark;
    } else if (space == 2) {
      tttBoard[0][1] = mark;
    } else if (space == 3) {
      tttBoard[0][2] = mark;
    } else if (space == 4) {
      tttBoard[1][0] = mark;
    } else if (space == 5) {
      tttBoard[1][1] = mark;
    } else if (space == 6) {
      tttBoard[1][2] = mark;
    } else if (space == 7) {
      tttBoard[2][0] = mark;
    } else if (space == 8) {
      tttBoard[2][1] = mark;
    } else if (space == 9) {
      tttBoard[2][2] = mark;
    } else {
      System.out.println("Error");
    }
  }

  public static boolean hasWon(char piece) {
    if(tttBoard[0][0] == piece && tttBoard[0][1] == piece && tttBoard[0][2] == piece) {
      return true;
    } else if(tttBoard[1][0] == piece && tttBoard[1][1] == piece && tttBoard[1][2] == piece) {
      return true;
    } else if(tttBoard[2][0] == piece && tttBoard[2][1] == piece && tttBoard[2][2] == piece) {
      return true;
    } else if(tttBoard[0][0] == piece && tttBoard[1][0] == piece && tttBoard[2][0] == piece) {
      return true;
    } else if(tttBoard[0][1] == piece && tttBoard[1][1] == piece && tttBoard[2][1] == piece) {
      return true;
    } else if(tttBoard[0][2] == piece && tttBoard[1][2] == piece && tttBoard[2][2] == piece) {
      return true;
    } else if(tttBoard[0][0] == piece && tttBoard[1][1] == piece && tttBoard[2][2] == piece) {
      return true;
    } else if(tttBoard[0][2] == piece && tttBoard[1][1] == piece && tttBoard[2][0] == piece) {
      return true;
    } else {
      return false;
    }
  }

  public static void main(String[] args) {
    boolean gameOver = false;
    boolean player2 = true;
    int tempInt;
    char token;

    tttBoard[0][0] = ' ';
    tttBoard[0][1] = ' ';
    tttBoard[0][2] = ' ';
    tttBoard[1][0] = ' ';
    tttBoard[1][1] = ' ';
    tttBoard[1][2] = ' ';
    tttBoard[2][0] = ' ';
    tttBoard[2][1] = ' ';
    tttBoard[2][2] = ' ';

    Scanner scnr = new Scanner(System.in);

    System.out.println("Welcome to Tic-Tac-Toe!");
    printBoard();
    while (turnsLeft > 0) {
      player2 = !player2;
      if(!player2) {
        System.out.println("Player 1: ");
        token = 'X';
      } else {
        System.out.println("Player 2: ");
        token = 'O';
      }
      
      System.out.println("Enter a number 1 - 9");

      tempInt = scnr.nextInt();

      while (takenSpaces.contains(tempInt)) {
        System.out.println("That space is already taken. Choose another, please: ");
        tempInt = scnr.nextInt();
      }

      if(!takenSpaces.contains(tempInt)) {
        placeMark(tempInt, token);
      }

      printBoard();

      takenSpaces.add(tempInt);

      --turnsLeft;

      if(hasWon(token)) {
        System.out.println("Congratulations! The winner is: ");
        if(!player2) {
          System.out.println("Player 1");
        } else {
          System.out.println("Player 2");
        }
        gameOver = true;
        break;
      }

    }
    if(turnsLeft == 0 && gameOver == false) {
    System.out.println("Game Over: No Winner!");
  }
 }
}
