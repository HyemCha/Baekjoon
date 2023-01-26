import sys

m = 2001
pasta = list(int(sys.stdin.readline()) for _ in range(3))
veberage = list(int(sys.stdin.readline()) for _ in range(2))

result = (min(pasta) + min(veberage)) * 1.1
result = round(result, 1)

print(result)
