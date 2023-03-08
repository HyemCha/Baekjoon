from collections import deque

def bfs(x, y):
  queue = deque()
  queue.append([x, y])
  check[x][y] = 1

  while queue:
    x, y = queue.popleft()

    count = 0
    for i in range(8):
      nx, ny = x+dx[i], y+dy[i]
      if 0 <= nx < n and 0<= ny < n:
        if mine[nx][ny] == 1:
          count += 1
    minecount[x][y] = count

    if count > 0:
      continue

    for i in range(8):
      nx, ny = x+dx[i], y+dy[i]

      if 0<= nx and nx < n and 0<= ny and ny < n:
        if check[nx][ny] == 0 and mine[nx][ny] == 0:
          check[nx][ny] = 1
          queue.append([nx, ny])

n = 9
mine = []

for i in range(n):
  mine.append(list(map(int, input().split())))

x, y = map(int, input().split())
x -= 1
y -= 1

dx = [-1, -1, -1, 0, 0, 1, 1, 1]
dy = [-1, 0, 1, -1, 1, -1, 0, 1]

check = [[0 for x in range(n)] for y in range(n)]
minecount = [[0 for x in range(n)] for y in range(n)]

if mine[x][y] == 1:
  check[x][y] = 1
  minecount[x][y] = -1

else:
  bfs(x, y)

for i in range(n):
  for j in range(n):
    if check[i][j] == 1:
      print(minecount[i][j], end=' ')
    else:
      print('_', end=' ')
  print()
