import java.util.Random;
import java.util.Scanner;

public class Task_4 {

    public static void main(String[] args) {

        System.out.println("Program creates array of 10 numbers and fills it with random numbers from 1 to 100!");
        System.out.println();

        int arrayLength;
        int randomNumMin = 1;
        int randomNumMax = 100;

        do {
            System.out.println("Please specify array length - from 1 to 10!");

            Scanner scanner = new Scanner(System.in);
            arrayLength = scanner.nextInt();

            if ((arrayLength > 10) | (arrayLength < 1)) {
                System.out.println();
                System.out.println("Such array can't be created!");
            }
            else {
                break;
            }
        } while (true);

        int[] array;
        array = new int[arrayLength];

        int countEven = 0;
        int countOdd = 0;

        System.out.println();
        System.out.println("Generated array:");

        for (int i=0; i<arrayLength; i++){
            Random random = new Random();
            int randomNum = random.nextInt((randomNumMax - randomNumMin) + 1) + randomNumMin;
            array[i] = randomNum;
            System.out.print(array[i] + "; ");

            if ((randomNum%2) == 0) {
                countEven++;
            }
            else {
                countOdd++;
            }
        }
        System.out.println();
        System.out.println();
        System.out.println("Array contains " + countEven + " Even numbers and " + countOdd + " Odd numbers!");
    }
}
