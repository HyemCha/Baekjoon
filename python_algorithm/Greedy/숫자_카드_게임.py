import sys

n, m = map(int, sys.stdin.readline().split())

# 내 풀이
max = -sys.maxsize -1

for _ in range(n):
  tmp = 0
  data = list(map(int, sys.stdin.readline().split()))
  data.sort()
  if max < data[0]:
    max = data[0]
    
 
# 답
result = 0
for i in range(n):
  data = list(map(int, input().split())
  # 1
  min_value = min(data)
  result = max(result, min_value)
              
  # 2            
  min_value = 10001
  for a in data:
      min_value = min(min_value, a)
  result = max(result, min_value)
             
print(max)
