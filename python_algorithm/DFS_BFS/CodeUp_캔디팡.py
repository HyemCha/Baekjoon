# 캔디팡
# dfs
import sys

def dfs(x, y, ori):
  global cnt
  if x < 0 or x >= 7 or y < 0 or y >= 7:
    return False
  if graph[x][y] == ori and graph[x][y] != 0:
    cnt += 1
    graph[x][y] = 0
    dfs(x, y - 1, ori)
    dfs(x, y + 1, ori)
    dfs(x - 1, y, ori)
    dfs(x + 1, y, ori)
    if cnt >= 3:
      return True
  return False

graph = []
for _ in range(7):
  graph.append(list(map(int, sys.stdin.readline().split())))

cnt = 0
result = 0
for i in range(7):
  for j in range(7):
    cnt = 0
    if dfs(i, j, graph[i][j]) == True:
      result += 1

print(result)
