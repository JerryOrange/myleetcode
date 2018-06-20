/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，所有的偶数位于位于数组的后半部分
 * 并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 * <p>
 * Created by Jiacheng on 2018/6/20.
 */
public class PositionOfOddAndEvenNumber {

    /**
     * 变形版冒泡
     *
     * @param array
     */
    public void reOrderArray(int[] array) {
        if (array == null || array.length < 2) {
            return;
        }
        //flag用于标记当前一遍循环是否发生了交换，若没有，说明数组已经调整好顺序，返回即可
        boolean flag = true;
        for (int i = 0; i < array.length - 1 && flag; i++) {
            //初始化flag
            flag = false;
            for (int j = array.length - 1; j > i; j--) {
                //若是后面array[j] 为偶数，前面array[j - 1]为奇数，则交换两者
                if ((array[j] & 1) == 1 && (array[j - 1] & 1) == 0) {
                    array[j] = array[j] ^ array[j - 1];
                    array[j - 1] = array[j] ^ array[j - 1];
                    array[j] = array[j] ^ array[j - 1];
                    //flag置true说明当前循环发生了交换
                    flag = true;
                }
            }
        }
        return;
    }

    /**
     * 变形版插入排序
     *
     * @param array
     */
    public void reOrderArrayByInsertSort(int [] array) {
        if (array == null || array.length < 2) {
            return;
        }
        for (int i = 1; i < array.length; i++) {
            int temp = array[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if((temp & 1) == 1 && (array[j] & 1) == 0) {
                    //采用移动而不是交换的方式
                    array[j + 1] = array[j];
                }else{
                    break;
                }
            }
            //填入最终的空位
            array[j + 1] = temp;
        }
        return;
    }
}
