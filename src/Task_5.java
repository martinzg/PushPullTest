import java.util.Random;
import java.util.Scanner;

public class Task_5 {

    public static void main(String[] args) {

        System.out.println("Program creates array of max 10 elements and fills it with random numbers from 0 to 100!");
        System.out.println();

        Random random = new Random();
        int arrayLength = random.nextInt(10) + 1;
        int[] anArray = new int[arrayLength];

        createArray(anArray);
        System.out.println();
        System.out.print("Created array: ");
        for (int i=0; i<anArray.length; i++){
            System.out.print(anArray[i] + "; ");
        }

        changeArray(anArray);
        System.out.println();
        System.out.print("Changed array: ");
        for (int i=0; i<anArray.length; i++){
            System.out.print(anArray[i] + "; ");
        }
    }

    public static int[] createArray(int anArray[]){
        Random random = new Random();

        for (int i=0; i<anArray.length; i++){
            int randomNum = random.nextInt((100) + 1);
            anArray[i] = randomNum;
        }
        return anArray;
    }

    public static void changeArray(int aChangedArray[]) {
        int anArrayMaxVal = aChangedArray[0];
        int anArrayMaxValPos = 0;

        for (int i=0; i<aChangedArray.length; i++){
            if (aChangedArray[i] > anArrayMaxVal){
                anArrayMaxVal = aChangedArray[i];
                anArrayMaxValPos = i;
            }
        }
        aChangedArray[anArrayMaxValPos] = aChangedArray[0];
        aChangedArray[0] = anArrayMaxVal;
    }

}
