package Assignment2;
import java.util.Scanner;
import javax.swing.*;

public class StudentList {
    Scanner keyboard = new Scanner(System.in);
    private Students[] List;
    private int next;


    public StudentList(Students student1){
        this.List = new Students[1];
        this.List[0] = student1;
        next = 1;
    }
    public StudentList(){
        System.out.println("Enter number of students in list: ");
        int listLength = keyboard.nextInt();
        this.List = new Students[listLength];
        next = 0;
        this.fillInList();
    }
    //user create array
    public void fillInList(){
        for (int i = 0; i < this.List.length; i++){
            Students student = new Students();
            student.input();
            List[i] = student;
            next++;
        }
    }

    //print array
    public void printStudentList(){
        System.out.println("Student list: ");
       for (int i = 0; i < this.List.length; i++){
               System.out.println(this.List[i].toString());
       }
       System.out.println();
    }

    //Add one student to array
    public void insert(int position){
        //if array does not already exist
        if (this.List.length == 0 && position ==0){
            this.List = new Students[1];
            this.List[0] = new Students();
            this.List[0].input();
            next++;
            return;
        }

        if (this.List.length < position || position < 0 )
            return;

        //create temp array
        Students[] tempList = new Students[this.List.length + 1];
        //for loop that finds position for new node
        for (int i = 0; i < this.List.length + 1; i++){
            //keeps list the same below position
            if(i<position){
                tempList[i] = this.List[i];
            }
            //moves nodes above new node to new positions
            else if(i > position){
                tempList[i] = this.List[i-1];
            }
            //set new node
            else {
                tempList[i] = new Students();
                tempList[i].input();
                next++;
            }

        }
        this.List = tempList;
    }



    //method to retrieve nod in array (student info)
    public Students fetch(String targetKey){  //Student name is targetKey
        int i = 0;
        //find index of student node
        while (i < List.length && !((List[i].compareTo(targetKey)) == 0)){
            i++;
        }
        //student not found **add try catch
        if (i == (List.length - 1) && !((List[i].compareTo(targetKey)) == 0)){
            System.out.println("No student of that name on file.");
            return null;
        }
        Students student = List[i].deepCopy();
        return student;
    }
    //fetch and print
    public void printFetch(String key){
        Students student = this.fetch(key);
        System.out.println(student.toString());
    }

    //delete student(node) from array
    public void delete(String targetKey){
        int index = 0;
        Students[] tempList = new Students[this.List.length - 1];
        //student not found **add try catch
            while (index < this.List.length && !((this.List[index].compareTo(targetKey)) == 0)) {
                index++;
            }
            if (index == (this.List.length)) {
                   System.out.println("No student of that name on file.");
                   System.exit(0);


            }
            for (int i = 0; i < this.List.length - 1; i++) {
                if (i < index){
                    tempList[i] = this.List[i];
                }
                else {
                    tempList[i] = this.List[i + 1];
                }


            }


            this.List = tempList;


    }





}
