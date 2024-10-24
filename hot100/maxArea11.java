public class maxArea11 {
    public int maxArea(int[] height) {
        // 双指针法
        // 计算最大面积，类似接雨水
        // 思路是动态规划，但是超时了,时间复杂度是O(n^2)
        int []dp = new int[height.length];
        dp[0] = 0;
        int i = 1, j;
        while(i<height.length) {
            j = i-1;
            dp[i] = dp[i-1];
            while(j>= 0){
                dp[i] = Math.max(dp[i], (i-j)*Math.min(height[i], height[j]));
                j-=1;
            }
            i += 1;
        }
        return dp[height.length-1];
    }

    public int maxArea2(int[] height) {
        // 双指针法
        // 计算最大面积，类似接雨水
        // 思路2：双指针法，从两边向中间移动，每次移动高度较小的一边，时间复杂度是O(n)
        int front = 0;
        int rear = height.length - 1;
        int maxArea = 0;
        while(rear > front) {
            maxArea = Math.max(maxArea, (rear - front) * Math.min(height[front], height[rear]));
            if(height[front] < height[rear]){
                front += 1;
            }
            else{
                rear -= 1;
            }
        }
        return maxArea;
    }
}
