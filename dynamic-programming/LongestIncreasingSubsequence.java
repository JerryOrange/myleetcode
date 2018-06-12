import java.util.Stack;

/**
 * 300. Longest Increasing Subsequence
 * Given an unsorted array of integers, find the length of longest increasing subsequence.
 * <p>
 * Created by Jiacheng on 2018/6/12.
 */
public class LongestIncreasingSubsequence {

    /**
     * O(n^2) complexity
     *
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int LIS = 1;
        for (int i = 1; i < dp.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                }
            }
            if (LIS < dp[i]) {
                LIS = dp[i];
            }
        }
        return LIS;
    }

    /**
     * O(nlogn) time complexity
     *
     * @param nums
     * @return
     */
    public int lengthOfLis(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            //大于栈顶元素时，num直接入栈
            if (nums[i] > stack.peek()) {
                stack.push(nums[i]);
            } else {
                //小于时，栈底遍历到栈顶
                for (int j = 0; j < stack.size(); j++) {
                    //若栈中元素大于等于num，则替换该元素，并跳出循环
                    if (nums[i] <= stack.get(j)) {
                        stack.set(j, nums[i]);
                        break;
                    }
                }
            }
        }
        return stack.size();
    }

    public static void main(String[] args) {
        int[] A = {4, 10, 4, 3, 8, 9};
        int solution = new LongestIncreasingSubsequence().lengthOfLIS(A);
        int solution1 = new LongestIncreasingSubsequence().lengthOfLis(A);
        System.out.println("The longest increasing subsequence is " + solution + " / " + solution1);
    }
}
