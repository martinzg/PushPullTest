import java.util.Random;

public class Task_8 {
    public static void main(String[] args) {

        System.out.println("Program creates an array and rearranges it in reverse order!");
        int[] anArray = new int[10];

        System.out.print("\n" +  "Created array: ");
        fillArray(anArray);
        for (int i=0; i<anArray.length; i++) {
            System.out.print(anArray[i] + "; ");
        }

        System.out.print("\n" +  "Reverse array: ");
        reverseArray(anArray);
        for (int i=0; i<anArray.length; i++) {
            System.out.print(anArray[i] + "; ");
        }
    }

    public static void fillArray (int[] anArray) {
        Random random = new Random();
        for (int i=0; i<anArray.length; i++){
            int numberRandom = random.nextInt((100) + 1);
            anArray[i] = numberRandom;
        }
    }
    public static void reverseArray (int[] anArray) {
        int lastElementIndex = anArray.length-1;
        for (int i=0; i<(anArray.length/2); i++){
            int tmpValue = anArray[lastElementIndex];
            anArray[lastElementIndex] = anArray[i];
            anArray[i] = tmpValue;
            lastElementIndex--;
        }
    }
}