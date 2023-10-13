from collections import deque
 
for T in range(int(input())):
    N = int(input())
    arr = [list(map(lambda x:int(x),list(input()))) for _ in range(N)]
     
    dirs = [(1,0),(-1,0),(0,1),(0,-1)]
    visited = [[False] * N for _ in range(N)]
    graph = [[float('inf')] * N for _ in range(N)]
    graph[0][0] = 0
     
    queue = deque()
    queue.append((0,0))
    while queue:
        x,y = queue.popleft()
         
        for dx,dy in dirs:
            if 0 <= x+dx < N and 0 <= y+dy < N:
                cost = graph[x][y] + arr[x+dx][y+dy]
                if graph[x+dx][y+dy] > cost:
                    graph[x+dx][y+dy] = cost
                    queue.append((x+dx, y+dy))
     
    print('#{} {}'.format(T+1,graph[-1][-1]))