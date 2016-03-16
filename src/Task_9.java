import java.util.Scanner;

public class Task_9 {
    public static void main(String[] args) {

        System.out.println("Program returns n-th number of Fibonacci sequence!");
        System.out.println("\n" +  "Considering following:");
        System.out.println("  n  = 0; 1; 2; 3; 4; 5; 6; ...");
        System.out.println("x(n) = 0; 1; 1; 2; 3; 5; 8; ...");
        System.out.print("\n" + "Please enter which (n-th) number you want to see: ");

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        System.out.println("\n" + "Number " + n + " of Fibonacci sequence = " + Math.round(calculateFibonacci(n)));

    }

    public static double calculateFibonacci (int n) {
        double fibonacciNumber = ((Math.pow(1.618034,n)) - (Math.pow(-0.618034,n)))/Math.sqrt(5);
        return fibonacciNumber;
    }
}
