import sys

n = int(sys.stdin.readline())

result = 1
p1 = 1
p2 = 1
for _ in range(n-2):
  result = p1 + p2
  p1 = p2
  p2 = result

print(result)
