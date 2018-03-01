/**
 * 001.Two Sum
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * <p>
 * Created by Jiacheng on 2018/3/1.
 */
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        int[] solution = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (target - nums[i] == nums[j]) {
                    solution[0] = i;
                    solution[1] = j;
                    return solution;
                }
            }
        }
        return solution;
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15, 22};
        int[] solutions = new TwoSum().twoSum(nums, 26);
        System.out.println(solutions[0] + "," + solutions[1]);
    }
}
