import sys

n = int(sys.stdin.readline())
list = list(map(int, sys.stdin.readline().split()))
data = list.copy()

list.sort()

cnt = 0

# 나의 풀이
while list:
  if list[-1] > len(list):
    break
  a = list[0]
  list = list[a:].copy()
  cnt += 1

# 답
# cnt = 0
# count_person = 0

# for i in data:
#   count_person += 1
#   if count_person >= i:
#     cnt += 1
#     count_person = 0

print(cnt)
