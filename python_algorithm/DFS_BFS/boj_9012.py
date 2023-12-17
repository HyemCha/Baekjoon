import sys


n = int(sys.stdin.readline())

for _ in range(n):
  stack = []
  list = sys.stdin.readline().strip()
  for i in list:
    if i == '(':
      stack.append(i)
    elif i == ')':
      if stack:
        stack.pop()
      else:
        print('NO')
        break
  else:      
    if not stack:
      print('YES')
    else:
      print('NO')