import sys

n = int(sys.stdin.readline())
direct = list(sys.stdin.readline().replace('\n', '').split())

result = None

x, y = 1, 1
dx = [0, 0, -1, 1]
dy = [-1, 1, 0, 0]
move_types = ['L', 'R', 'U', 'D']

for d in direct:
  for i in range(len(move_types)):
    if d == move_types[i]:
      nx = x + dx[i]
      ny = y + dy[i]
  if nx < 1 or ny < 1 or nx > n or ny > n:
    continue
  x, y = nx, ny

print(x, y)
