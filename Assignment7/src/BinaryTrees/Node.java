package BinaryTrees;

import java.util.Arrays;

public class Node {

    private Listing keyName;
    private Node leftChild;
    private Node rightChild;

    public Listing getKeyName(){
        return this.keyName;
    }

    public Node(String name){

        keyName = new Listing(name);
    }
    public Node(Listing student){
        this.keyName = student;
        }
    public Node(Listing[] students){
        int length = students.length;
        //sort array ?
        switch(length){
            case 1: //base case, only one node, leaf
                this.keyName = students[0];
                return;
            case 2: //base case2, two nodes, one child node
                if(students[0].getName().compareTo(students[1].getName()) < 0){
                this.keyName = students[0];
                this.leftChild = new Node(students[1]);}
            default:
                int median = length/2;
                Listing[] leftArray = Arrays.copyOfRange(students, 0, median);
                Listing[] rightArray = Arrays.copyOfRange(students, median + 1, students.length);
                if (leftArray.length > 0){
                    this.leftChild = new Node(leftArray);
                }
                this.keyName = students[median];
                if(rightArray.length > 0){
                    this.rightChild = new Node(rightArray);
                }
        }
    }
    //print all, does not print in alphabetical order
    public void printList(){
        //base case, if no children
        if (this.leftChild == null && this.rightChild == null){
            System.out.println(this.keyName.toString());
        }
        else if(this.leftChild == null){
            System.out.println(this.keyName.toString());
            rightChild.printList();
        }
        else if(this.rightChild == null){
            System.out.println(this.keyName.toString());
            this.leftChild.printList();
        }
        else{
            System.out.println(this.keyName.toString());
            this.rightChild.printList();
            this.leftChild.printList();
        }
    }
    //search, return student info, change so child nodes change
   public Listing getListing(String name){
        //go back to while loop
       Node currentNode = this;
       if(currentNode.keyName.getName().compareTo(name) == 0){
           return currentNode.keyName;
       }
       while (currentNode.keyName.getName().compareTo(name) != 0){
           if(currentNode.keyName.getName().compareTo(name) > 0){
                //left of tree
               currentNode = currentNode.leftChild;
           }
           else{
               currentNode = currentNode.rightChild;
           }
       }
        return currentNode.keyName;
    }
    //find node to replace for delete
    public Node getMinNode(Node node){
        if(node.rightChild == null){
            return node;
        }
        else {
            return getMinNode(node.leftChild);
        }
    }

    //delete
    public void deleteNode(String name){
        Node node = findNode(name);
        Node parentNode = findParentNode(name);
        //if leaf
        if(node.rightChild == null && node.leftChild== null){
            //if left leaf
            if(node.keyName==parentNode.leftChild.keyName){
                parentNode.leftChild = null;
            }
            else{
                parentNode.rightChild = null;
            }
        }
        //if node has child
        if(node.rightChild == null && node.leftChild != null){
            //has leftChild but not right
            if(parentNode.leftChild == node){
                parentNode.leftChild = node.leftChild;
            }
            else{
                parentNode.rightChild = node.leftChild;
            }
        }
        else if(node.rightChild != null && node.leftChild == null){
            if(parentNode.leftChild == node){
                parentNode.leftChild = node.rightChild;
            }
            else{
                parentNode.rightChild = node.rightChild;
            }
        }
        //if node is leftchild of parent
        //if has both children
        if(node.leftChild != null && node.rightChild != null){
            Node replaceNode = getMinNode(node);
            if(parentNode.leftChild == node){
                parentNode.leftChild = replaceNode;
                replaceNode.rightChild = node.rightChild;
            }
            else{
                replaceNode.rightChild = node.rightChild;
                parentNode.rightChild = replaceNode;
            }

        }
    }
    //get Node
    public Node findNode(String name){
        Node currentNode = this;
        if(currentNode.keyName.getName().compareTo(name) == 0){
            return currentNode;
        }
        while (currentNode.keyName.getName().compareTo(name) != 0){
            if(currentNode.keyName.getName().compareTo(name) > 0){
                //left of tree
                currentNode = currentNode.leftChild;
            }
            else{
                currentNode = currentNode.rightChild;
            }
        }
        return currentNode;
    }
    public Node findParentNode(String name){
        Node currentNode = this;
        Node parent = this;
        if(currentNode.keyName.getName().compareTo(name) == 0){
            return currentNode;
        }
        while (currentNode.keyName.getName().compareTo(name) != 0){
            if(currentNode.keyName.getName().compareTo(name) > 0){
                //left of tree
                parent = currentNode;
                currentNode = currentNode.leftChild;
            }
            else{
                parent = currentNode;
                currentNode = currentNode.rightChild;
            }
        }
        return parent;
    }
    //insert
    public void insertNode(Listing newStudent){
        Node currentNode = this;
        //base, if less than currentNode and leftChild is null
        //
    }
    //merge-sort method, change for Listing
    public Listing[] mergeSort(Listing[] L){
        //base
        if (L.length <= 1){
            return L;
        }
        //Implementation, divide into two sublists
        Listing[] left = new Listing[L.length/2];
        Listing[] right = new Listing[L.length - left.length];
        int j = 0;
        for (int i = 0; i < L.length; i++){
            if (i < L.length/2){
                left[i] = L[i];
            }
            else {
                right[j] = L[i];
                j++;
            }
        }
        //recursion, mergeSort left and right sublist
        left = mergeSort(left);
        right = mergeSort(right);
        return merge(left, right);
    }
    //merge method, change for Listing
    public Listing[] merge(Listing[] Left, Listing[] Right){
        Listing[] list = new Listing[Left.length + Right.length];
        int n = 0;
        while (Left.length != 0 && Right.length != 0){

            if (Left[0].getName().compareTo(Right[0].getName()) < 0) {
                list[n] = Left[0];
                Left = deleteFirst(Left);
                n++;
            }
            else {
                list[n] = Right[0];
                Right = deleteFirst(Right);
                n++;
            }
        }
        if (Left.length != 0){
            for (int i = 0; i < Left.length; i++){
                list[n] = Left[i];
                n++;}
        }
        if (Right.length != 0){
            for (int i = 0; i < Right.length; i++){
                list[n] = Right[i];
                n++;}
        }
        return list;
    }
    //change for Listing
    public Listing[] deleteFirst(Listing[] array){
        Listing[] tempArray = new Listing[array.length - 1];
        for(int i = 0; i < tempArray.length; i++){
            tempArray[i] = array[i + 1]; }
        return tempArray;
    }
}
