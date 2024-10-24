public class trap42 {
    public int trap(int[] height) {
        // 思路对，但超时
        // 思路是：按层计算
        int maxHeight = height[0];
        for(int i = 1; i < height.length; i++){
            if(height[i] > maxHeight){
                maxHeight = height[i];
            }
        }
        int res = 0;
        for(int i = 1;i<=maxHeight;i++){
            int left = 0;
            // 必须先找到一个可以依靠的左墙
            while(left < height.length && height[left] < i){
                left++;
            }//while
            // 从左墙开始，找到右墙
            int right = left + 1;
            // 右墙有两种可能，一种是找到了一个比水柱高的右墙（不计数），另一种是没有找到比水柱高的右墙（计数）
            while(right<height.length){
                // 这里的 i 很关键
                // if(height[right]<i){
                //     right++;
                // }
                // else {
                //     res += right - left - 1;
                //     left = right;
                //     right++;
                // }
                if (height[right]>=i) {
                    res += right - left - 1;
                    left = right;
                }
                right++;
            }//while
        }//for
        return res;

    }

    public int trap2(int[] height) {
        // 思路对，但超时
        // 思路是：按列计算
        int[] dp_left = new int[height.length];
        int[] dp_right = new int[height.length];
        int i = 1;
        dp_left[0] = 0;
        dp_right[height.length-1] = 0;
        while(i < height.length) {
            dp_left[i] = Math.max(dp_left[i-1], height[i-1]);
            i+=1;
        }
        i = height.length-2;
        while(i >= 0) {
            dp_right[i] = Math.max(dp_right[i+1], height[i+1]);
            i-=1;
        }
        i = 0;
        int res = 0;
        while(i < height.length) {
            int minHeight = Math.min(dp_left[i], dp_right[i]);
            if (minHeight > height[i]) {
                res += minHeight - height[i];
            }
            i += 1;
        }
        return res;

    }
}