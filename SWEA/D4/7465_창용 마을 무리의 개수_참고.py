T = int(input())
for test_case in range(1, T+1):
    N, M = map(int, input().split())
    graph = [[] for _ in range(N+1)]
    checked = [False]*(N+1)
    answer = 0
     
    for i in range(M):
        a, b = map(int, input().split())
        graph[a].append(b)
        graph[b].append(a)
         
    def dfs(vertex):
        if not checked[vertex]:
            checked[vertex] = True
            for v in graph[vertex]:
                dfs(v)
         
    for i in range(1, N+1):
        if not checked[i]:
            dfs(i)
            answer += 1
             
    print("#" + str(test_case), answer)