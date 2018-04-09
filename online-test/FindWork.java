import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 2018网易互联网春招
 * 牛牛找工作
 * 时间限制：2秒,空间限制：65536K
 *
 * 为了找到自己满意的工作，牛牛收集了每种工作的难度和报酬。
 * 牛牛选工作的标准是在难度不超过自身能力值的情况下，牛牛选择报酬最高的工作。
 * 在牛牛选定了自己的工作后，牛牛的小伙伴们来找牛牛帮忙选工作，牛牛依然使用自己的标准来帮助小伙伴们。
 * 牛牛的小伙伴太多了，于是他只好把这个任务交给了你。
 *
 * 输入描述:每个输入包含一个测试用例。每个测试用例的第一行包含两个正整数，分别表示工作的数量N(N<=100000)和小伙伴的数量M(M<=100000)。
 * 接下来的N行每行包含两个正整数，分别表示该项工作的难度Di(Di<=1000000000)和报酬Pi(Pi<=1000000000)。
 * 接下来的一行包含M个正整数，分别表示M个小伙伴的能力值Ai(Ai<=1000000000)。保证不存在两项工作的报酬相同。
 *
 * 输出描述:对于每个小伙伴，在单独的一行输出一个正整数表示他能得到的最高报酬。一个工作可以被多个人选择。
 *
 * Created by Jiacheng on 2018/4/9.
 */
public class FindWork {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        //保存所有工作的键值对，即<工作能力，报酬>，而且也保存每个小伙伴的能力值键值对，其报酬为0
        Map<Integer, Integer> map = new HashMap<>();
        //保存所有工作的能力值以及要计算的每个小伙伴的能力值
        int[] ai = new int[m + n];
        for (int i = 0; i < n; i++) {
            int di = sc.nextInt();
            ai[i] = di;
            int pi = sc.nextInt();
            map.put(di, pi);
        }
        //保存要计算的每个小伙伴的能力值
        int[] bi = new int[m];
        for (int i = 0; i < m; i++) {
            ai[i + n] = sc.nextInt();
            bi[i] = ai[i + n];
            if (!map.containsKey(ai[i + n])) {
                map.put(ai[i + n], 0);
            }
        }
        //对能力值进行排序
        Arrays.sort(ai);
        //保存到目前的能力值为止，所能获得的最大报酬，dynamic programming
        int max = 0;
        for (int i = 0; i < m + n; i++) {
            //每次都更新当前能力值所对应的最大报酬，由于max是保存的<=当前能力值所能获得的最大报酬，所以可行
            max = Math.max(max, map.get(ai[i]));
            map.put(ai[i], max);
        }
        //遍历每个小伙伴的能力值，从map中获取到其最大报酬（在上面的for循环中已经更新到了）
        for (int i = 0; i < m; i++) {
            System.out.println(map.get(bi[i]));
        }
    }
}

