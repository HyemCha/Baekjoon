import math

# 2 ~ 1000까지의 모든 수에 대하여 소수 판별
n = 25

array = [True for i in range(n + 1)]

# 에라토스테네스의 체 알고리즘 수행
# 2 ~ n의 제곱근까지의 모든 수를 확인
for i in range(2, int(math.sqrt(n)) + 1):
  if array[i] == True: # i가 소수인 경우
    # i를 제외한 i의 모든 배수 지우기
    j = 2
    while i * j <= n:
      array[i * j] = False
      j += 1

# 모든 소수 출력
for i in range(2, n + 1):
  if array[i]:
    print(i, end=' ')
