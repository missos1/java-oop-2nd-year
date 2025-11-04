import java.util.Scanner;
import java.util.Stack;

public class SimpleTextEditor {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        String s = "";
        
        Stack<String> stringStack = new Stack<>();
        
        int q = sc.nextInt();
        for (int i = 0; i < q; i++) {
            int operation = sc.nextInt();
            
            switch (operation) {
                default:
                    stringStack.add(s);
                    s += sc.next();
                    break;
                case 2:
                    stringStack.add(s);
                    int deletelength = sc.nextInt();
                    if (deletelength == s.length()) {
                        s = "";
                    }
                    else {
                        s = s.substring(0, s.length() - deletelength);
                    }
                    break;
                case 3:
                    int index = sc.nextInt();
                    System.out.println(s.charAt(index - 1));
                    break;
                case 4:
                    s = stringStack.pop();
                    break;
            }
        }
        
        sc.close();
    }
}