import java.util.Scanner;

public class Task_7 {

    public static void main(String[] args) {

        System.out.println("Program reads input number and returns sum of all digits!");
        System.out.print("\n" +  "Please input a number: ");

        Scanner scanner = new Scanner(System.in).useDelimiter("\n");
        boolean isUserInputNumber;
        int inputNumber;
        if (isUserInputNumber = scanner.hasNextInt()) {
            inputNumber = scanner.nextInt();
            String inputNumberToString = "" + inputNumber;

            int sumOfDigits = 0;
            for (int i=0; i<inputNumberToString.length(); i++) {
                int y = Character.getNumericValue(inputNumberToString.charAt(i));
                sumOfDigits = sumOfDigits + y;
            }
            System.out.println("\n" +  "Sum of all digits: " + sumOfDigits);
        }
        else {
            System.out.println("\n" +  "Your input is not a number!");
        }
    }
}