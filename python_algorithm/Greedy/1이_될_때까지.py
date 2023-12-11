import sys

n, k = map(int, sys.stdin.readline().split())
cnt = 0

print(n // k)

# 나의 풀이
# while True:
#   if n == 1:
#     break
#   if n % k == 0:
#     n //= k
#   else:
#     n -= 1
#   cnt += 1

# cnt = 0
# # 답
# while True:
#   target = (n // k) * k
#   cnt += (n - target)
#   n = target
#   if n < k:
#     break
#   cnt += 1
#   n //= k

# cnt += (n - 1)
# print(cnt)