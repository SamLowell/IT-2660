package Assignment2;

import javax.swing.*;

public class StudentList {
    private Students[] List;

    public StudentList(Students student1){
        this.List = new Students[1];
        this.List[0] = student1;
    }
    public StudentList(int listLength){
        listLength = Integer.parseInt(JOptionPane.showInputDialog("Enter number of students in list: "));
        this.List = new Students[listLength];
    }
    //user create array
    public void fillInList(){
        for (int i = 0; i < this.List.length; i++){
            Students student = new Students();
            student.input();
            List[i] = student;
        }

    }
    //Add one student to array
    public void insert(Students student, int position){
        //if array does not already exist
        if (this.List.length == 0 && position == 0){
            this.List = new Students[1];
            this.List[0] = student;
        }
        //add in throw and catch? or println?
        if (position < 0 || position > this.List.length){
            return;
        }

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
                tempList[i] = student;
            }
        }

    }



}
