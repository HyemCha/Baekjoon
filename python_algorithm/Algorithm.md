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
