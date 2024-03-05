import java.util.Random;

public class BingoCard {

    int[][] nums;
    int id;

    public BingoCard(int id) {
        this.id = id;

        nums = new int[5][5];


        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                int randVal = 0;
                Random random = new Random();

                do {
                    if (j == 0) {
                        randVal = (int) (Math.ceil((Math.random() * 15) + 0));
                    } else if (j == 1) {
                        randVal = (int) (Math.ceil((Math.random() * 15) + 30));
                    } else if (j == 2 && i != 2) {
                        randVal = (int) (Math.ceil((Math.random() * 15) + 45));
                    } else if (j == 3) {
                        randVal = (int) (Math.ceil((Math.random() * 15) + 60));
                    } else if(j==4){
                        randVal = (int) (Math.ceil((Math.random() * 15) + 75));
                    }
                } while (isTheSame(randVal, i, j));

                nums[i][j] = randVal;
            }
        }

        nums[2][2] = 0;

    }

        public boolean isTheSame(int num, int upperbound, int col){
            for(int i=0;i<upperbound;i++) {
                if(nums[i][col] == num){
                    return true;
                }
            }
            return false;
        }




    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(int row = 0; row < 5; row++){
            for(int col = 0; col < 5; col++){
                sb.append(nums[row][col]).append("\t");
            }
            sb.append("\n");
        }

        return sb.toString();
    }
}
