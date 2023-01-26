import sys

a, b = map(int, sys.stdin.readline().split())
c = abs(b - a)
result = 0

result += c // 10
c %= 10

if c in [2, 4, 6, 9]:
  result += 2
elif c in [3, 4, 7, 8]:
  result += 3
elif c in [1, 5]:
  result += 1
  
print(result)
