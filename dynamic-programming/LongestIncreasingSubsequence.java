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

    public static void main(String[] args) {
        int[] A = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int solution = new LongestIncreasingSubsequence().lengthOfLIS(A);
        System.out.println("The longest increasing subsequence is " + solution);
    }
}
