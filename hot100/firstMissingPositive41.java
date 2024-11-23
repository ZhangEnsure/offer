public class firstMissingPositive41 {
    // 原地哈希方法，值得学习
    // value: nums[i] -> location: nums[i]-1
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for(int i = 0; i < n; ++i) {
            // while 特别注意！
            // 前两个条件限制了数组值的范畴
            // 最后一个条件是如果新换的位置上的元素值 == 待还的元素值，则不换
            while(nums[i] >= 1 && nums[i] <= n && nums[i] != i+1 && nums[nums[i]-1] != nums[i]) {
                // i位置交换到nums[i-1]的位置上
                swap(nums, i, nums[i]-1);
            }
        }
        for (int i = 0; i < n; ++i) {
            if (nums[i] != i + 1) {
                return i+1;
            }
        }
        return n+1;
    }

    public void swap(int[] nums, int l1, int l2) {
        int temp = nums[l1];
        nums[l1] = nums[l2];
        nums[l2] = temp;
    }
}
