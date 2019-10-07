package Assignment3;

public class Main {

    public static void main(String[] args) {

        Stack stack1 = new Stack(3);
        stack1.push(new Listing("Bob", "123-1111"));
        stack1.push(new Listing("Joe", "134-1235"));
        stack1.push(new Listing("Jane", "123-2225"));
        stack1.showAll();

        System.out.println(stack1.overflow());
        System.out.println(stack1.underflow());
        stack1.emptyStack();
        stack1.showAll();
        System.out.println(stack1.underflow());

        stack1.push(new Listing("Bob", "123-1111"));
        stack1.push(new Listing("Joe", "134-1235"));
        stack1.push(new Listing("Jane", "123-2225"));
        stack1.push(new Listing("Mary", "123-7777"));
        stack1.showAll();

    }
}
