from collections import deque
import sys

def bfs(x, y):
  queue = deque()
  queue.append((x, y))

  while queue:
    x, y = queue.popleft()
    for i in range(4):
      nx = x + dx[i]
      ny = y + dy[i]
      if nx < 0 or nx >= n or ny < 0 or ny >= m:
        continue
      if graph[nx][ny] == 1:
        continue
      graph[nx][ny] = graph[x][y] + 1
      queue.append((nx, ny))

  return graph[n - 1][m - 1]

n, m = map(int, sys.stdin.readline().split())

graph = []

dx = [0, 0, -1, 1]
dy = [-1, 1, 0, 0]

for _ in range(n):
  graph.append(list(map(int, sys.stdin.readline().replace('\n', ''))))

print (bfs(0, 0))
