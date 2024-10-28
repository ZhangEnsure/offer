public class maxSubArray53 {
    public int maxSubArray(int[] nums) {

        // 采用动态规划的思想
        // 1. 问题定义：求一个数组的连续子数组，使数组和最大
        // 2. 状态转移方程：dp[i] = Math.max(dp[i-1]+nums[i], nums[i]);
        // 3. 初始化：dp[0] = nums[0]; 

        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        int ans = dp[0];
        for(int i = 1; i < n;++i) {
            dp[i] = Math.max(dp[i-1]+nums[i], nums[i]);
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        maxSubArray53 solution = new maxSubArray53();
        int[] nums = {5,4,-1,7,8};
        System.out.println(solution.maxSubArray(nums));
    }
}
