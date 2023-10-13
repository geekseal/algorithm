import sys
from heapq import heappush, heappop, heapify, _siftdown, _siftup
sys.stdin = open("input.txt", "r")

T = int(input())
for case_num in range(T):
    N = int(input())
    arr = [list(map(int, input())) for _ in range(N)]

    D = [[float('inf') for _ in range(N)] for _ in range(N)]
    sy, sx = (0, 0)
    ey, ex = (-1, -1)
    D[sy][sx] = 0

    pq = []
    adjacent = ((0, 1), (1, 0), (0, -1), (-1, 0)) # should look for cross edges
    for y, row in enumerate(D):
        for x, d in enumerate(row):
            heappush(pq, (d, (y, x)))

    while D[ey][ex] == float('inf'):
        # print(d, y, x)
        d, (y, x) = heappop(pq)
        for dy, dx in adjacent:
            if x+dx < 0 or x+dx >= N or y+dy < 0 or y+dy >= N:
                continue

            new_d = d + arr[y+dy][x+dx]
            if new_d < D[y+dy][x+dx]:
                # You can delete an element in heapq, but then you will need to re-heapify it
                # because it will no longer satisfy the heap invariant.
                # https://docs.python.org/3/library/heapq.html#priority-queue-implementation-notes
                # https://stackoverflow.com/questions/10162679/python-delete-element-from-heap
                i = pq.index((D[y+dy][x+dx], (y+dy, x+dx)))
                pq[i] = pq[-1]
                pq.pop()
                if i < len(pq):
                    _siftup(pq, i)
                    _siftdown(pq, 0, i)
                
                '''
                below raises time error in case 10
                pq.remove((D[y+dy][x+dx], (y+dy, x+dx)))
                heapify(pq)
                '''

                # however, it is much faster to use (try, except) rather than re-heapifying it,
                # if heap invariant doesn't matter to you.
                # it still gives you the right answer. why?
                '''
                try:
                    pq.remove((D[y+dy][x+dx], (y+dy, x+dx)))
                except:
                    pass
                '''
                
                heappush(pq, (new_d, (y+dy, x+dx)))
                D[y+dy][x+dx] = new_d

    print(f'#{case_num + 1} {D[ey][ex]}')