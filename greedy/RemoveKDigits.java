import java.util.Stack;

/**
 * 402. Remove K Digits
 * <p>
 * Given a non-negative integer num represented as a string, remove k digits from the number so that the new number is the smallest possible.
 * Note:
 * The length of num is less than 10002 and will be ≥ k.
 * The given num does not contain any leading zero.
 * <p>
 * Created by Jiacheng on 2018/3/27.
 */
public class RemoveKDigits {

    public String removeKdigits(String num, int k) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < num.length(); i++) {
            //将字符型num转为整数使用
            int number = num.charAt(i) - '0';
            while (stack.size() != 0 && stack.peek() > number && k > 0) {
                //栈顶元素大于number
                stack.pop();
                k--;
            }
            if (number != 0 || stack.size() != 0) {
                //入栈
                stack.push(number);
            }
        }
        //栈不为空时，且仍可以删除数字
        while (stack.size() != 0 && k > 0) {
            stack.pop();
            //更新k
            k--;
        }
        //遍历栈，存进solution
        int size = stack.size();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < size; i++) {
            stringBuffer.append(stack.pop().toString());
        }
        if ("".equals(stringBuffer.toString())) {
            return "0";
        }
        return stringBuffer.reverse().toString();
    }

    public static void main(String[] args) {
        String nums = "10";
        String solution = new RemoveKDigits().removeKdigits(nums,2);
        System.out.println("solution is " + solution);
    }
}
