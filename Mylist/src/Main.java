public class Main {
    public static void main(String[] args) {

        MyList list = new MyList();

        try {
            list.add(20);
            list.add(40);
            list.add(50);
            list.addAt(2, 30);
            list.addAt(1, 10);


            for(int i = 0; i < 5; i++){
                System.out.println(list.get(i));
            }
        } catch (ArrayFullException e) {
            throw new RuntimeException(e);
        }

        System.out.println(list.get(0));
    }
}