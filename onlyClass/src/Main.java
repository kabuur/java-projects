public class Main {
    public static void main(String[] args) {
        // sidaan ayey jacelkooda ushegtaan progrmerisku
        String names="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int [] num =  {0,1,2,3,4,5,6,7,8,9,10,11,
                12,13,14,15,16,17,18,19,20,21,22,23,24,25,26};
        int  s=25;
        int rows = 2;
        int columns = 13;
        String [][] Array=new String[rows][columns];
        for(int i=0;i<rows;i++) {
            for(int j=0;j<columns; j++){
                Array[i][j] = String.valueOf(names.charAt(s));
                s--;
            }
        }
        System.out.println("I Love You "+ Array[num[1]][num[0]]+
                Array[num[0]][num[num[1]]]+" "
                +Array[num[1]][num[1]] +
                Array[num[1]][num[4]] +Array[num[1]][num[7]]
                +Array[num[1]][num[8]]);
        }
    }
