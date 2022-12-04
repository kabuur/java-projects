import java.util.LinkedList;
import java.util.Queue;

public class reverse {



    public static void main(String[] args){
        System.out.println(  rev("ahmed"));
    }

    public static String rev(String data){

        Queue<Character> word =new LinkedList<>();

        for (int i=data.length()-1; i>=0; i--){
            word.add(data.charAt(i));
        }
        String resalt="";

        while (!word.isEmpty()){
            resalt += word.poll();
        }


        return resalt;
    }
}
