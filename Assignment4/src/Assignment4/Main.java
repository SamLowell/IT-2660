package Assignment4;

public class Main {

    public static void main(String[] args) {
	//I coded a short premade linked list to test the methods on.
	LinkList sampleList = new LinkList(3);
		sampleList.printList();

	listing s = sampleList.search("Joe");
	System.out.println(s.toString());

	sampleList.appendList();
	sampleList.insertNewRoot();

	sampleList.insertListing(2);

	sampleList.delete("Jane");

	sampleList.printList();

    }
}
