n = set(range(1, 10001))
gn = set()

for i in range(1, 10001):
  for j in str(i):
    i += int(j)
  gn.add(i)
sn = sorted(n - gn)
for i in sn:
  print(i)
