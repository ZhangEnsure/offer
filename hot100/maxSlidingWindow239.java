import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Deque;

public class maxSlidingWindow239 {
    // 1. 需要学习一个优先队列的初始化方法
    // 2. 优先队列排序方法也是重点
    public int[] maxSlidingWindow(int[] nums, int k) {
        // 滑动窗口的最大值
        // 这里使用堆排序，优先队列 priorityQueue, [nums, index]
        PriorityQueue<int[]> queue = new PriorityQueue<int[]>(new Comparator<int[]>() {
            @Override
            public int compare(int[] pair1, int[] pair2) {
                // o1 - o2：升序
                return pair1[0] == pair2[0] ? pair2[1] - pair1[1] : pair2[0]-pair1[0];
            }
        });

        int n = nums.length;
        int[] ans = new int[n-k+1];

        // 初始化一个优先队列

        for(int i = 0;i < k;++i) {
            queue.offer(new int[]{nums[i], i});
        }
        ans[0] = queue.peek()[0];

        // 循环处理后续队列元素
        for(int i = k;i < n;++i) {
            // 新元素加入优先队列
            queue.offer(new int[]{nums[i], i});
            // 循环处理优先队列，移出堆顶的错误数字
            while(queue.peek()[1] <= i-k) {
                queue.poll();
            }
            // 获得答案
            ans[i-k+1] = queue.peek()[0];
        }

        // 返回答案
        return ans;
    }

    // 双端队列改造而成的单调队列
    public int[] maxSlidingWindow2(int[] nums, int k) {
        // 单调队列法：队列存放的是窗口中元素值递减顺序对应的下标
        Deque<Integer> deque = new LinkedList<>();

        int n = nums.length;
        int[] ans = new int[n-k+1];
        // 单调队列初始化
        for(int i = 0;i < k;++i) {
            // 移出不符合规则的数据
            while(!deque.isEmpty() && nums[deque.peekLast()]<nums[i]){
                deque.pollLast();
            }
            // 添加元素
            deque.offerLast(i);
        }
        ans[0] = nums[deque.peekFirst()];
        // 循环遍历后续元素
        for(int i = k;i < n;++i) {
            // 移出不符合规则的数据
            while(!deque.isEmpty() && nums[deque.peekLast()]<nums[i]){
                deque.pollLast();
            }
            // 添加元素
            deque.offerLast(i);
            // 移出窗口外的元素
            while(deque.peekFirst() <= i-k) {
                deque.pollFirst();
            }
            ans[i-k+1] = nums[deque.peekFirst()];
        }

        // 返回答案
        return ans;
    }
}
