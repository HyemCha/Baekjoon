import sys

k = int(sys.stdin.readline())
data = []

for i in range(k):
  nn = int(sys.stdin.readline())
  if nn == 0 and len(data) > 0:
    data.pop()
    continue
  data.append(nn)

if len(data) == 0:
  print(0)
else:
  print(sum(data))
