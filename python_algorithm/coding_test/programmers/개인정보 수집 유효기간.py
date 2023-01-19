def return_dates(s):
    y, m, d = s.split('.')
    return int(y) * 12 * 28 + int(m) * 28 + int(d)


def solution(today, terms, privacies):
    answer = []

    today_dates = return_dates(today)
    sorts = {}
    for term in terms:
        sort, month = term.split()
        sorts[sort] = int(month) * 28

    for i, privacy in enumerate(privacies):
        ss, sort = privacy.split()
        if return_dates(ss) + sorts[sort] <= today_dates:
            answer.append(i + i)

    return answer
