import sys

def hansu(x):
  cnt = 0
  for num in range(1, x + 1):
    if num < 100:
      cnt += 1
    else:
      num = str(num)
      if int(num[2]) - int(num[1]) == int(num[1]) - int(num[0]):
        cnt += 1
  return cnt

n = sys.stdin.readline().replace('\n', '')
result = hansu(int(n))
print(result)