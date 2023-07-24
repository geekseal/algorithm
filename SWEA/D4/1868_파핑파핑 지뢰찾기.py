import sys
sys.stdin = open("input.txt", "r")

VISITED = 'O'
UNVISITED = 'X'
BOMB = 'bomb'

T = int(input())
for case_num in range(T):
    # if case_num == 1:
    #     break
    N = int(input())
    arr = [list(input()) for _ in range(N)]
    adjacent = [(-1, -1), (-1, 0), (-1, 1), (0, -1), (0, 1), (1, -1), (1, 0), (1, 1)]
    bvmap = [[[data, UNVISITED] for data in row] for row in arr] # bomb-visit map: [bomb_num, visited]

    # count the number of adjacent bombs
    for y, row in enumerate(bvmap):
        for x, [data, _] in enumerate(row):
            if data == '.':
                bomb_num = 0
                for dy, dx in adjacent:
                    if x+dx < 0 or x+dx >= N or y+dy < 0 or y+dy >= N:
                        continue
                    bomb_num += 1 if bvmap[y+dy][x+dx][0] == '*' else 0
                    bvmap[y][x][0] = bomb_num
            else:
                bvmap[y][x][1] = BOMB

    # find 0 group
    click = 0
    for y, row in enumerate(bvmap):
        for x, [data, is_visited] in enumerate(row):
            if data == 0:
                if is_visited == UNVISITED:
                    click += 1

                bvmap[y][x][1] = VISITED
                
                for dy, dx in adjacent:
                    if x+dx < 0 or x+dx >= N or y+dy < 0 or y+dy >= N:
                        continue
                    bvmap[y+dy][x+dx][1] = VISITED
                    
    for row in bvmap:
        for [data, is_visited] in row:
            if is_visited == UNVISITED:
                click += 1

    print(f'#{case_num + 1} {click}')