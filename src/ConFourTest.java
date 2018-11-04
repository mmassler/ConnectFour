public class ConFourTest
{
    public static void printBoard(char[][] array) {
        for (int i = 0; i < array[0].length; i++) {
            for (int j = 0; j < array.length; j++) {
                System.out.print(array[j][i] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    // set each spot in an array to dashes
    public static void initializeBoard(char[][] array) {
        for (int i = 0; i < array[0].length; i++) {
            for (int j = 0; j < array.length; j++) {
                array[j][i] = '-';
                System.out.print( array[j][i]+ " " );
            }
            System.out.println();
        }
    }
}
