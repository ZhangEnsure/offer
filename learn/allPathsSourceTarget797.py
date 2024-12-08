from types import List
# 给定一个有 n 个结点的有向无环图，找到所有从 0 到 n-1 的路径并输出。

class Solution:
    def allPathsSourceTarget(self, graph: List[List[int]]) -> List[List[int]]:
        ans = list()
        stk = list()

        def dfs(x: int):
            # 递归退出条件：将当前节点加入路径
            if x == len(graph) - 1:
                ans.append(stk[:])
                return
            # 遍历当前节点的所有邻居节点
            for y in graph[x]:
                stk.append(y)
                dfs(y)
                stk.pop()

        stk.append(0)
        dfs(0)
        return ans
            