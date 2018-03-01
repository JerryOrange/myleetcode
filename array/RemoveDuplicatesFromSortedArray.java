/**
 * 026. Remove Duplicates from Sorted Array
 * Given a sorted array, remove the duplicates in-place such that each element appear only once and return the new length.
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 *
 * Created by Jiacheng on 2018/3/1.
 */
public class RemoveDuplicatesFromSortedArray {

    public int removeDuplicates(int[] nums) {
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[i] != nums[j]) {
                i++;
                if (i != j) {
                    nums[i] = nums[j];
                }
            }
        }
        return i + 1;
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 7, 11, 15, 22, 22};
        int solution = new RemoveDuplicatesFromSortedArray().removeDuplicates(nums);
        System.out.println("solution is " + solution);
    }
}
