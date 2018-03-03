import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/**
 * 136. Single Number
 * <p>
 * Given an array of integers, every element appears twice except for one. Find that single one.
 * Note: Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 * <p>
 * Created by Jiacheng on 2018/3/3.
 */
public class SingleNumber {

    /**
     * use HashMap
     *
     * @param nums
     * @return
     */
    public int singleNumber1(int[] nums) {
        int singleNum = 0;
        HashMap hashMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (hashMap.get(nums[i]) != null) {
                hashMap.remove(nums[i]);
            } else {
                hashMap.put(nums[i], nums[i]);
            }
        }
        Set<Integer> keySet = hashMap.keySet();
        for (Iterator<Integer> iterator = keySet.iterator(); iterator.hasNext(); ) {
            singleNum = iterator.next();
        }
        return singleNum;
    }

    /**
     * use exclusive OR
     *
     * @param nums
     * @return
     */
    public int singleNumber2(int[] nums) {
        int singleNum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            singleNum = singleNum ^ nums[i];
        }
        return singleNum;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 3, 3};
        int solution1 = new SingleNumber().singleNumber1(nums);
        int solution2 = new SingleNumber().singleNumber2(nums);
        System.out.println("Solution1 is " + solution1);
        System.out.println("Solution2 is " + solution2);
    }
}
