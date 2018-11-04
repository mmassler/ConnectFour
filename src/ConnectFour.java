import java.util.InputMismatchException;
import java.util.Scanner;
public class ConnectFour
{
    public static void main(String args[])
    {
        Scanner scan = new Scanner(System.in);
        int bLength = 0;
        int bHeight = 0;
        int turn = 0;
        String playerName = "";
        char chipType = 'a';
        boolean gameWin = false;

        {
            try
            {
                System.out.print("What would you like the height of the board to be? ");
                bHeight = scan.nextInt();
            }

            catch (InputMismatchException e)
            {
                scan.next();
                System.out.println("Error!");
            }

            try
            {
                System.out.print("What would you like the length of the board to be? ");
                bLength = scan.nextInt();
            }

            catch (InputMismatchException e)
            {
                scan.next();
                System.out.println("Error!");
            }
            char[][] userBoard = new char[bHeight][bLength];
            initializeBoard(userBoard);

            int spaceLeft = bLength * bHeight;
            System.out.println("\nPlayer 1: x");
            System.out.println("Player 2: o");

            int columnNumber = 0;
            while (gameWin == false)
            {
                turn++;
                switch (turn % 2)
                {
                    case 0:
                        playerName = "Player 2";
                        chipType = 'o';
                        break;

                    case 1:
                        playerName = "Player 1";
                        chipType = 'x';
                        break;


                }
                try
                {
                    System.out.println("\n" + playerName + ": Which column would you like to choose?");
                    columnNumber = scan.nextInt();
                }
                catch (InputMismatchException e)
                {
                    scan.next();
                    System.out.println("Error!");
                }
                int row = insertChip(userBoard, columnNumber, chipType);
                printBoard(userBoard);
                spaceLeft--;



                if (checkIfWinner(userBoard, columnNumber, row, chipType) == true)
                {
                    gameWin = true;
                    System.out.println();
                    System.out.println(playerName + " won the game!");
                    scan.close();
                }
                if (spaceLeft == 0)
                {

                    System.out.println("Draw. Nobody wins.");
                    break;


                }

            }


        }


    }


    public static void printBoard(char[][] array)
    {

        for (int i = 0; i < array.length; i++)
        {
            for (int j = 0; j < array[0].length; j++)
            {
                System.out.print(array[array.length-i-1][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void initializeBoard(char[][] array)
    {

        for (int i = 0; i < array.length; i++)
        {

            for (int j = 0; j < array[0].length; j++)
            {

                array[i][j] = '-';

                System.out.print(array[i][j] + " ");

            }
            System.out.println();
        }
    }

    public static int insertChip(char[][] array, int col, char chipType)
    {
        int row = 0;
        for (int j = 0; j < array.length; j++)
        {
            if (array[j][col] == '-')
            {
                array[j][col] = chipType;
                row = j;
                break;
            }

        }
        return row;
    }

    public static boolean checkIfWinner(char[][] array, int col, int row, char chipType)
    {
        boolean win = false;
        int pCounter = 0;
        for (int i = 0; i < array.length; i++)
        {
            for (int j = 0; j < array[col].length; j++)
            {
                if (array[i][j] == chipType && array[row][j]==chipType)
                {
                    pCounter++;

                } else
                {
                    pCounter = 0;
                }
                if (pCounter == 4)
                {
                    win = true;
                    break;

                }
            }
        }
        if (pCounter != 4)
        {
            for (int i = 0; i < array[row].length; i++)
            {
                for (int j = 0; j < array.length; j++)
                {
                    if (array[j][i] == chipType && array[j][col] == chipType)
                    {
                        pCounter++;
                    } else
                    {
                        pCounter = 0;
                    }
                    if (pCounter == 4)
                    {
                        win = true;
                        break;
                    }
                }

            }


        }

        return win;

    }
        public static  void reverseArray (char [][] array)
        {
            char tempVal;
            for (int i = 0; i < array.length / 2; i++)
            {
                for (int j = 0; j < array.length; j++)
                {
                    tempVal = array[i][j];
                    array[i][j] = array[array.length - 1 - i][j];
                    array[array.length - 1 - i][j] = tempVal;
                }
            }
        }

}






