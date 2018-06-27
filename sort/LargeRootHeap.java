/**
 * 大根堆排序
 * <p>
 * 实现堆排序的算法思路是先创建堆，也就是从叶子节点起对每一层的孩子节点及其对应位置的父亲节点进行比较，较大的孩子节点替换较小的父亲节点，
 * 一级一级比较替换，就创建出了大根堆，小根堆反之。
 * 创建好大根堆以后，我们，将整棵树的根节点与最后最后一个节点替换位置，然后去除最后一个节点，
 * 在创建一个新的大根堆，以此类推，完成排序。
 * <p>
 * Created by Jiacheng on 2018/6/26.
 */
public class LargeRootHeap {

    public int[] heapSort(int[] arr) {
        //初始化大根堆
        arr = creatHeap(arr, arr.length - 1);
        //每次替换大根到对应最后位置，有后往前排序
        for (int i = arr.length - 1; i > 0; i--) {
            int temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;
            //对去除根的数组再次排序为大根堆
            creatHeap(arr, i - 1);
        }
        return arr;
    }

    public int[] creatHeap(int[] arr, int length) {
        System.out.println("建立大根堆:");
        for (int i = length; i > 0; i--) {
            int root = i;
            int j = (root - 1) / 2;
            //叶子节点和上一层的根比较
            while (root > 0) {
                if (arr[root] > arr[j]) {
                    int temp = arr[j];
                    arr[j] = arr[root];
                    arr[root] = temp;
                }
                //改变位置，比较上一层与其父层节点
                root = j;
                j = (root - 1) / 2;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print("  arr[" + i + "]=" + arr[i]);
        }
        System.out.println("");
        return arr;
    }
}
