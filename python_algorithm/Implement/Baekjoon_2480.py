import sys

array = list(map(int, sys.stdin.readline().split()))

array.sort()

cnt = 1
n = 0

for i in range(1, len(array)):
    if array[i - 1] == array[i]:
        cnt += 1
        n = array[i]

if cnt == 1:
    print(max(array) * 100)
elif cnt == 2:
    print(1000 + n * 100)
elif cnt == 3:
    print(10000 + n * 1000)