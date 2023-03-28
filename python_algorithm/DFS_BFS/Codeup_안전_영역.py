import sys

sys.setrecursionlimit(1000000)


def dfs(x, y, axis):
    if x < 0 or x >= n or y < 0 or y >= n:
        return 0
    if graph[x][y] > axis and visited[x][y] == 0:
        visited[x][y] = 1
        dfs(x + 1, y, axis)
        dfs(x - 1, y, axis)
        dfs(x, y + 1, axis)
        dfs(x, y - 1, axis)
        return 1
    return 0


n = int(sys.stdin.readline())
graph = []
for _ in range(n):
    graph.append(list(map(int, sys.stdin.readline().split())))

max_value = max(max(graph))

result = 0

for i in range(0, max_value):
    tmp = 0
    # graph_c = []
    # graph_c = [[graph[x][y] for y in range(n)] for x in range(n)]
    visited = [[0] * n for _ in range(n)]

    for j in range(n):
        for k in range(n):
            tmp += dfs(j, k, i)
    result = max(tmp, result)

print(result)
