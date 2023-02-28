import sys

def dfs(x, y):
  if x < 0 or x >= 10 or y < 0 or y >= 10:
    return
  if graph[x][y] == '_':
    graph[x][y] = '*'
    dfs(x - 1, y)
    dfs(x + 1, y)
    dfs(x, y - 1)
    dfs(x, y + 1)
  

graph = []

for _ in range(10):
  graph.append(list(sys.stdin.readline().replace('\n', '')))

a, b = map(int, sys.stdin.readline().split())

dfs(b, a)
for i in graph:
  for j in i:
    print(j, end='')
  print()
