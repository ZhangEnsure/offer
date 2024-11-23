
import java.util.Arrays;

public class coinChange322 {
    public int coinChange(int[] coins, int amount) {
        // 动态规划：定义dp[i]为总价格为i的时候所需要的硬币数量
        int length = coins.length;
        int[] dp = new int[amount+1];
        Arrays.fill(dp, amount+1);
        // 初始状态
        dp[0] = 0;
        for(int i = 1; i < dp.length; ++i) {
            for(int j = 0;j < length;++j) {
                if(i >= coins[j]) {
                    dp[i] = Math.min(dp[i-coins[j]]+1, dp[i]);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
