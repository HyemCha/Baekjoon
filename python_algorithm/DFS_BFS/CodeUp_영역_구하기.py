import sys
sys.setrecursionlimit(1000000)

def res(x, y):
  global cnt
  
  if x < 0 or x >= m or y < 0 or y >= n:
    return False
  if graph[x][y] == 0:
    graph[x][y] = 1
    cnt += 1
    for i in range(4):
      nx = x + dx[i]
      ny = y + dy[i]
      res(nx, ny)
    return True
  return False

dx = [0, 0, -1, 1]
dy = [-1, 1, 0, 0]

m, n, k = map(int, sys.stdin.readline().split())

graph = []
for i in range(m):
  graph.append([0]*n)

for _ in range(k):
  lx, ly, rx, ry = map(int, sys.stdin.readline().split())
  for i in range(ly, ry):
    for j in range(lx, rx):
      graph[i][j] = 1

result = 0
cnt = 0
c = []

for i in range(m):
  for j in range(n):
    if res(i, j) == True:
      result += 1
      c.append(cnt)
      cnt = 0
c.sort()
print(result)
for i in c:
  print(i, end=' ')
