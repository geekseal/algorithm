import sys
sys.stdin = open("input.txt", "r")

def merge_sort(S):
    n = len(S)
    if n < 2:
        return
    
    mid = n // 2
    S1 = S[0:mid]
    S2 = S[mid:]

    merge_sort(S1)
    merge_sort(S2)

    merge(S1, S2, S)

def merge(S1, S2, S):
    i = j = 0
    while i + j < len(S):
        if j == len(S2) or (i < len(S1) and len(S1[i]) < len(S2[j])):
            S[i+j] = S1[i]
            i += 1
        elif i < len(S1) and len(S1[i]) == len(S2[j]):
            if S1[i] < S2[j]:
                S[i+j] = S1[i]
                i += 1
            else:
                S[i+j] = S2[j]
                j += 1
        else:
            S[i+j] = S2[j]
            j += 1

N = int(sys.stdin.readline())
arr = list(set([sys.stdin.readline().strip() for _ in range(N)]))
merge_sort(arr)
for word in arr:
    print(word)