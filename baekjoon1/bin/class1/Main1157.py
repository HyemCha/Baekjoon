s = input().upper()
unique_words = list(set(s))
w_list = []
for i in unique_words:
    cnt = s.count(i)
    w_list.append(cnt)
if w_list.count(max(w_list)) > 1:
    print('?')
else:
    max_index = w_list.index(max(w_list))
    print(unique_words[max_index])