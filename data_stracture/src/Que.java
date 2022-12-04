import java.util.LinkedList;
import java.util.Queue;

public class Que {



    public static  void main(String[] arg){

        Queue<String> q1 = new LinkedList<String>();
        q1.add("ahmed");
        q1.add("shariif");
        q1.add("cabdala");
        q1.add("nuur");
        System.out.println(q1);
        System.out.println("the FIFO: "+q1.poll());
        System.out.println(q1.size());
        System.out.println("removent spicific element"+q1);

        System.out.println(q1);


        /*
         * We can remove an element from Queue using remove() method,
         *this removes the first element from the Queue
         */
        System.out.println("this remove the frist element in the que: remove() "+q1.remove());

        /*
         *element() method - this returns the head of the
         *Queue.
         */

        System.out.println("this returns the frist element in the que: .element() " + q1.element());
        /*
         *poll() method - this removes and returns the
         *head of the Queue. Returns null if the Queue is empty
         */
        System.out.println("removes and returns the head of que poll() : "+q1.poll());

        /*
         *peek() method - it works same as element() method,
         *however, it returns null if the Queue is empty
         */
        System.out.println("this is work like element retuns the head of the element peek(): "+q1.peek());

        System.out.println(q1);
        System.out.println();
        System.out.println();
        LinkedList<String> ll = new LinkedList<String>();
        ll.add("maxamed");
        ll.add("cabdulahi");
        ll.add("muqtaar");

        System.out.println(ll);

    }
}
