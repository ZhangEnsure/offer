
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class threeSum15 {
    // 返回三个数的和为0的所有组合
    // 值得多次训练写
    // 思路如下：1. 先对数组进行排序；2. 从左到右遍历数组，对于每一个数，从它的右边找两个数，使得三个数的和为0；3. 为了避免重复的组合，对于相同的数，直接跳过
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int i = 0;
        if(nums.length < 3) return res;
        Arrays.sort(nums);
        while(i < nums.length){
            // 如果当前数大于0，那么后面的数都大于0，不可能和为0
            if (nums[i] > 0) break;
            // 如果当前数和前一个数相同，那么会有重复的组合，直接跳过
            if (i>0 && nums[i]==nums[i-1])
            {
                i++;
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while(left < right){
                if(nums[i]+nums[left]+nums[right] < 0){
                    left++;
                    continue;
                }
                if(nums[i]+nums[left]+nums[right] > 0){
                    right--;
                    continue;
                }
                if(nums[i]+nums[left]+nums[right] == 0){
                    List<Integer> list = Arrays.asList(nums[i], nums[left], nums[right]);
                    res.add(list);
                
                    // 这里的逻辑是需要仔细研究的
                    while(left<right && nums[left]==nums[left+1])
                        left++;
                    left++;
                    while(left<right && nums[right]==nums[right-1])
                        right--;
                    
                    right--;
                }
            }
            i++;
        }
        return res;
    }

    public static void main(String[] args) {
        threeSum15 test = new threeSum15();
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> res = test.threeSum(nums);
        for (List<Integer> list : res) {
            for (Integer num : list) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
