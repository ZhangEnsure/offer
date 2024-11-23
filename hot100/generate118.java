import java.util.ArrayList;
import java.util.List;

public class generate118 {
    public List<List<Integer>> solution(int numRows) {
        // 使用动态规划
        List<List<Integer>> res = new ArrayList<>();
        for(int row = 0;row < numRows; ++row) {
            List<Integer> item = new ArrayList<>();
            for(int col = 0; col <= row; ++col) {
                if (col == 0 || col == row) {
                    item.add(1);
                }
                else {
                    item.add(res.get(row-1).get(col-1)+res.get(row-1).get(col));
                }
            }
            res.add(item);
        }
        return res;
    }
}
