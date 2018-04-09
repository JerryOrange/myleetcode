import java.util.Scanner;

/**
 * 2018网易互联网春招
 *
 * 牛牛以前在老师那里得到了一个正整数数对(x, y), 牛牛忘记他们具体是多少了。
 * 但是牛牛记得老师告诉过他x和y均不大于n, 并且x除以y的余数大于等于k。
 * 牛牛希望你能帮他计算一共有多少个可能的数对。
 *
 * Created by Jiacheng on 2018/4/9.
 */
public class NK_problem {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        long count = 0L;
        if (k == 0) {
            count = (long) n * n;
            System.out.println(count);
        } else {
            for (int y = k + 1; y <= n; y++) {
                count += (long) (n / y) * (y - k);
                if (n % y >= k) {
                    count += (long) n % y - k + 1;
                }
            }
            System.out.println(count);
        }
    }
}
