# 读取商品种类数 M
M = int(input())

# 初始化商品的价格列表：原始价格 X，单件折扣价 Y，两件折扣价 Z
X, Y, Z = [], [], []
for _ in range(M):
    xi, yi, zi = map(int, input().split())  # 输入每种商品的价格信息
    X.append(xi)  # 原始价格
    Y.append(yi)  # 单件折扣价
    Z.append(zi)  # 两件折扣价

# 读取小明的预算 N
N = int(input())

# 动态规划数组，dp[i] 表示花费 i 元可以获得的最大优惠金额
dp = [0] * (N + 1)

# 遍历每种商品，处理其购买选择
for i in range(M):
    items = []  # 存储当前商品的所有购买选择
    # 不购买该商品
    items.append((0, 0))  # 花费为 0，优惠为 0
    # 购买一件该商品
    cost1 = Y[i]  # 花费为单件折扣价
    discount1 = X[i] - Y[i]  # 优惠为原始价格减去单件折扣价
    if cost1 <= N:  # 确保当前预算内可以购买
        items.append((cost1, discount1))
    # 购买两件该商品
    cost2 = 2 * Z[i]  # 总花费为两件的折扣价
    discount2 = 2 * X[i] - 2 * Z[i]  # 总优惠为两件的原始价格减去折扣价
    if cost2 <= N:  # 确保当前预算内可以购买
        items.append((cost2, discount2))

    # 动态规划更新，倒序遍历避免重复计算
    for j in range(N, -1, -1):  # 从最大预算倒序更新
        for cost, discount in items:
            if j >= cost:  # 如果当前预算 j 足够支付当前选择的花费
                # 更新 dp[j]，取最大优惠金额
                dp[j] = max(dp[j], dp[j - cost] + discount)

# 输出结果，dp[N] 即为在预算 N 内可以获得的最大优惠金额
print(dp[N])
