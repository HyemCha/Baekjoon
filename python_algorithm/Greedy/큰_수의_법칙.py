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


# 다른 풀이
# 수열; (k+1)이 반복되는
n, m, k = map(int, sys.stdin.readline().split())
nat = list(map(int, sys.stdin.readline().split()))

nat.sort(reverse=True)
first = nat[0]
second = nat[1]

# 가장 큰 수가 더해지는 횟수 
count = int(m / (k + 1)) * k
count += m % (k + 1)

result = 0
result += (count) * first
result += (m - count) * second

print(result)
