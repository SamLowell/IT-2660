package Ch1Problem41_Lowell;

import java.util.Scanner;

public class Listing {
    private String name;
    private int age;
    Scanner keyboard = new Scanner(System.in);

    public Listing() {
        name = " ";
        age = 0;
    }
    public Listing(String Name, int Age){
        name = Name;
        age = Age;
    }

    public String toString(){
        return ("Name: " + this.name + "\nAge: " + this.age);
    }
    public void input(){
        System.out.println("Enter Name: ");
        name = keyboard.next();
        System.out.println("Enter Age: ");
        age = keyboard.nextInt();
    }
    public void setName(String newName){
        this.name = newName;
    }
    public String getName(){
        return name;
    }
    public void setAge(int newAge){
        this.age = newAge;
    }
    public int getAge(){
        return age;
    }
}
