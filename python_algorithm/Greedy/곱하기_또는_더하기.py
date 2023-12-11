import sys

ss = sys.stdin.readline().rstrip()
n = int(ss[0])
for s in range(1, len(ss)):
  print(s)
  if s == '0' or s == '1':
    n += int(s)
    continue
  n *= int(s)

print(n)