import sys

n = int(sys.stdin.readline())
a, b = map(int, sys.stdin.readline().split())
c = int(sys.stdin.readline())
di = list(int(sys.stdin.readline()) for _ in range(n))
di.sort(reverse=True)

result = 0
calories = c
cost = a
result = c / a

for i in range(len(di)):
  calories = calories + di[i]
  cost = cost + b
  tmp_res = calories / cost

  if tmp_res > result:
    result = tmp_res
  else:
    break

print(int(result))
