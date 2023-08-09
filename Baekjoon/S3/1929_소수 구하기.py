import sys, math
sys.stdin = open("input.txt", "r")

def is_prime_num(n):
    arr = [True] * (n + 1)
    arr[0] = False
    arr[1] = False

    for i in range(2, int(math.sqrt(n)+1)):
        if arr[i] == True:
            j = 2

            while (i * j) <= n:
                arr[i*j] = False
                j += 1

    return arr

S, E = map(int, sys.stdin.readline().split())
arr = is_prime_num(E)

for i in range(S, E+1):
    if arr[i] == True:
        print(i)