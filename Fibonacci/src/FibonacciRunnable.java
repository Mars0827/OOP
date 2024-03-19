public class FibonacciRunnable implements Runnable {
    private int n;
    public FibonacciRunnable(int n) {
        this.n = n;
    }
    @Override
    public void run() {
        try {
            if(n == 1){
                Main.results[0] = 0;
            }else if(n == 2){
                Main.results[1] = 1;
                Main.threads[n-2].start();
                synchronized (Main.threads[n-2]){
                    Main.threads[n-2].join();
                }
            }else{
                Main.threads[n-2].start();
                synchronized (Main.threads[n-2]){
                    Main.threads[n-2].join();
                }
                Main.results[n - 1] = Main.results[n-2] + Main.results[n-3];
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}