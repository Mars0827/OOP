import jdk.jfr.StackTrace;

import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        boolean done = false;
        int num;
        Scanner sc = new Scanner(System.in);


        while(!done){
            try{
                System.out.print("Enter the age of the person: ");
                Person p = new Person(sc.nextInt());
                System.out.println("The person's age is " + p.getAge());
                p.birthday();
                done = true;



            } catch (Exception e){
                System.out.println("Not a number");
                System.out.println(e.getMessage());
                System.out.println("Catch 2");
                System.out.println("Enteranother number");
            } finally {
                System.out.println("Ariel happened to me");

            }



        }
    }
}