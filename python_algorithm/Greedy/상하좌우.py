import sys

n = int(sys.stdin.readline())
des = list(sys.stdin.readline().split())

graph = [(x + 1, y + 1) for y in range(n) for x in range(n)]

x = 1
y = 1

dir = ['R', 'U', 'L', 'D']

dx = [0, -1, 0, 1]
dy = [1, 0, -1, 0]
nx, ny = x, y

for d in des:
  for i in range(len(dir)):
    if d == dir[i]:
      nx = x + dx[i]
      ny = y + dy[i]

  if nx < 1 or ny < 1 or nx > n or ny > n:
    continue
  x, y = nx, ny

print(x, y)
