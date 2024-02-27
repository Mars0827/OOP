import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter your password: ");
        String pass = scan.nextLine();
        Thread[] thread = new Thread[26];
        //int len = pass.length();
        char first = 'a';

        for(int i=0; i<26;i++) {
            thread[i] = new Thread(new CrackerRunnable(first,pass, i));
            first++;
        }
        for(Thread t: thread){
            t.start();
        }


    }
}