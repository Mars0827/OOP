import java.util.Objects;
public class MyCatList {

    Cat[] array;
    int capacity = 5;
    int arrsize;

    public MyCatList() {
        array = new Cat[5];
        capacity = 5;
        arrsize = 0;
    }

    void add(Cat cat) throws ArrayFullException{
        try {
            array[arrsize] = cat;
            arrsize++;
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new ArrayFullException(cat);
        }

    }
    void addAt(int pos, Cat cat) throws ArrayFullException {
        if(pos > arrsize+1) {
            throw new InvalidPositionException(arrsize+1);

        } if(arrsize == 5) {
            throw new ArrayFullException(cat);
        }

        for(int i = arrsize; i >= pos; i--) {

            array[i] = array[i-1];

        }

        array[pos-1] = cat;

        arrsize++;

    }

    boolean remove(String name) {
        int index = 0;
        boolean flag = false;
        for(int i = 0; i < arrsize; i++) {
            if(array[i] == null) {
                break;
            } if(Objects.equals(array[i].name, name)) {
                index = i;
                flag = true;
                arrsize--;
                break;
            }
        }

        for(int i = index; i < arrsize; i++) {
            array[i] = array[i+1];
        }
        return flag;
    }

    Cat removeAt(int pos) {
        if(pos > arrsize) {
            throw new InvalidPositionException(arrsize);
        }
        Cat removed = array[pos-1];
        for(int i = pos-1; i < arrsize; i++) {
            array[i] = array[i+1];
        }
        arrsize--;
        return removed;
    }

    boolean contains(String name) {
        for(int i = 0; i < arrsize; i++) {
            if(array[i].name == name) {
                return true;
            }
        }
        return false;
    }

    int size() {
        return arrsize;
    }

    boolean isEmpty() {
        if(arrsize == 0) {
            return true;
        }
        return false;

    }

    Cat get(int pos) {
        if(pos > arrsize || (pos-1) < 0) {
            throw new InvalidPositionException(arrsize);
        }

        return array[pos-1];

    }

    Cat set(int pos, Cat cat) {
        if(pos > arrsize || (pos-1) < 0) {
            throw new InvalidPositionException(arrsize);
        }
        Cat replaced = array[pos-1];
        array[pos-1] = cat;
        return replaced;
    }
}