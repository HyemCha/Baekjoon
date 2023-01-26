import sys

n = int(sys.stdin.readline())
result = 0

result += (n // 50000)
n %= 50000
result += (n // 10000)
n %= 10000
result += (n // 5000)
n %= 5000
result += (n // 1000)
n %= 1000
result += (n // 500)
n %= 500
result += (n // 100)
n %= 100
result += (n // 50)
n %= 50
result += (n // 10)
n %= 10

print(result)
