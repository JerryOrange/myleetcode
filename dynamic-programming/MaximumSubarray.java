/**
 * 053. Maximum Subarray
 * <p>
 * Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
 * <p>
 * Created by Jiacheng on 2018/3/27.
 */
public class MaximumSubarray {

    public static int maxSubArray(int[] A) {
        int maxSum = A[0];
        int curMaxSum = A[0];
        for (int i = 1; i < A.length; ++i) {
            curMaxSum = Math.max(curMaxSum + A[i], A[i]);
            maxSum = Math.max(curMaxSum, maxSum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] A = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int solution = new MaximumSubarray().maxSubArray(A);
        System.out.println(solution);
    }
}
