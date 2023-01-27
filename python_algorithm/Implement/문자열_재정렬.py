import sys

# 내 풀이
s = sys.stdin.readline().replace('\n', '')

string = []
digit = []

for i in s:
  # 문자일 경우
  if ord(i) >= 65:
    string.append(i)
  else:
    digit.append(int(i))

result = sorted(string)
if digit != 0:
  result += str(sum(digit))
r = ''
for i in result:
  r += i
print(r)

# 답
data = input()
resutl =[]
value = 0

# 문자를 하나씩 확인하여
for x in data:
  # 알파벳인 경우 결과 리스트에 삽입
  if x.isalpha():
    result.append(x)
  # 숫자는 따로 더하기
  else:
    value += int(x)

# 알파벳을 오름차순으로 정렬
result.sort()

# 숫자가 하나라도 존재하는 경우 가장 뒤에 삽입
if value != 0:
  result.append(str(value))

# 최종 겨로가 출력(리스트를 문자열로 변환하여 출력)
print(''.join(result))
