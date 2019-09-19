package Assignment2;

public class Main {

    public static void main(String[] args) {
	StudentListings s1 = new StudentListings("Bob", "12345", 3.2);
	System.out.println(s1.toString());
	StudentListings s2 = s1.deepCopy();
	s2.compareTo("Bob");
	System.out.println(s2.toString());
	StudentListings s3 = new StudentListings();
	s3.input();
	System.out.println(s3.toString());
    }
}
