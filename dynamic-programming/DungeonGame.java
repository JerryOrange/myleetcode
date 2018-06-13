import java.util.Scanner;

/**
 * 174. Dungeon Game (Hard)
 * Write a function to determine the knight's minimum initial health so that he is able to rescue the princess.
 * <p>
 * Created by Jiacheng on 2018/6/13.
 */
public class DungeonGame {

    public int calculateMinimumHP(int[][] dungeon) {
        if (dungeon.length == 0) {
            return 0;
        }
        int row = dungeon.length;
        int colume = dungeon[0].length;
        int[][] dp = new int[row][colume];
        dp[row - 1][colume - 1] = Math.max(1, 1 - dungeon[row - 1][colume - 1]);
        //路径方向选择从右下角至左上角
        for (int i = colume - 2; i >= 0; i--) {
            dp[row - 1][i] = Math.max(1, dp[row - 1][i + 1] - dungeon[row - 1][i]);
        }
        for (int i = row - 2; i >= 0; i--) {
            dp[i][colume - 1] = Math.max(1, dp[i + 1][colume - 1] - dungeon[i][colume - 1]);
        }
        for (int i = row - 2; i >= 0; i--) {
            for (int j = colume - 2; j >= 0; j--) {
                int dp_min = Math.min(dp[i + 1][j], dp[i][j + 1]);
                dp[i][j] = Math.max(1, dp_min - dungeon[i][j]);
            }
        }
        return dp[0][0];
    }


    public static void main(String[] args) {
        int m, n;
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        n = sc.nextInt();
        int[][] dungeon = new int[m][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dungeon[i][j] = sc.nextInt();
            }
        }
        int solution = new DungeonGame().calculateMinimumHP(dungeon);
        System.out.println("solution is " + solution);
    }
}