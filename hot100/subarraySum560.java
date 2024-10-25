import java.util.HashMap;

public class subarraySum560 {
    // 前缀和计算
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> hashmap = new HashMap<>();
        int curSum = 0;
        int count = 0;
        for(int i = 0;i < nums.length; ++i) {
            curSum += nums[i];
            // 存储前缀和
            hashmap.put(curSum, hashmap.getOrDefault(curSum, 0)+1);
            if (curSum == k) {
                count++;
            }
            if(hashmap.containsKey(curSum-k)) {
                count += hashmap.get(curSum-k);
            }
        }
        return count;
    }

    // 枚举方法计算
    public int subarraySum2(int[] nums, int k) {
        int count = 0;
        // 从前到后，从后到前，均可
        for(int end = 0; end < nums.length; ++end) {
            int sum = 0;
            // 充分利用之前计算的和，以end为终点，前向计算
            for(int begin = end; begin >= 0 ; begin--) {
                sum += nums[begin];
                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        subarraySum560 solution = new subarraySum560();
        int[] nums = {1,1,1};
        int k = 2;
        System.out.println(solution.subarraySum(nums, k));
    }
}
