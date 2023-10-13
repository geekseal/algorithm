import itertools
# sys.stdin = open("input.txt", "r")

T = int(input())

comparative_set = {1,2,3,4,5,6,7,8,9}

for case_num in range(T):
    arr = [list(map(int, input().split())) for _ in range(9)]

    answer = 1

    # check in row-way
    for row in arr:
        if set(row) != comparative_set:
            answer = 0
            break

    # check in column-way
    rotated_arr = [list(row) for row in zip(*arr[::-1])]
    for row in rotated_arr:
        if set(row) != comparative_set:
            answer = 0
            break

    # check in 3*3-way
    for i in range(0, 9, 3):
        # print([row[j:j+3] for j in range(0, 9, 3) for row in arr[i:i+3]])
        for j in range(0, 9, 3):
            modified_arr = list(itertools.chain(*[row[j:j+3] for row in arr[i:i+3]]))
            if set(modified_arr) != comparative_set:
                answer = 0
                break
            
    print('#{} {}'.format(case_num+1, answer))