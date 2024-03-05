public class BingoColumnChecker extends BingoChecker {
    int col;
    public BingoColumnChecker(BingoCard card, int col) {
        super(card);
        this.col = col-1;
    }

    @Override
    public void run() {
        for(int row = 0; row < 5; row++){
            int num = card.nums[row][col];
            while(true){
                try {
                    synchronized (BingoGame.result) {
                        BingoGame.result.wait();
                    }
                } catch (InterruptedException e) {

                }
            }
        }
        System.out.println("Card " +card.id +" done:" +card);
    }
}
