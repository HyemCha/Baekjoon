import sys

n = int(sys.stdin.readline())
dis = list(map(int, sys.stdin.readline().split()))
cost = list(map(int, sys.stdin.readline().split()))

result = 0
min = cost[0]

for i in range(len(cost) - 1):
  if min > cost[i]:
    min = cost[i]
  result += dis[i] * min

print(result)