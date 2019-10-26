package Assignment4;

public class LinkList {

    private listing root; // first node
    private listing end; //private last node
    private int size;  //private  size of list

    //constructor, creates an empty list
    public LinkList(){
        root = null;
        end = null;
        size = 0;
    }

    //constructor for sample list
    public LinkList(int Size){
        size = Size;
        root = new listing("Bob", "123", 4.0);
        listing middle = new listing("Joe", "456", 3.2);
        end = new listing("Jane", "234", 3.5);
        root.setNext(middle);
        middle.setNext(end);
    }

    //add node to end of list(append)
    public void appendList(){
        listing student = new listing();
        student.input();
        if (root == null){
            root = student;
            size++;
        }
        else {
            end.setNext(student);
            end = student;
            size++;
        }

    }

    //insert node(listing) in a certain spot
    public void insertListing(int position){
        listing w = root;
        if(position >= size){
            appendList();
        }
        else if (position == 0){
            insertNewRoot();
        }
        else{
            for(int i =1; i < position; i++){
                w = w.getNext();
            }
            listing newListing = new listing();
            newListing.input();
            newListing.setNext(w.getNext());
            w.setNext(newListing);
            size++;
        }
    }

    //insert node at beginning of list (root)
    public void insertNewRoot(){
        listing student = new listing();
        student.input();
        student.setNext(root);
        root = student;
        size++;
    }

    //print list
    public void printList(){
        listing w = root;
        for(int i = 0; i < size; i++){
            System.out.println(w.toString());
            w = w.getNext();
        }
        System.out.println();
    }


    //getNode, find specific node (search through list)
    public listing search(String studentName){
        listing student = root;

        if(student.getName() == studentName){
            return student;
        }
        else {
            for(int i = 0; i < size; i++) {
                if (student.getName() == studentName){
                    return student;
                }
                else{
                    student = student.getNext();
                }
            }
            return null;
        }
    }

    //delete node(listing) (possibly use search)
    public void delete(String name){
        listing d = search(name);
        listing prev = root;
        while(prev.getNext() != d){
            prev = prev.getNext();
        }
        prev.setNext(d.getNext());
        size--;
    }
}
