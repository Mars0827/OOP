import java.util.Scanner;
public class Main {
    public static Thread[] threads;
    public static int[] results;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Fibonacci Printer");
        System.out.print("Enter the first n number you want to print: ");
        int num = sc.nextInt();
        threads = new Thread[num];
        results = new int[num];
        for(int i = 0; i < num; i++){
            threads[i] = new Thread(new FibonacciRunnable(i+1));
        }
        threads[num - 1].start();
        for(int i = 0; i < num; i++){
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println("Here is the first " + num + " of the Fibonacci:");

        for(int i = 0; i < num; i++){
            System.out.print(results[i] + " ");
        }
    }
}