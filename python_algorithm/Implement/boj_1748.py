import sys

n = int(sys.stdin.readline())
lenN = len(str(n))

result = 0

for i in range(lenN - 1):
  result += 9 * 10 ** i * (i + 1)

result += (n - 10**(lenN - 1) + 1) * lenN
print(result)
