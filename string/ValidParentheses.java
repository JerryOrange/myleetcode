import java.util.Stack;

/**
 * 020. Valid Parentheses
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 * <p>
 * Created by Jiacheng on 2018/3/8.
 */
public class ValidParentheses {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (char c : s.toCharArray()) {
            if (c == '(')
                stack.push(')');
            else if (c == '{')
                stack.push('}');
            else if (c == '[')
                stack.push(']');

            else if (stack.isEmpty() || stack.pop() != c)
                return false;
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        //input([]), expected return true;
        String parentheses = "()[]{}";
        boolean solution = new ValidParentheses().isValid(parentheses);
        System.out.println("solution is " + solution);
    }
}
