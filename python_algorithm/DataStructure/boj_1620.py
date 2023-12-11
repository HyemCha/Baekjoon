import sys

n, m = map(int, sys.stdin.readline().split())

pocketmons = ['0']

for _ in range(n):
  pocketmon = sys.stdin.readline().replace('\n', '')
  pocketmons.append(pocketmon)

for _ in range(m):
  p = sys.stdin.readline().replace('\n', '')
  if p.isalpha():
    print(pocketmons.index(p))
  elif p.isdigit():
    print(pocketmons[int(p)])
