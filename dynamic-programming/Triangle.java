import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 120. Triangle
 * Given a triangle, find the minimum path sum from top to bottom.
 * Each step you may move to adjacent numbers on the row below.
 * <p>
 * Created by Jiacheng on 2018/6/11.
 */
public class Triangle {

    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.size() == 0) {
            return 0;
        }
        int[] A = new int[triangle.size() + 1];
        //路径方向选择 从下至上
        for (int i = triangle.size() - 1; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                A[j] = Math.min(A[j], A[j + 1]) + triangle.get(i).get(j);
            }
        }
        //返回三角形顶端
        return A[0];
    }

    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList();
        List list0 = Arrays.asList(2);
        List list1 = Arrays.asList(4,3);
        List list2 = Arrays.asList(7,6,5);
        List list3 = Arrays.asList(4,3,2,1);
        triangle.add(list0);
        triangle.add(list1);
        triangle.add(list2);
        triangle.add(list3);
        int solution = new Triangle().minimumTotal(triangle);
        System.out.println("The minimum path sum from top to bottom is " + solution);
    }
}
