### Greedy Algorithm
- 현재 상황에서 지금 당장 좋은 것만 고르는 방법
- 문제를 풀기 위한 최소한의 아이디어를 떠올릴 수 있는 능력을 요구
- 정당성 분석이 중요
```i = 0
while True:
  l, p, v = map(int, input().split())
  if l == 0 and p == 0 and v == 0:
    break

  if p >= v:
    result = l
  else:
    remainder = v % p
    modulo = int(v / p) * l
    if remainder >= l:
      result = modulo + l
    else:
      result = modulo + remainder

  i+=1
  print(f'Case {i}: {result}')```


```import sys
# 내 풀이
# input
n, k = map(int, sys.stdin.readline().split())
cnt = 0

# process
while n > 1:
  if n%k == 0:
    n = n//k
  else:
    n -=1
  cnt += 1
  
# output
print(cnt)

# 답
result = 0

while True:
  # N이 K로 나누어 떨어지는 수가 될 때까지 빼기
  target = (n // k) * k
  result += (n - target)
  n = target
  #  N이 K보다 작을 때 (더 이상 나눌 수 없을 때) 반복문 탈출
  if n < k:
    break
  # K로 나누기
  result += 1
  n //= k

# 마지막으로 남은 수에 대하여 1씩 빼기
result += (n - 1)
print(result)```
