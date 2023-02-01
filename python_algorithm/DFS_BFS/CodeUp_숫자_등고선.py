# 숫자 등고선
# bfs
import sys
from collections import deque

def bfs(x, y):
  queue = deque()
  queue.append((x, y))

  while queue:
    x, y = queue.popleft()
    for i in range(4):
      nx = x + dx[i]
      ny = y + dy[i]
      if nx < 0 or nx >= size or ny < 0 or ny >= size:
        continue
      if graph[nx][ny] != 0:
        continue
      graph[nx][ny] = graph[x][y] + 1
      queue.append((nx, ny))

  return

size = int(sys.stdin.readline())
a, b = map(int, sys.stdin.readline().split())

graph = []

dx = [0, 0, -1, 1]
dy = [-1, 1, 0, 0]

for _ in range(size):
  graph.append(list([0]*size))
  
graph[a - 1][b - 1] = 1

bfs(a-1, b-1)

for i in graph:
  for j in i:
    print(j, end=' ')
  print()
