import sys
from collections import deque

graph = []

def bfs(x, y):
  queue = deque()
  queue.append((x, y))
  graph[x][y] = '*'
  while queue:
    x, y = queue.popleft()
    for i in range(4):
      nx = x + dx[i]
      ny = y + dy[i]
      if nx < 0 or nx >= 10 or ny < 0 or ny >= 10:
        continue
      if graph[nx][ny] == '*':
        continue
      graph[nx][ny] = '*'
      queue.append((nx, ny))
        

for _ in range(10):
  graph.append(list(sys.stdin.readline().replace('\n', '')))

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

a, b = map(int, sys.stdin.readline().split())

if graph[b][a] == '_':
  bfs(b, a)

for i in graph:
  for j in i:
    print(j, end='')
  print()
