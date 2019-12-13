package Graph;
import java.util.Random;
public class Node {
    private int value;
    private boolean visited;


    Random rand = new Random();
    //test constructor
    public Node(){
        visited = false;
        this.value = rand.nextInt(1000);
    }

    public void setValue(){
        this.value = rand.nextInt(1000);
    }
    public void setValue(int numb){
        this.value = numb;
    }
    public int getValue(){
        return this.value;
    }
    public void setVisited(boolean Visit){
        visited = Visit;
    }
    public boolean getVisited(){
        return visited;
    }

    public String toString(){
        return ("Node: " + this.value);
    }
    public void print(){
        System.out.println(this.toString());
    }


}
