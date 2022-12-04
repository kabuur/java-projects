import java.util.Stack;

public class stack {

//    class Test
//    {
//        // Pushing element on the top of the stack
//        static void stack_push(Stack<Integer> stack)
//        {
//            for(int i = 0; i < 5; i++)
//            {
//                stack.push(i);
//            }
//        }
//
//        // Popping element from the top of the stack
//        static void stack_pop(Stack<Integer> stack)
//        {
//            System.out.println("Pop Operation:");
//
//            for(int i = 0; i < 5; i++)
//            {
//                Integer y = (Integer) stack.pop();
//                System.out.println(y);
//            }
//        }
//
//        // Displaying element on the top of the stack
//        static void stack_peek(Stack<Integer> stack)
//        {
//            Integer element = (Integer) stack.peek();
//            System.out.println("Element on stack top: " + element);
//        }
//
//        // Searching element in the stack
//        static void stack_search(Stack<Integer> stack, int element)
//        {
//            Integer pos = (Integer) stack.search(element);
//
//            if(pos == -1)
//                System.out.println("Element not found");
//            else
//                System.out.println("Element is found at position: " + pos);
//        }


        static void  pushing_stack(Stack<Integer> stack){
            for(int i = 0; i < 5; i++){
                stack.push(i);
            }
            System.out.println(stack);
        }

    static  void top_element(Stack<Integer> stack){
        Integer element = (Integer) stack.peek();
        System.out.println("this is the frist element inthe stack: "+element);
    }

           //  Searching element in the stack
        static void stack_search(Stack<Integer> stack, int element)
        {
            Integer pos = (Integer) stack.search(element);

            if(pos == -1)
                System.out.println("Element not found");
            else
                System.out.println("Element is found at position: " + pos);
        }
    static boolean  searching(Stack<Integer> stack, int data){
            for (int i = stack.size(); i >= 0; i--){
                if(stack.search(i)==data){
                    System.out.println("this is searching "+ stack.search(i));

                    return true;

                }
            }
            return false;
    }

    static void sorting( int []stack){
//            int length = stack.length;

            for (int i = 0; i<= stack.length; i++){
                int tem_size = i+1;
                for (int j = tem_size; j<= stack.length; j++){
                    if (stack[i] > stack[j]){
                        stack[j] = stack[i];
                    }
                }
            }
    }
       static void poping_stack(Stack<Integer> stack){
            while(!stack.isEmpty()){
                System.out.println( stack.pop());
            }

        }


        public static void main (String[] args)
        {
            Stack<Integer> stack = new  Stack<Integer>();
            pushing_stack(stack);
            top_element(stack);
            int search = 3;
            stack_search(stack,search);
           if(searching(stack, search)==true){
               System.out.println("we found : "+ search);
           }
           else {
               System.out.println("we don't found "+ search);
           }
            poping_stack(stack);


//            Stack<Integer> stack = new Stack<Integer>();

//            stack_push(stack);
//            stack_pop(stack);
//            stack_push(stack);
//            stack_peek(stack);
//            stack_search(stack, 2);
//            stack_search(stack, 6);
//        }
    }
}
