
public class Person {
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person(int age) throws Exception {
        if(age < 0){

            throw new SomethingExeption();
        }
        this.age = age;
    }

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void birthday(){
        int oldAge = age;

        age++;
        System.out.println("Happy Birthday! I wish you the best of everything! You are now " + age );
        assert age > oldAge : "Age must increase on birthdays";
    }

}
