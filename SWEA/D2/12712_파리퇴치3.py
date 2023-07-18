import sys
sys.stdin = open("input.txt", "r")

T = int(input())

for case_num in range(T):
    N, S = map(int, input().split())
    arr = [list(map(int, input().split())) for row in range(N)]
    max_paris = float('-inf')

    # https://stackoverflow.com/questions/16940293/why-is-there-no-tuple-comprehension-in-python
    index_range = tuple(i for i in range(N))
    
    for row_index, row in enumerate(arr):
        for col_index, col in enumerate(row):
            cross = col
            diagonal = col

            # cross-way
            for i in range(-S+1, S):
                if i == 0:
                    continue
                if col_index + i in index_range:
                    cross += arr[row_index][col_index + i]
                if row_index + i in index_range:
                    cross += arr[row_index + i][col_index]

            # diagonal way
            for i in range(1, S):
                if row_index - i in index_range and col_index - i in index_range:
                    diagonal += arr[row_index - i][col_index - i]
                if row_index - i in index_range and col_index + i in index_range:
                    diagonal += arr[row_index - i][col_index + i]
                if row_index + i in index_range and col_index - i in index_range:
                    diagonal += arr[row_index + i][col_index - i]
                if row_index + i in index_range and col_index + i in index_range:
                    diagonal += arr[row_index + i][col_index + i]

            if max(cross, diagonal) > max_paris:
                max_paris = max(cross, diagonal)

    print('#{} {}'.format(case_num + 1, max_paris))