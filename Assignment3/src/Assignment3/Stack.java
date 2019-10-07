package Assignment3;

public class Stack {
    private Listing[] data;
    private int top;
    private int size;

    public Stack(){
        top = -1;
        size = 3;
        data = new Listing[3];
    }

    public Stack(int n){
        top = -1;
        size = n;
        data = new Listing[n];
    }

    public boolean push(Listing newNode){
        Listing[] tempStack = new Listing[this.data.length + 1];
        if(top == this.data.length - 1){
            for(int i = 0; i <= top; i++){
                tempStack[i] = this.data[i];
            }
            top = top + 1;
            tempStack[top] = newNode.deepCopy();
            this.data = tempStack;
            return true;
        }
        else{
            top = top + 1;
            data[top] = newNode.deepCopy();
            return true;
        }
    }
    public Listing pop(){
        int topLocation;
        if(top == -1)
            return null;
        else{
            topLocation = top;
            top = top - 1;
            return data[topLocation];
        }
    }
    public void showAll(){
        for(int i = top; i >= 0; i--)
            System.out.println(data[i].toString());
    }

    //empty out the stack (top to bottom)
    public void emptyStack(){
        if (top == -1){
            System.out.println("Stack is already empty.");
        }
        for (int i = top; i >= 0; i--){
            pop();
            }
    }
    //test to see if stack is empty, true == empty
    public boolean underflow(){
        if(top == -1)
            return true;
        else
            return false;
    }
    //test to see if stack is full, true == full
    public boolean overflow(){
        if(top == data.length - 1)
            return true;
        else
            return false;
    }


}
