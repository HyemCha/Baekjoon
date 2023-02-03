# bfs
import sys
from collections import deque

def bfs(x):
  global cnt
  queue = deque()
  queue.append(x)

  while queue:
    x = queue.popleft()
    for i in range(1, n+1):
      if graph[x][i] == 1 and visited[i] == False:
        queue.append(i)
        visited[i] = True
        cnt += 1

n = int(sys.stdin.readline())
mate = int(sys.stdin.readline())

graph = [[0]*(n+1) for _ in range(n+1)]
visited = [False] * (n + 1)

cnt = 0

for i in range(mate):
  a, b = map(int, sys.stdin.readline().split())
  graph[a][b] = 1
  graph[b][a] = 1

bfs(1)

print(cnt-1)
