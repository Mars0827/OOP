public class MyList {
    private int array[];
    static int capacity;
    private int arrsize;

    public MyList(){
        arrsize = 0;
        capacity = 5;

        this.array = new int[5];
    }



    public void add(int num) throws ArrayFullException {
       try{
           array[arrsize] = num;
           arrsize++;
       } catch (ArrayIndexOutOfBoundsException e){
           throw new ArrayFullException(num);
       }


    }

    public void addAt(int pos, int num) throws ArrayFullException {
        if(arrsize == 5){
            throw new ArrayFullException(num);
        }
        if(pos > arrsize+1){
            throw new InvalidPositionException(arrsize+1);
        }

        else {
            for(int i = arrsize; i >= pos; i--){
                array[i] = array[i-1];
            }
            array[pos-1] = num;
            arrsize++;
        }
    }

    public boolean remove(int num){
        for(int i = 0; i < arrsize; i++){
            if(array[i] == num){
                for(int j = i; j < arrsize-1; j++){
                    array[j] = array[j+1];
                }
                array[arrsize-1] = 0;
                arrsize--;
                return true;
            }
        }
        return false;
    }

    public int removeAt(int pos){

        if(pos > arrsize){
            throw new InvalidPositionException(arrsize);
        } else {
            int removed = array[pos-1];
            for(int i = pos-1; i < arrsize; i++){
                array[i] = array[i+1];
            }
            arrsize--;
            return removed;
        }

    }

    public boolean contains(int num){
        for(int i = 0; i < arrsize; i++){
            if(array[i] == num){
                return true;
            }
        }

        return false;
    }

    public int size(){
        return arrsize;
    }

    public boolean isEmpty(){
        if(arrsize == 0) return true;
        else return false;
    }

    public int get(int pos){

        if(pos > arrsize || (pos-1) < 0){
            throw new InvalidPositionException(arrsize);
        } else {
            return array[pos-1];
        }
    }

    public int set(int pos, int num){

        if(pos > arrsize || (pos-1) < 0){
            throw new InvalidPositionException(arrsize);
        } else {
            int replaced = array[pos-1];
            array[pos-1] = num;
            return replaced;
        }
    }


}
