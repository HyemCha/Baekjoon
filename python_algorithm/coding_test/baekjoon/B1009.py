n = int(input())
for i in range(n):
    a, b = map(int, input().split())
    if a % 10 == 0:
        print(10)
    elif b % 4 == 0:
        a = a**4
        print(a%10)
    else:
        b %= 4
        print(a**b%10)