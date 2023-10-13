from heapq import heappush, heappop
import sys
sys.stdin = open("input.txt", "r")

def prim(start, end, arr):
    adjacent = [(0, -1), (-1, 0), (0, 1), (1, 0)]
    sy, sx = start
    ey, ex = end
    N = len(arr)

    D = [[float('inf') for _ in range(N)] for _ in range(N)]
    D[sy][sx] = 0

    pq = []
    for y, row in enumerate(D):
        for x, col in enumerate(row):
            heappush(pq, (col, (y, x)))

    while len(pq) != 0:
        distance, (y, x) = heappop(pq)

        for dy, dx in adjacent:
            if x+dx < 0 or x+dx >= N or y+dy < 0 or y+dy >= N:
                continue
            
            new = 0
            if arr[y+dy][x+dx] == 0:
                new = distance + 1
            elif arr[y+dy][x+dx] == 1:
                continue
            elif arr[y+dy][x+dx] == 2:
                new = distance + (3 if distance % 3 == 0 else 2 if distance % 3 == 1 else 1)
                
            if new < D[y+dy][x+dx]:
                try:
                    pq.remove((D[y+dy][x+dx], (y+dy, x+dx)))
                except:
                    pass
                heappush(pq, (new, (y+dy, x+dx)))
                D[y+dy][x+dx] = new
    return D

T = int(input())
for case_num in range(T):
    N = int(input())
    arr = [list(map(int, input().split())) for _ in range(N)]
    start = tuple(map(int, input().split()))
    end = tuple(map(int, input().split()))
    distance_map = prim(start, end, arr)

    from_start_to_end = distance_map[end[0]][end[1]] if distance_map[end[0]][end[1]] != float("inf") else -1
    print(f'#{case_num + 1} {from_start_to_end}')