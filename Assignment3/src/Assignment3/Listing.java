package Assignment3;

public class Listing {
    private String name;
    private String number;

    public Listing(){
        name = " ";
        number = "";
    }
    public Listing(String n, String num){
        name = n;
        number = num;
    }
    public String toString(){
        return ("Name is " + name + "\n" + "Number is " + number + "\n");
    }
    public Listing deepCopy(){
        Listing clone = new Listing(name, number);
        return clone;
    }
}
