/**
 * 027. Remove Element
 * Given an array and a value, remove all instances of that value in-place and return the new length.
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 * The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 * <p>
 * Created by Jiacheng on 2018/3/3.
 */
public class RemoveElement {

    public int removeElement(int[] nums, int val) {
        int num = 0;
        for (int i = 0; i < nums.length; i++) {
            if (val != nums[i]) {
                nums[num] = nums[i];
                num++;
            }
        }
        return num;
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 7, 11, 15, 22, 22};
        int solution = new RemoveElement().removeElement(nums, 7);
        System.out.println("solution is " + solution);
    }
}
