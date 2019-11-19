package Assignment6;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        //int[] test = {5, 3, 8, 0, 4, 2, 1, 7, 3, 4, 9, 1, 4};
        //int[] tester = mergeSort(test);
        //printList(tester);

        int[] list = new int[100];
        createRandomList(list);
        //print unordered list
        printList(list);
        //merge and sort numbers
       int[] sortedList = mergeSort(list);
       printList(sortedList);

    }

    //fill in array
    public static void createRandomList(int[] array){
        Random rand = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = rand.nextInt(1000);
        }
    }

    public static void printList(int[] L){
        for (int i = 0; i < L.length; i++) {
            System.out.println(L[i]);
        }
    }
    //merge-sort method
    public static int[] mergeSort(int[] L){
        //base
        if (L.length <= 1){
            return L;
        }
        //Implementation, divide into two sublists
        int[] left = new int[L.length/2];
        int[] right = new int[L.length - left.length];
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
    //merge method
    public static int[] merge(int[] Left, int[] Right){
        int[] list = new int[Left.length + Right.length];
        int n = 0;
        while (Left.length != 0 && Right.length != 0){

            if (Left[0] <= Right[0]) {
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

    public static int[] deleteFirst(int[] array){
        int[] tempArray = new int[array.length - 1];
        for(int i = 0; i < tempArray.length; i++){
            tempArray[i] = array[i + 1]; }
        return tempArray;
    }
}
