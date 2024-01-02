import sys

n, k = map(int, sys.stdin.readline().split())
arrA = list(map(int, sys.stdin.readline().split()))
arrB = list(map(int, sys.stdin.readline().split()))

# 내 풀이
# for _ in range(k):
#   minA = min(arrA)
#   aIndex = arrA.index(minA)
#   maxB = max(arrB)
#   bIndex = arrB.index(maxB)
#   arrA[aIndex], arrB[bIndex] = arrB[bIndex], arrA[aIndex]

# 답
arrA.sort()
arrB.sort(reverse=True)

for i in range(k):
  if arrA[i] < arrB[i]:
    arrA[i], arrB[i] = arrB[i], arrA[i]
  else:
    break

print(sum(arrA))
