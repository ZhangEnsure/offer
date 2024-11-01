public class rotate189 {
    // 轮转数字：翻三次即可
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        rotatePart(nums, 0, nums.length-1);
        rotatePart(nums, 0, nums.length-k-1);
        rotatePart(nums, nums.length-k, nums.length-1);
    }

    public void rotatePart(int[] nums, int left, int right) {
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;  
        }
    }
}