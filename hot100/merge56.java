import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class merge56 {
    public int[][] merge(int[][] intervals) {
        // 排序：1. lambda 表达式，默认升序
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        // 排序：2. Comparator 表达式
        // Arrays.sort(intervals, new Comparator<int[]>() {
        //     @Override
        //     public int compare(int[] o1, int[] o2) {
        //         return o1[0]-o2[0];
        //     }
        // });
        List<int[]> merged = new ArrayList<>();

        merged.add(intervals[0]);
        int n = intervals.length;
        for(int i = 1; i < n; ++ i) {
            int[] nums = merged.get(merged.size()-1);
            // 合并区间
            if (intervals[i][0] <= nums[1]) {
                merged.remove(merged.size()-1);
                int right = Math.max(nums[1], intervals[i][1]);
                merged.add(new int[]{nums[0], right});
            }
            else {
                merged.add(intervals[i]);
            }
        }

        // way1
        
        // int[][] array = new int[merged.size()][];
        // for (int i = 0; i < merged.size(); i++) {
        //     array[i] = merged.get(i); // 将每个子数组复制到int[][]
        // }

        //way2
        // 将List<int[]>转换为int[][]
        int[][] array = merged.stream().toArray(int[][]::new);

        return array;


    }
}
