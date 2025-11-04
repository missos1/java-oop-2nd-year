import java.util.Scanner;
import java.util.Stack;

public class QueueWithTwoStacks {
     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int q = sc.nextInt();
        
        Stack<Integer> stack0 = new Stack<>(); 
        Stack<Integer> stack1 = new Stack<>(); 
        
        for (int i = 0; i < q; i++) {
            int querytype = sc.nextInt();
            
            switch (querytype) {
                default:
                    int value = sc.nextInt();
                    stack0.add(value);
                    break;
                case 2:
                    shiftStack(stack0, stack1);
                    stack1.pop();
                    
                    break;
                case 3:
                    shiftStack(stack0, stack1);
                    System.out.println(stack1.peek());
                    
                    break;
            }
        }
        sc.close();
    }
    
    /**
     * Shifts elements from stack0 to stack1 if stack1 is empty.
     * 
     * @param stack0 the queue input stack
     * @param stack1 the queue output stack
     */
    private static void shiftStack(Stack<Integer> stack0, Stack<Integer> stack1) {
        if (stack1.isEmpty()) {
            while(!stack0.isEmpty()) {
                stack1.add(stack0.pop());
            }
        }
    }
}
