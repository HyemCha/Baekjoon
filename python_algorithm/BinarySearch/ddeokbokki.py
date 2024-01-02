import sys

n, m = map(int, sys.stdin.readline().split())

list = list(map(int, sys.stdin.readline().split()))
result = 0

for i in range(n):
  temp = []
  for j in range(n):
    if list[j] <= list[i]:
      temp.append(0)
    else:
      temp.append(list[j] - list[i])
  if sum(temp) >= m:
    result = list[i]
    break

print(result)