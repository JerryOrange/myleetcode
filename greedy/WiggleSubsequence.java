/**
 * 376. Wiggle Subsequence
 * <p>
 * A sequence of numbers is called a wiggle sequence if the differences between successive numbers strictly alternate between positive and negative.
 * The first difference (if one exists) may be either positive or negative.
 * A sequence with fewer than two elements is trivially a wiggle sequence.
 * <p>
 * For example, [1,7,4,9,2,5] is a wiggle sequence because the differences (6,-3,5,-7,3) are alternately positive and negative.
 * In contrast, [1,4,7,2,5] and [1,7,4,5,5] are not wiggle sequences, the first because its first two differences are positive,
 * and the second because its last difference is zero.
 * <p>
 * Given a sequence of integers, return the length of the longest subsequence that is a wiggle sequence.
 * A subsequence is obtained by deleting some number of elements (eventually, also zero) from the original sequence,
 * leaving the remaining elements in their original order.
 * <p>
 * Created by Jiacheng on 2018/3/26.
 */
public class WiggleSubsequence {

    //状态机
    final static String BEGIN = "BEGIN";
    final static String UP = "UP";
    final static String DOWN = "DOWN";
    static String STATE = BEGIN;
    int max_length = 1;

    public int wiggleMaxLength(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }
        for (int i = 1; i < nums.length; i++) {
            switch (STATE) {
                case BEGIN:
                    if (nums[i - 1] < nums[i]) {
                        STATE = UP;
                        max_length++;
                    } else if (nums[i - 1] > nums[i]) {
                        STATE = DOWN;
                        max_length++;
                    }
                    break;
                case UP:
                    if (nums[i - 1] > nums[i]) {
                        STATE = DOWN;
                        max_length++;
                    }
                    break;
                case DOWN:
                    if (nums[i - 1] < nums[i]) {
                        STATE = UP;
                        max_length++;
                    }
                    break;
            }
        }
        return max_length;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 7, 4, 9, 2, 5};
        int solution = new WiggleSubsequence().wiggleMaxLength(nums);
        System.out.println("solution is " + solution);
    }
}
