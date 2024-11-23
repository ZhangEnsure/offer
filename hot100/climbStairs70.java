public class climbStairs70 {
    public int solution(int n) {
        // if (n == 1) {
        //     return 1;
        // }
        // if (n == 2) {
        //     return 2;
        // }
        // q, k, v
        int q ,k ,v;
        v = 0;
        // 0 -> 0
        q = 0;
        // 0 -> 1
        k = 1;
        for(int i = 0; i < n; ++i) {
            v = q + k;
            q = k;
            k = v;
        }
        return v;
    }
}
