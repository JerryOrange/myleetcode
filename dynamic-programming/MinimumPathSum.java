import java.util.Scanner;

/**
 * 64. Minimum Path Sum
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.
 * Note: You can only move either down or right at any point in time.
 * <p>
 * Created by Jiacheng on 2018/6/13.
 */
public class MinimumPathSum {

    public int minPathSum(int[][] grid) {
        if (grid.length == 0) {
            return 0;
        }
        int row = grid.length;
        int colume = grid[0].length;
        int[][] dp = new int[row][colume];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < colume; i++) {
            dp[0][i] = grid[0][i] + dp[0][i - 1];
        }
        for (int j = 1; j < row; j++) {
            dp[j][0] = grid[j][0] + dp[j - 1][0];
            for (int k = 1; k < colume; k++) {
                dp[j][k] = grid[j][k] + Math.min(dp[j - 1][k], dp[j][k - 1]);
            }
        }
        return dp[row-1][colume-1];
    }

    public static void main(String[] args) {
        int m, n;
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        n = sc.nextInt();
        int[][] grid = new int[m][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        int solution = new MinimumPathSum().minPathSum(grid);
        System.out.println("solution is " + solution);
    }
}
