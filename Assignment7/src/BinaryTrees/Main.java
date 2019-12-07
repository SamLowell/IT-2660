package BinaryTrees;
import java.util.*;
public class Main {

    public static void main(String[] args) {
	Node test = new Node(new Listing[]{new Listing("Andrew"), new Listing("Bob"), new Listing("Doug"),
            new Listing("Grace"), new Listing("Jane"), new Listing("Zack")});

	    //test.printList();
		Node ptest = test.findParentNode("Zack");
		Node ptest2 = test.findParentNode("Bob");
	   Listing trial = test.getListing("Doug");
	   Listing trial2 = test.getListing("Jane");
	   Listing trial3 = test.getListing("Zack");
       // System.out.println(trial.toString());
		Node trialN = test.findNode("Doug");
		test.deleteNode("Bob");
    }
}
