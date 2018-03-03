/**
 * 035. Search Insert Position
 * <p>
 * Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
 * You may assume no duplicates in the array.
 * <p>
 * Created by Jiacheng on 2018/3/3.
 */
public class SearchInsertPosition {

    public int searchInsert(int[] nums, int target) {
        int index = -1;
        if (target < nums[0]) {
            index = 0;
            return index;
        } else if (target > nums[nums.length - 1]) {
            index = nums.length;
            return index;
        } else if (target >= nums[0] && target <= nums[nums.length - 1]) {
            for (int i = 0; i < nums.length; i++) {
                if (target == nums[i]) {
                    index = i;
                    break;
                }
                if (target > nums[i] && target < nums[i + 1]) {
                    index = i + 1;
                    break;
                }
            }
        }
        return index;
    }

    public static void main(String[] args) {
        int[] nums = {1};
        int solution = new SearchInsertPosition().searchInsert(nums, 1);
        System.out.println("Solution is " + solution);
    }
}
