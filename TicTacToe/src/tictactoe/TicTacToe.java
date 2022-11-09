//This program runs the classic game of TikTacToe
package tictactoe;
import java.util.Scanner;
public class TicTacToe {
//Beginning of main
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        //creating a local array to store the array created in "creatEmptyBoard"
        char[][]board = createEmptyBoard();
        //prints out array within board
        printBoard(board);    
        //initializing and declaring token and creating a increment variable to 
        //switch the token as the game goes on
        char token = 'X';
        int turns = 1;
        //local variable to store winner result and the check valid method 
        //result
        boolean winner;
        boolean checkValid;
        //variable that holds location the player wants to place their token
        char location = ' ';
        //beginning of for loop
        for( int i = 0; i<9; i++){
            //determines which token to use
            if(turns%2 == 0){
                token = 'O';
            }else{
                token = 'X';
            }
            //loops the process of selecting a spot to place the token and 
            //checking if its a valid position
            do{
            System.out.println("Player " + token + ", where would you like to place your token? ");
            String sub = scnr.next();
            if(sub.length() >= 2){
                System.out.println("Invalid choice. Choose and number between 1 and 9.");
                sub = scnr.next();
            }
            location = sub.charAt(0);
            checkValid = checkValidNumber(location, board);
            }while(checkValid == false);
            //reprints out board with newly placed tokens and determines if 
            //there is a winner
            board = placedToken(location, board, token);
            winner = checkIfWon(board);
            printBoard(board);
            if(winner == true){
                System.out.println("Player " + token + " is the winner!!!");
                break;
            }
            turns++;
        }//end of for loop
       
       
    }// end of main
    //beginning of checkValidNumer 
    public static boolean checkValidNumber(char location, char[][]board){
        //determines if the location is within the valid places
        if(location < '1' || location > '9'){
            return false;
        }
        char chr = ' ';
        //determines if the location is already occupied 
        switch(location)
            {   case '1': chr = board[2][2]; break;
                case '2': chr  = board[2][8]; break;
                case '3': chr = board[2][14]; break;
                case '4': chr = board[8][2]; break;
                case '5': chr = board[8][8]; break;
                case '6': chr = board[8][14]; break;
                case '7': chr = board[14][2]; break;
                case '8': chr = board[14][8]; break;
                case '9': chr = board[14][14]; break;
                default: break;
            }
        if(location != chr){
          return false;
        }
        return true;
    }//end of checkValidNumber
    //beginnging of checkIfWon
    public static boolean checkIfWon(char [][]board){
        //determines if the locations are equal to each other to find a winner
        if(board[2][2] == board[2][8] && board[2][8] == board[2][14]){
            return true;
        }
        if(board[8][2] == board[8][8] && board[8][8] == board[8][14]){
            return true;
        }
        if(board[14][2] == board[14][8] && board[14][8] == board[14][14]){
            return true;
        }
        if(board[2][2] == board[8][2] && board[8][2] == board[14][2]){
            return true;
        }
        if(board[2][8] == board[8][8] && board[8][8] == board[14][8]){
            return true;
        }
        if(board[2][14] == board[8][14] && board[8][14] == board[14][14]){
            return true;
        }
        if(board[2][2] == board[8][8] && board[8][8] == board[14][14]){
            return true;
        }
        if(board[2][14] == board[8][8] && board[8][8] == board[14][2]){
            return true;
        }
        return false;
    }//end of checkIfWon
    //beginning of placedtoken
    public static char[][] placedToken(char location, char [][]board, char token)
    {
        //takes requested location and places specfic token within that spot
        switch(location)
            {   case '1': board[2][2] = token; break;
                case '2': board[2][8] = token; break;
                case '3': board[2][14] = token; break;
                case '4': board[8][2] = token; break;
                case '5': board[8][8] = token; break;
                case '6': board[8][14] = token; break;
                case '7': board[14][2] = token; break;
                case '8': board[14][8] = token; break;
                case '9': board[14][14] = token; break;
                default:
            }
        return board;
    }// end of placedToken
    //beginning of createEmptyBoard
    public static char[][] createEmptyBoard()
    {  
        //creates local arrray to make a board
        char[][] A = new char[17][17];
        int row, col;
        //creates blank spaces in board
        for( row = 0; row<17; row++){
            for(col=0; col<17; col++){
                A[row][col] = ' ';
            }
        }
        //creates line within board
        for(col = 0; col<17; col++){
            A[5][col]= '-';
            A[11][col]= '-';
            A[col][5] = '|';
            A[col][11] = '|';
        }
        A[5][11] = '|';
        // places numbers within each section
        A[2][2] = '1';
        A[2][8] = '2';
        A[2][14] = '3';
        A[8][2] = '4';
        A[8][8] = '5';
        A[8][14] = '6';
        A[14][2] = '7';
        A[14][8] = '8';
        A[14][14] = '9';
     return A;   
    }//end of createEmptyBoard
    //beginning of printBoard
    public static void printBoard(char[][]A)
    {
        //prints out array
        int row, col;
        for( row = 0; row<17; row++){
            for(col=0; col<17; col++){
                System.out.print(A[row][col]);
            }
            System.out.println("");
        }
    }//end of printBoard
    
}//end of code
