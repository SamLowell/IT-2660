package Assignment2;

import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
	/*Test program for exercise 19*/
	/*Students s1 = new Students("Bob", "12345", 3.2);
	System.out.println(s1.toString());
	Students s2 = s1.deepCopy();
	s2.compareTo("Bob");
	System.out.println(s2.toString());
	Students s3 = new Students();
	s3.input();
	System.out.println(s3.toString());*/


    //exercise 21, I can make this more like the book asks for if needed.
        StudentList newList = new StudentList();
        newList.printStudentList();
        System.out.println("Now add a new student. ");
        newList.insert(0);

        newList.printStudentList();
        System.out.println("Please enter one of the student names listed above to delete. ");
        String student = keyboard.next();
        newList.delete(student);
        newList.printStudentList();

    }
}
