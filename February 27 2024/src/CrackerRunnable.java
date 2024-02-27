public class CrackerRunnable implements Runnable{

    char start;
    String pass;
    int len;
    int num;

    static boolean found = false;

    public CrackerRunnable(char start, String pass, int num) {
        this.start = start;
        this.pass = pass;
        this.num = num;
    }



    @Override
    public void run() {
        // from ch+"aaaaa..." until ch+"zzzzz..."
        // example: pass = cool, ch = j
        // this thread searches jaaa to jzzz

        len = pass.length();
        String atk = start + "a".repeat(len - 1);


        while (!atk.equals(pass) && found == false) {
            System.out.println(atk);
            int i;
            for (i = len - 1; atk.charAt(i) == 'z'; i--) ;
            String first = atk.substring(0, i);
            char next = (char) (atk.charAt(i) + 1);
            String after = "a".repeat(len - i - 1);
            atk = first + next + after;

            if (atk.equals(pass)) {
                found = true;

            }
        }
            if(atk.equals(pass)){
                System.out.println(" Thread " + num + " Found: " + atk);
            }

        }

}


