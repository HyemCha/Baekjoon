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


# 내 풀이
ss = input()
result = 0

for s in ss:
  s = int(s)
  if s == 0 or s ==1 or result == 0 or result == 1:
    result += s
    continue
  result *= s

print(result)

# 답
data = input()

# 첫 번째 문자를 숫자로 변경하여 대입
result = int(data[0])

for i in range(1, len(data)):
    # 두 수 중에서 하나라도 '0' 혹은 '1'인 경우, 곱하기보다는 더하기 수행
  num = int(data[i])
  if num <= 1 or result <= 1:
    result += num
  else:
    result *= num

print(result)

import sys

# 내 풀이
n = int(sys.stdin.readline())
scare = list(map(int, sys.stdin.readline().split()))
scare.sort(reverse=True)
cnt = 0

while True:
  if len(scare) <= 1:
    break
  num = scare[0]
  scare = scare[num:]
  cnt += 1

# output
print(cnt)

# 답
n = int(input())
data = list(map(int, input().split()))
data.sort()

result = 0 # 총 그룹의 수
count = 0 # 현재 그룹에 포함된 모험가의 수

for i in data: # 공포도를 낮은 것부터 하나씩 확인하며
  count += 1 # 현재 그룹에 해당 모험가를 포함
  if count >= i: # 현재 그룹에 포함된 모험가의 수가 현재의 공포도 이상이라면
    result += 1 # 총 그룹의 수 증가
    count = 0 # 현재 그룹에 포함된 모험가의 수 초기화

print(result) # 총 그룹의 수 출력
