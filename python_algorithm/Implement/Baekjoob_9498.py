import sys

n = int(sys.stdin.readline())

if 90 <= n <= 100:
    print("A")
elif n >= 80:
    print("B")
elif n >= 70:
    print("C")
elif n >= 60:
    print("D")
else:
    print("F")