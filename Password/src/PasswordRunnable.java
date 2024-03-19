public class PasswordRunnable implements Runnable {
    int position, id;
    char start;
    static String password;
    public static boolean isCorrect = false;
    public PasswordRunnable(int id, char start,int position, String password) {
        this.id = id;
        this.position = position;
        this.start = start;
        this.password = password;

    }
    private String crack(String atk) {
        return atk.substring(0, position) + start + atk.substring(position);
    }
    @Override
    public void run() {
        int len = password.length();
        String atk = "a".repeat(len - 1);
        while( !crack(atk).equals(password) && !isCorrect) {
            System.out.println("Thread[" + id + "]: " + crack(atk));
            int i ;
            for( i = atk.length() - 1; i >= 0 && atk.charAt(i) == 'z'; i-- );
            if (i < 0) return;
            String first = atk.substring(0, i);
            char next = (char) (atk.charAt(i) + 1);
            String after = "a".repeat(len - i - 2);
            atk = first + next + after;
        }
        if(crack(atk).equals(password)) {

            isCorrect = true;
            System.out.println("Hacking Complete...");
            System.out.println("Thread["+ id + "] Found: " + crack(atk));
        }
    }
}