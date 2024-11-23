public class productExceptSelf238 {
    // 前缀积从前往后计算
    // 后缀积从后往前计算
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] pre = new int[n];
        int[] last = new int[n];
        pre[0] = 1;
        last[n-1] = 1;
        // 从前往后计算 pre 前缀积
        for(int i = 1; i < n;++i) {
            pre[i] = nums[i-1]* pre[i-1];
        }

        // 从后往前计算 last 后缀积
        for(int i = n-2; i >= 0;--i) {
            last[i] = last[i+1]*nums[i+1];
        }

        int[] ans = new int[n];
        for(int i = 0; i < n; ++i) {
            ans[i] = pre[i]*last[i];
        }
        return ans;
    }
}
