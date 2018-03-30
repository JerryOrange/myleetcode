import java.util.Scanner;

/**
 * 055. Jump Game
 * <p>
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * Each element in the array represents your maximum jump length at that position.
 * Determine if you are able to reach the last index.
 * <p>
 * Created by Jiacheng on 2018/3/30.
 */
public class JumpGame {

    public boolean canJump(int[] nums) {
        //最远可跳至的位置
        int[] index = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            //计算index数组
            index[i] = nums[i] + i;
        }
        //初始化jump、max_index
        int jump = 0;
        int max_index = index[0];
        while (jump < index.length && jump <= max_index) {
            if (max_index < index[jump]) {
                max_index = index[jump];
            }
            jump++;
        }
        //若jump到达数组尾，则返回true
        return jump == index.length;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String num = sc.nextLine();
        String nums = num.trim().replace(" ", "");
        int[] index = new int[nums.length()];
        for (int i = 0; i < index.length; i++) {
            index[i] = nums.charAt(i) - '0';
        }
        boolean solution = new JumpGame().canJump(index);
        System.out.println("solution is " + solution);
    }
}
