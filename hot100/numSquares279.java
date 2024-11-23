
import java.util.Arrays;

public class numSquares279 {
    public int solution(int n) {
        // 完全平方数，很厉害的一道动态规划的题目
        // 子问题定义：f(i): 总数为i的时候的凑硬币的个数
        int length = n;
        int[] dp = new int[length+1];
        Arrays.fill(dp, n+1);
        dp[0] = 0;
        // 找到平方数
        for(int i = 1;i*i <= n; ++i) {
            // 在这个平方数 i*i 的帮助下可以减少多少 f(i*i) ... f(n) 的计算
            for(int j = i*i; j <= n; ++j) {
                dp[j] = Math.min(dp[j], dp[j-i*i]+1);
            }
        }
        return dp[n];
    }
}
