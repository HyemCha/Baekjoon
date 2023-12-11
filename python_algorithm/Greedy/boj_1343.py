import sys

ss = input()

ss.replace('XXXX', 'AAAA')
ss.replace('XX', 'BB')

if 'X' in ss:
  print(-1)
else:
  print(ss)
