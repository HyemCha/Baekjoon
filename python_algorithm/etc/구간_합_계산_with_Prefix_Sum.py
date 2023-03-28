# n개의 정수로 구성된 수열
# m개의 쿼리 정보, 각 쿼리는 left와 right로 구성, 각 쿼리에 대해 [left, right] 구간에 포함된 데이터들의 합을 출력
# 수행 시간 제한은 O(N + M)

# 데이터의 개수 n과 데이터 입력받기
n = 5
data = [10, 20, 30, 40, 50]

# 접두사 합(Prefix Sum) 배열 계산
sum_value = 0
prefix_sum = [0]
for i in data:
  sum_value += i
  prefix_sum.append(sum_value)

# 구간 합 계산(세 번째 수부터 네 번째 수까지)
left = 3
right = 4
print(prefix_sum[right] - prefix_sum[left - 1])
