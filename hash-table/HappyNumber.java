import java.util.HashSet;

/**
 * 202. Happy Number
 * <p>
 * Write an algorithm to determine if a number is "happy".
 * A happy number is a number defined by the following process:
 * Starting with any positive integer, replace the number by the sum of the squares of its digits,
 * and repeat the process until the number equals 1 (where it will stay),
 * or it loops endlessly in a cycle which does not include
 * 1. Those numbers for which this process ends in 1 are happy numbers.
 * Example: 19 is a happy number
 * <p>
 * Created by Jiacheng on 2018/3/13.
 */
public class HappyNumber {

    public boolean isHappy(int n) {
        HashSet set = new HashSet();
        int remain, sum;
        while (set.add(n)) {
            sum = 0;
            while (n > 0) {
                remain = n % 10;
                sum += remain * remain;
                n /= 10;
            }
            if (sum == 1) {
                return true;
            }
            n = sum;
        }
        return false;
    }

    public static void main(String[] args) {
        int num = 19;
        boolean solution = new HappyNumber().isHappy(num);
        System.out.println("Solution is " + solution);
    }
}