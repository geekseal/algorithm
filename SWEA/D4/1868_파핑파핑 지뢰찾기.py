import sys
sys.stdin = open("input.txt", "r")

T = int(input())
for case_num in range(T):
    # if case_num == 1:
    #     break
    N = int(input())
    arr = [list(input()) for _ in range(N)]
    adjacent = [(-1, -1), (-1, 0), (-1, 1), (0, -1), (0, 1), (1, -1), (1, 0), (1, 1)]
    visited = [[False for _ in range(N)] for _ in range(N)]
    bomb_map = [[0] * N for _ in range(N)]

    # count the number of adjacent bombs
    for y, row in enumerate(arr):
        for x, data in enumerate(row):
            if data == '.':
                for dy, dx in adjacent:
                    if 0 <= x+dx < N and 0 <= y+dy < N:
                        bomb_map[y][x] += 1 if arr[y+dy][x+dx] == '*' else 0
            else:
                bomb_map[y][x] = -1

    # find 0 click
    click = 0
    for y, row in enumerate(bomb_map):
        for x, bomb_num in enumerate(row):
            if bomb_num == 0:
                if not visited[y][x]:
                    click += 1
                    visited[y][x] = True
                
                for dy, dx in adjacent:
                    if 0 <= x+dx < N and 0 <= y+dy < N:
                        if not visited[y+dy][x+dx]:
                            visited[y+dy][x+dx] = True
                    
    for y in range(N):
        for x in range(N):
            if bomb_map[y][x] != -1 and not visited[y][x]:
                click += 1

    print(f'#{case_num + 1} {click}')