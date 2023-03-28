import sys

n = int(sys.stdin.readline())

array = list(map(int, sys.stdin.readline().split()))

array.sort()

check = 0
for i in range(n):
    num = array[i]
    if num == check + 1:
        continue
    for j in range(i+1):
        pass