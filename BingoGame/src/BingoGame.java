import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class BingoGame implements Runnable{

    public static boolean[] result;
    List<BingoCard> cards;
    public static boolean  bingo;

    int[] arr = new int[76];

    public BingoGame() {
        result = new boolean[76];
        result[0] = true;
        bingo = false;
    }

    @Override
    public void run() {
        Scanner sc = new Scanner(System.in);
        System.out.print("How many players? ");
        int cnt = sc.nextInt();
        cards = new ArrayList<>();
        for (int i = 0; i < cnt; i++) {
            cards.add(new BingoCard(i+1));
        }
        for (BingoCard card : cards) {
            System.out.println("Card " + card.id);
            System.out.println(card);
        }
        // TODO create your checker threads per card
        Thread[] checkerThrds = new Thread[cnt];
        for (int i = 0; i < cnt; i++) {
            checkerThrds[i] = new Thread(new BingoRowChecker(cards.get(i), 3));
        }
        // TODO start all threads
        for(int i = 0; i < cnt; i++){
            checkerThrds[i].start();
        }

        // TODO RANDOM RESULTS



        // TODO randomly get number from 1-75 while not bingo

        int randVal = 0;
        Random random = new Random();
        int ctr = 0;
        while(!bingo){

            for(int i = 0; i < 76; i++){
                do{
                    randVal = random.nextInt(75) + 1;
                }while(isPresent(randVal,i));
            }
            arr[ctr] = randVal;
            System.out.println("NumberChosen: " + randVal);

            for(int i = 0; i < ctr; i++){
                System.out.print(" "+ arr[i] + " ");
            }
            System.out.println("\n");

            result[randVal] = true;

            synchronized (result){
                result.notifyAll();
            }

            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch(ArrayIndexOutOfBoundsException e){

            }
            ctr++;
        }

    }


    private boolean isPresent(int num, int upper){
        boolean present = false;
        for(int i = 0; i < upper; i++){
            if(num == arr[i]){
                present = true;
                break;
            }
        }
        return present;
    }
}



