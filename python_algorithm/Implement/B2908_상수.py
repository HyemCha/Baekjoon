import sys

a, b = sys.stdin.readline().split()

result = None

for i in range(2, -1, -1):
  if a[i] > b[i]:
    result = a
    break
  elif a[i] < b[i]:
    result = b
    break

for i in range(2, -1, -1):
  print(result[i], end='')
