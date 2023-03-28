import sys

n, k = map(int, sys.stdin.readline().split())

array = []
for _ in range(n):
    a = int(sys.stdin.readline())
    if a > k:
        break
    array.append(a)

cnt = 0

for i in array[::-1]:
    cnt += (k // i)
    k %= i

print(cnt)
