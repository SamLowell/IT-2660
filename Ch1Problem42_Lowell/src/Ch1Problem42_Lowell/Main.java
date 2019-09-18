package Ch1Problem42_Lowell;

public class Main {

    public static void main(String[] args) {

        Listing[] list = new Listing[3];

        for(int i = 0; i < 3; i++){

            list[i] = new Listing();
            list[i].input();
        }

        for(int i = 2; i > -1; i--){
            System.out.println();
            System.out.println(list[i].toString());
        }

    }
}
