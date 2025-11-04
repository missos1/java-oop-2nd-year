import java.util.Stack;

public class BalancedBrackets {
    public static String isBalanced(String s) {
        int i = 0;
        Stack<Character> check = new Stack<>();
        while (i < s.length()) {
            if (s.charAt(i) == '{' || s.charAt(i) == '[' || s.charAt(i) == '(') {
                check.add(s.charAt(i));
            } else {
                switch (s.charAt(i)) {
                    case '}':
                        if (check.isEmpty() || check.pop() != '{') {
                            return "NO";
                        }
                        break;
                    case ')':
                        if (check.isEmpty() || check.pop() != '(') {
                            return "NO";
                        }
                        break;
                    case ']':
                        if (check.isEmpty() || check.pop() != '[') {
                            return "NO";
                        }
                        break;
                }
            }
            i++;
        }
        
        return check.isEmpty() ? "YES" : "NO";
    }
}
