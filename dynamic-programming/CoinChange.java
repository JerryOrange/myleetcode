/**
 * 322. Coin Change
 * You are given coins of different denominations and a total amount of money amount.
 * Write a function to compute the fewest number of coins that you need to make up that amount.
 * If that amount of money cannot be made up by any combination of the coins, return -1.
 * <p>
 * Created by Jiacheng on 2018/6/8.
 */
public class CoinChange {

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        //初始化dp，所有金额的最优解为-1（不可达到）
        for (int i = 0; i <= amount; i++) {
            dp[i] = -1;
        }
        dp[0] = 0;
        //循环金额
        for (int i = 1; i <= amount; i++) {
            //循环各个面值，找到dp[i]最优解
            for (int j = 0; j < coins.length; j++) {
                if (i - coins[j] >= 0 && dp[i - coins[j]] != -1) {
                    if (dp[i] == -1 || dp[i] > dp[i - coins[j]] + 1) {
                        dp[i] = dp[i - coins[j]] + 1;
                    }
                }
            }
        }
        return dp[amount];
    }

    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 11;
        int solution = new CoinChange().coinChange(coins, amount);
        System.out.println("solution is " + solution);
    }
}
