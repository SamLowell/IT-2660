package Graph;
//change so makes a queue of integers (indexes) not nodes?
public class Queue {
    private int end;
    private int head;
    private int size = 0;

    private int queue[];

    public void setend(int End){
        end = End;
    }
    public int getend(){
        return end;
    }
    public void sethead(int Head){
        head = Head;
    }
    public int gethead(){
        return head;
    }
    public void setSize(int n){
        size = n;
    }
    public int getSize(){
        return size;
    }

    public Queue(int max){
        queue = new int[max];
    }

    public void deleteHead(){
        //removes first node
        for(int i = 0; i < size; i++){
            queue[i] = queue[i + 1];
        }
        head = queue[0];
        size--;
    }
    public void addEnd(int index){
        //add new node to queue
        if(size == 0){
            head = index;
        }
        queue[size] = index;
        end = index;
        size++;
    }
    public boolean isEmpty(){
        return size == 0;
    }
}
