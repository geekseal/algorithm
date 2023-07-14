T = int(input())

for order in range(T):
    N, M = map(int, input().split())
    A, B = [list(map(int, input().split())) for _ in range (2)]
    
    if N < M:
        smaller = A
        larger = B
    else:
        smaller = B
        larger = A

    answer = float('-inf')
    step = 0

    while step <= max(N, M) - min(N, M):
        temp = 0
        for j, i in enumerate(smaller):
            temp += i * larger[j+step]
        if temp > answer:
            answer = temp
        step += 1

    print('#{} {}'.format(order+1, answer))