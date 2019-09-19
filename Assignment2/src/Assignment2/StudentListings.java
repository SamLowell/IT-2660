package Assignment2;

import javax.swing.*;

public class StudentListings {
    private String name; //key field
    private String idNumber;
    private double gpa;

    public void setName(String Name){
        name = Name;
    }
    public String getName(){
        return name;
    }
    public void setIdNumber(String id){
        idNumber = id;
    }
    public String getIdNumber(){
        return idNumber;
    }
    public void setGpa(double G){
        gpa = G;
    }
    public double getGpa(){
        return gpa;
    }

    public StudentListings(){
        name = "unknown";
        idNumber = "0";
        gpa = 0;
    }
    public StudentListings(String Name, String ID, double G){
        name = Name;
        idNumber = ID;
        gpa = G;
    }
    public String toString(){
        return("Name: " + this.name + "\nID Number: "+ this.idNumber + "\nGrade Point Average: " + this.gpa);
    }
    public StudentListings deepCopy(){
        StudentListings clone = new StudentListings(name, idNumber, gpa);
        return clone;
    }
    public int compareTo(String targetKey){
        return (name.compareTo(targetKey));
    }
    public void input(){
        name = JOptionPane.showInputDialog("Enter Student Name: ");
        idNumber = JOptionPane.showInputDialog("Enter Student ID Number: ");
        gpa = Double.parseDouble(JOptionPane.showInputDialog("Enter Student GPA: "));
    }

}
