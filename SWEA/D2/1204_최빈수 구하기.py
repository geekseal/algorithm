T = int(input())
for i in range(T):
    order = int(input())
    map = {}
    score = list(input().split())

    for j in score:
        if j in map:
            map[j] += 1
        else:
            map[j] = 1

    max_score = 0
    max_num = 0
    
    for s, q in map.items():
        if q > max_num:
            max_score = s
            max_num = q

    print('#{} {}'.format(order, max_score))