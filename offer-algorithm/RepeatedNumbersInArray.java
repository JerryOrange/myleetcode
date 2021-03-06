/**
 * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。 数组中某些数字是重复的，但不知道有几个数字是重复的。也不知道每个数字重复几次。
 * 请找出数组中任意一个重复的数字。 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。
 * <p>
 * Created by Jiacheng on 2018/6/20.
 */
public class RepeatedNumbersInArray {

    /**
     * 时间复杂度：O(N)
     * 空间复杂度：O(1)
     *
     * @param numbers
     * @param length
     * @param duplication
     * @return
     */
    public boolean duplicate(int numbers[], int length, int[] duplication) {
        if (numbers == null || length <= 1) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            while (numbers[i] != i) {
                if (numbers[numbers[i]] == numbers[i]) {
                    duplication[0] = numbers[i];
                    return true;
                }
                int temp = numbers[i];
                //注意，是temp
                numbers[i] = numbers[temp];
                numbers[temp] = temp;
            }
        }
        return false;
    }
}
