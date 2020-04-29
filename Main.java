package com.company;
import java.util.*;


public class Main {

    static int Board[][] = {{0,0,0},{0,0,0},{0,0,0}};


    public static void main(String[] args) throws InterruptedException {
        Scanner UInput = new Scanner(System.in);
        int userInput;
        while(true){
            clearBoard(Board);
            System.out.println("ASHAR'S TIC TAC TOE /n/n/n/n/n/n");

            userInput = UInput.nextInt();
            System.out.println("SELECT MODE");
            System.out.println("1.1 Player Mode");
            System.out.println("2.2 Player Mode");

            if(userInput == 2){

                boolean gameRunning = true;
                int selectionParse = 0;
                int turn = 1; //need to change
                while(gameRunning){

                        System.out.println("PLAYER " + turn + "'s TURN");
                        printBoard(Board);
                        System.out.println("Pick Position [1-9]");
                        printSelectionBoard();
                        boolean validMove = true;

                        do{
                            selectionParse = UInput.nextInt();
                            if(checkValidMove(Board, selectionParse) == true){
                                validMove = true;
                            } else {
                                validMove = false;
                                System.out.println("ERROR, SELECTION INVALID TRY again [1-9]");
                                printBoard(Board);
                            }
                        }while(validMove == false);
                        insert(selectionParse, Board, turn);



                        //  DEBUGBOARD(Board);
                        //  System.out.println();
                        //  System.out.println(turn);

                        if(winDetector(Board, turn) != 0){
                            System.out.println("Player " + winDetector(Board, turn) + " won!");
                            printBoard(Board);
                            break;
                        }
                        System.out.println();
                        // DEBUGBOARD(Board);
                        System.out.println();

                        if(turn == 1){
                            turn = 2;
                        } else {
                            turn = 1;
                        }
                }//two player mode
            } else if(userInput == 1){
                boolean gameRunning = true;
                int selectionParse = 0;
                int turn = 1;


                while(gameRunning){
                   if(turn%2 != 0 ){//player turn
                       System.out.println("PLAYER TURN");
                       printBoard(Board);
                       System.out.println("SELECT POSITION [1-9]");
                       selectionParse = UInput.nextInt();
                       insert(selectionParse, Board, turn);
                       turn++;
                   } else{//computer turn
                       System.out.println("COMPUTER TURN");
                        //place random position that hasnt been chosen before
                        //verify validity

                       turn++;
                   }
                }
                //1 player mode

            }
        }
    }
    public static  void DEBUGBOARD(int board[][]){
        for(int y = 0; y < 3; y++) {
            for (int x = 0; x < 3; x++) {
                System.out.print(Board[y][x]);
            }
        }
    }

    public static void clearBoard(int board[][]){
        for(int y = 0; y < 3; y++){
            for(int x = 0; x< 3; x++){
                board[y][x] = 0;
            }
        }
    }

    public static boolean checkValidMove(int Board[][], int selectionNumber){
        boolean isValid = true;
        switch(selectionNumber){
            case 1:
                if(Board[0][0] != 0){
                    isValid = false;
                }

                break;
            case 2:
                if(Board[0][1] != 0){
                    isValid = false;
                }
                break;
            case 3:
                if(Board[0][2] != 0){
                    isValid = false;
                }
                break;
            case 4:
                if(Board[1][0] != 0){
                    isValid = false;
                }
                break;
            case 5:
                if(Board[1][1] != 0){
                    isValid = false;
                }
                break;
            case 6:
                if(Board[1][2] != 0){
                    isValid = false;
                }
                break;
            case 7:
                if(Board[2][0] != 0){
                    isValid = false;
                }
                break;
            case 8:
                if(Board[2][1] != 0){
                    isValid = false;
                }
                break;
            case 9:
                if(Board[2][2] != 0){
                    isValid = false;
                }
                break;
        }
        return isValid;

    }
    public static void insert(int selectionNumber, int Board[][], int turn){
        switch(selectionNumber){
            case 1:
                Board[0][0] = turn;
                break;
            case 2:
                Board[0][1] = turn;
                break;
            case 3:
                Board[0][2] = turn;
                break;
            case 4:
                Board[1][0] = turn;
                break;
            case 5:
                Board[1][1] = turn;
                break;
            case 6:
                Board[1][2] = turn;
                break;
            case 7:
                Board[2][0] = turn;
                break;
            case 8:
                Board[2][1] = turn;
                break;
            case 9:
                Board[2][2] = turn;
                break;
        }

    }

    public static void printBoard(int boardData [][]){

        for(int y = 0; y < 3; y++){
            for(int x = 0; x < 3; x++){
                if(boardData[y][x] == 1) {
                    System.out.print("X");
                } else if(boardData[y][x] == 2){
                    System.out.print("O");
                } else {
                    System.out.print(" ");
                }
                if(x == 0 || x == 1){
                    System.out.print("|");
                }
            }
            System.out.println();
        }
    }
    public static void printSelectionBoard(){
        System.out.println("1 | 2 | 3 ");
        System.out.println("4 | 5 | 6 ");
        System.out.println("7 | 8 | 9 ");
    }

    public static void switchTurn(int turn){
        if(turn == 1){
            turn = 2;
        } else {
            turn = 1;
        }
    }

    public static int winDetector(int boardData[][], int playerNumber) { //returns win identifier

            //Vertical
            int ColumnCount = 0;
            for(int x = 0; x < 3; x++) {
                for(int y = 0; y < 3; y++){
                    if(boardData[y][x] == playerNumber){
                        ColumnCount++;
                    }
                }
                if(ColumnCount == 3){
                    return playerNumber; //playerNumber Wins!
                } else {
                    ColumnCount = 0;
                }
            }

            //Horizontal
        int rowCount = 0;
        for(int y = 0; y < 3; y++) {
            for(int x = 0; x < x; y++){
                if(boardData[y][x] == playerNumber){
                    rowCount++;
                }
            }
            if(rowCount == 3){
                return playerNumber; //player Wins
            } else {
                rowCount = 0;
            }
        }

        //DiagDown-Right
        int row = 0;
        int column = 0;
        int diagDRCount = 0;
        for(int x = 0; x < 3; x++){
            if(boardData[row][column] == playerNumber){
                diagDRCount++;
            }
            row++;
            column++;

        }
        if(diagDRCount == 3){
            return playerNumber; //player Wins
        }

        //DiagDown-Left
         row = 0;
         column = 2;
        int diagDLCount = 0;
        for(int x = 0; x < 3; x++){
            if(boardData[row][column] == playerNumber){
                diagDLCount++;
            }
            row++;
            column--;

        }
        if(diagDLCount == 3){
            return playerNumber; //player Wins
        }
        //NoWin
        return 0;


    }

    public static void menu(){
        //menu

    }


}
