import java.util.LinkedList;
import java.util.List;

/**
 * 判断数组中有多少个连续的数字（CVTE 2018春招笔试记录）
 * <p>
 * Created by Jiacheng on 2018/3/15.
 */
public class ConsecutiveNumbers {

    public static void main(String[] args) throws Exception {
        int[] ns = {1, 2, 3, 5, 6, 8, 9, 10, 11, 11, 12, 13, 14, 15, 20};
        List<Integer> c = new LinkedList<>(); // 连续的子数组
        c.add(ns[0]);
        for (int i = 0; i < ns.length - 1; ++i) {
            if (ns[i] + 1 == ns[i + 1]) {
                c.add(ns[i + 1]);
            } else {
                if (c.size() > 1) {
                    System.out.println(c);
                }
                c.clear();
                c.add(ns[i + 1]);
            }
        }
        if (c.size() > 1) {
            System.out.println(c);
        }
    }
}
