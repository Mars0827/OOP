import org.w3c.dom.ls.LSOutput;

public class SomethingExeption extends Exception{

    public SomethingExeption() {
        super("There's no such thing as a negative age");
    }

    public SomethingExeption(String message) {
        super(message);
    }
}
