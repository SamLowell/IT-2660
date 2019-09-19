package Ch1Problem41_Lowell;

public class Main {

    public static void main(String[] args) {
        Listing p1 = new Listing("John Doe", 40);
        System.out.println(p1.toString());
        Listing p2 = new Listing();
        System.out.println(p2.toString());

        p2.setAge(43);
        p2.setName("Josh Doe");
        System.out.println(p2.toString());

        Listing p3 = new Listing();
        p3.input();
        System.out.println(p3.toString());
        p3.getAge();
        p3.getName();
    }
}
