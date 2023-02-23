import sys
sys.setrecursionlimit(1000000)

def dfs(x, y):
  if x < 0 or x >= h or y < 0 or y >= w:
    return 0
  if graph[x][y] == 'L':
    graph[x][y] = 0
    for i in range(8):
      nx = x + dx[i]
      ny = y + dy[i]
      dfs(nx, ny)
    return 1
  return 0

w, h = map(int, sys.stdin.readline().split())

dx = [-1, -1, -1, 1, 1, 1, 0, 0]
dy = [-1, 0, 1, -1, 0, 1, -1, 1]

graph = []

for _ in range(h):
  graph.append(list(sys.stdin.readline().replace('\n', '').replace(' ', ''))) 

result = 0

for i in range(h):
  for j in range(w):
    result += dfs(i, j) 

print(result)
