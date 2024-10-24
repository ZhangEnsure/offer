class moveZeroes283 {
    public void moveZeroes(int[] nums) {
        // 双指阵法：交换值的思路
        int i = 0, j = 0;
        while(i < nums.length){
            if(nums[i] != 0){
                i += 1;
            }
            else{
                j = i + 1;
                while(j < nums.length && nums[j] == 0){
                    j += 1;
                }
                if(j < nums.length){
                    nums[i] = nums[j];
                    nums[j] = 0;
                    i += 1;
                }
                else{
                    break;
                }
            }
        }
    }

    public void moveZeroes2(int[] nums) {
        // 双指阵法：赋值的思路
        int i = 0, j = 0;
        while(j<nums.length){
            if(nums[j] != 0){
                nums[i] = nums[j];
                i += 1;
            }
            j += 1;
        }
        while(i<nums.length){
            nums[i] = 0;
            i += 1;
        }
    }
}