
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static final char[] VOWELS = {'a','e','i','o','u'};
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter password: ");
        String password = sc.nextLine();
        int thrdcnt = 0;
        ArrayList threads = new ArrayList<>();

        for(int i = 0; i < password.length(); i++) {
            for(int j = 0; j < 5; j++) {
                thrdcnt++;
                Thread t = new Thread(new PasswordRunnable(thrdcnt, VOWELS[j], i, password));
                threads.add(t);
                t.start();
                //System.out.println(t.getState());
            }
        }
        for(int i = 0; i < 5; i++) {
            try {
                threads.get(i).wait();
            } catch (InterruptedException e) {
            }
        }


    }

}

