
public class rob198 {
    public int solution(int[] nums) {
        if (nums.length <= 2) {
            int res = nums[0];
            for(int i = 1; i < nums.length; ++i) {
                if(nums[i] > res) {
                    res = nums[i];
                }
            }
            return res;
        }
        // 子问题定义：以前 k 个屋子可偷的最大值
        // f(k) = 偷 [0..k) 房间中的最大金额，这里是因为有效下标不是从0开始，从1开始
        // 状态转移方程：f(i) = Math.max(f(i-1), f(i-2)+nums[i])
        int[] dp = new int[nums.length+1];
        dp[0] = 0;
        dp[1] = nums[0];
        
        for(int i = 2 ; i <= nums.length; ++i){
            dp[i] = Math.max(dp[i-1], dp[i-2]+nums[i-1]);
        }
        return dp[nums.length];
    }

    public int solution2(int[] nums) {
        // 很基础的一道动态规划
        int n = nums.length;
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = nums[0];
        for(int i = 2;i <=n ;++i) {
            dp[i] = Math.max(dp[i-1], dp[i-2]+nums[i-1]);
        }
        return dp[n+1];
    }
}
