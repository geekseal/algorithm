# import sys
# sys.stdin = open("input.txt", "r")

T = int(input())

for case_num in range(T):
    N = int(input())
    answer = [[0 for col in range(3)] for row in range(N)]
    arr = [list(input().split()) for row in range(N)]

    for order, reversed_order in zip(range(N), reversed(range(N))):
        first = ''
        second = ''
        third = ''

        for i in range(N):
            first = arr[i][order] + first
            second = arr[reversed_order][i] + second
            third = third + arr[i][reversed_order]

        answer[order][0] = first
        answer[order][1] = second
        answer[order][2] = third

    print('#{}'.format(case_num+1))
    for row in answer:
        print('{}'.format(' '.join(row)))