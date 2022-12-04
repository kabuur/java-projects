import java.util.Arrays;

public class sorting_Array {




        public static int[] descendingSelectionSort(int[] array) {

            //Selection sort with descending order
            for (int indexTobeSorted = array.length - 1; indexTobeSorted > 0; indexTobeSorted--) {
                int indexOfSmallestValue = 0;
                for (int index = 0; index < indexTobeSorted; index++) {
                    if (array[index + 1] > array[indexOfSmallestValue]) {
                        indexOfSmallestValue = index + 1;
                    }
                }
                int swp=array[indexOfSmallestValue];
                array[indexOfSmallestValue]=array[indexTobeSorted];
                array[indexTobeSorted]=swp;


            }


            return array;
        }

        static void dispaly(int[]data){
            for (int i =0 ; i< data.length;i++){
                System.out.print(data[i]+" ");
            }
        }

    static void dispaly1(int[]data){
        for (int i =0 ; i< data.length;i++){
            System.out.print(data[i]+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] array = { 18, 32, -11, 6, 68, 2, -34 };
        dispaly1(array);
         descendingSelectionSort(array).toString();
        dispaly(array);



    }
}
