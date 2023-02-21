import sys

def dfs(x, y, l):
  if x < 0 or x >= m or y < 0 or y >= n: # 좌표(인덱스) 구분 잘하기
    return 0
  if l == 1:
    if ton[x][y] == 1:
      return 0
    else:
      ton[x][y] = 1
      dfs(x - 1, y, 1)
      dfs(x + 1, y, 1)
      dfs(x, y - 1, 1)
      dfs(x, y + 1, 1)
      return 1

  elif l == 0:
    if toff[x][y] == 0:
      return 0
    else:
      toff[x][y] = 0
      dfs(x - 1, y, 0)
      dfs(x + 1, y, 0)
      dfs(x, y - 1, 0)
      dfs(x, y + 1, 0)
      return 1
      
  
m, n = map(int, sys.stdin.readline().split())

graph = []
for _ in range(m):
  graph.append(list(map(int, sys.stdin.readline().split())))
  
ton = [[graph[j][i] for i in range(n)] for j in range(m)]
toff = [[graph[j][i] for i in range(n)] for j in range(m)]

on, off = 0, 0

for i in range(m):
  for j in range(n):
    on += dfs(i, j, 1)
    off += dfs(i, j, 0)

print(on, off)
