import sys

n = int(sys.stdin.readline())

cnt = 0
result = 0

for _ in range(n):
  ws = sys.stdin.readline().replace('\n', '')
  wset = set(ws)
  wlist = [1]
  for i in ws:
    nw = i
    if nw != wlist[-1]:
      wlist.append(nw)

  wlist.remove(1)
  result = len(wlist) - len(wset)

  if result == 0:
    cnt += 1
    
print(cnt)
