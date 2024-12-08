# 定义图的数据结构
graph = {}  # 存储头文件及其依赖关系的有向图
visited = {}  # 节点访问状态，0: 未访问, 1: 访问中, 2: 已访问
cycle_nodes = set()  # 用于存储循环依赖中所有的节点
has_cycle = False  # 是否存在循环依赖的标记
path = []  # 当前DFS的访问路径

def dfs(node):
    """
    深度优先搜索函数，用于检测图中的循环依赖
    :param node: 当前访问的节点
    """
    global has_cycle
    if has_cycle:  # 如果已经检测到循环依赖，提前返回
        return
    
    visited[node] = 1  # 标记当前节点为访问中
    path.append(node)  # 将当前节点加入访问路径

    # 遍历当前节点的邻居节点
    for neighbor in graph.get(node, []):
        if visited.get(neighbor, 0) == 0:  # 如果邻居节点未访问
            dfs(neighbor)  # 递归访问邻居节点
            if has_cycle:  # 如果检测到循环，立即返回
                return
        elif visited.get(neighbor, 0) == 1:  # 如果邻居节点正在访问中，说明发现循环
            has_cycle = True  # 标记存在循环
            try:
                # 从当前路径中找到循环起点到当前节点的路径
                idx = path.index(neighbor)
                cycle_nodes.update(path[idx:])  # 将环中的节点添加到cycle_nodes中
            except ValueError:
                # 理论上不会发生，因为neighbor一定在path中
                pass
            return

    # 当前节点的所有邻居都处理完，回溯
    path.pop()  # 从路径中移除当前节点
    visited[node] = 2  # 标记当前节点为已访问

def main():
    """
    主函数，用于读取输入、构建图结构并检测循环依赖
    """
    import sys  # 引入sys模块用于处理输入输出
    global has_cycle, cycle_nodes, graph, visited, path  # 声明全局变量

    try:
        # 读取头文件的数量
        n = int(input())
    except:
        # 如果输入格式不正确，输出-1
        print(-1)
        return

    # 构建图结构
    for _ in range(n):
        try:
            line = input().strip()  # 读取每一行输入
        except EOFError:
            break
        if not line:  # 如果行为空，跳过
            continue
        parts = line.split()  # 拆分输入行，获取头文件和其依赖
        file = parts[0]  # 当前头文件
        includes = parts[1:]  # 当前头文件的依赖
        graph[file] = includes  # 将依赖关系加入图结构

    # 遍历图中所有节点，检测循环依赖
    for node in graph:
        if visited.get(node, 0) == 0:  # 如果节点未访问
            dfs(node)  # 执行DFS
            if has_cycle:  # 如果发现循环依赖，提前终止
                break

    # 根据检测结果输出
    if has_cycle:
        print(len(cycle_nodes))  # 输出循环依赖中的节点数量
    else:
        print(-1)  # 如果无循环依赖，输出-1

if __name__ == "__main__":
    main()  # 调用主函数
