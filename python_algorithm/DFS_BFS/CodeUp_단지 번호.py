import sys

def dfs(x, y):
  global cnt
  
  if x < 0 or x >= n or y < 0 or y >= n:
    return False
  if graph[x][y] == '1':
    cnt += 1
    graph[x][y] = '0'
    dfs(x - 1, y)
    dfs(x + 1, y)
    dfs(x, y - 1)
    dfs(x, y + 1)
    return True
  return False
    

n = int(sys.stdin.readline())

graph = []
for _ in range(n):
  graph.append(list(sys.stdin.readline().replace('\n', '')))

c = []
cnt = 0

for i in range(n):
  for j in range(n):
    if dfs(j, i) == True:
      c.append(cnt)
      cnt = 0

c.sort()

print(len(c))
for i in c:
  print(i)
