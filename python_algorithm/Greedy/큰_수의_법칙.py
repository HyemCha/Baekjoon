import sys
  
n, m, k = map(int, sys.stdin.readline().split())
nat = list(map(int, sys.stdin.readline().split()))

nat.sort(reverse=True)
first = nat[0]
second = nat[1]

result = 0

while True:
  for i in range(k):
    if m == 0:
      break
    result += first
    m -= 1
  if m == 0:
    break
  result += second
  m -= 1

print(result)
