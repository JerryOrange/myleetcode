import java.util.Scanner;

/**
 * 45. Jump Game II (hard)
 * <p>
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * Each element in the array represents your maximum jump length at that position.
 * Your goal is to reach the last index in the minimum number of jumps.
 * <p>
 * Created by Jiacheng on 2018/3/30.
 */
public class JumpGameII {

    public int jump(int[] nums) {
        //长度小于2则不用跳跃
        if (nums.length < 2) {
            return 0;
        }
        //当前可到达的最远位置
        int current_max_index = nums[0];
        //遍历各个位置过程中，可达到的最远位置
        int pre_current_max_index = nums[0];
        //最小跳跃次数
        int jump_min = 1;
        for (int i = 1; i < nums.length; i++) {
            //若无法再向前移动了，才进行跳跃
            if (i > current_max_index) {
                //更新当前可达到的最远位置
                jump_min++;
                current_max_index = pre_current_max_index;
            }
            if (pre_current_max_index < nums[i] + i) {
                //更新pre_current_max_index
                pre_current_max_index = nums[i] + i;
            }
        }
        return jump_min;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String num = sc.nextLine();
        String nums = num.trim().replace(" ", "");
        int[] index = new int[nums.length()];
        for (int i = 0; i < index.length; i++) {
            index[i] = nums.charAt(i) - '0';
        }
        int solution = new JumpGameII().jump(index);
        System.out.println("solution is " + solution);
    }
}
