import java.util.Scanner;

public class ASCII_Dancer {


    public static void main(String[] arg) {


//        String word = input.nextLine();

        as();


    }

    static void as() {
        Scanner input = new Scanner(System.in);
        String st = input.next();
        String temp=st;
        if(temp.substring(0,3).equals("say")) {
            System.out.println(input.next());

        }else if(st.equals("left hand to start")) {
            System.out.println(" o");
            System.out.println("/|\\");
            System.out.println("/ \\");
        } else if (input.next() == "left hand to head") {
            System.out.println(" o)");
            System.out.println("/|");
            System.out.println("/ \\");
        } else if (input.next() == "left hand to hip") {
            System.out.println(" o");
            System.out.println("/|>");
            System.out.println("/ \\");
        } else if (input.next() == "left hand to start") {
            System.out.println(" o");
            System.out.println("/|\\");
            System.out.println("/ \\");
        } else if (input.next() == "right leg in") {
            System.out.println(" o");
            System.out.println("/|\\");
            System.out.println("< \\");
        } else if (input.next() == "right hand to hip") {
            System.out.println(" o");
            System.out.println("<|\\");
            System.out.println("/ \\");
        } else if (input.next() == "right hand to head") {
            System.out.println(" o)");
            System.out.println("<|");
            System.out.println("/ \\");
        }
        else {
            System.out.println("jjj");
        }
    }
}