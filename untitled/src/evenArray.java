import java.util.Scanner;

public class evenArray {
 public static  void main(String[] args){
     num(4,2);
 }
    Scanner input= new Scanner(System.in);

    static void num(int m, int n){
        int length= m;
        int col=n;
        for(int i=1; i<=m; i++){
            for(int j=1;j<=col; j++){
                System.out.println(i+""+j);
            }
        }
    }

}
