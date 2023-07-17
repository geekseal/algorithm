import sys
from itertools import permutations
sys.stdin = open("input.txt", "r")

T = int(input())

def get_distance(c1, c2):
    return abs(c1[0] - c2[0]) + abs(c1[1] - c2[1])

for case_num in range(T):
    answer = float('inf')

    client_num = int(input())
    coordinates = list(map(int, input().split()))
    [start, end, *stopover] = [[x, y] for x, y in zip(coordinates[0::2], coordinates[1::2])]
    
    for permutation in permutations(range(len(stopover)), len(stopover)):
        temp = get_distance(start, stopover[permutation[0]]) + get_distance(stopover[permutation[-1]], end)

        for a, b in zip(permutation, permutation[1:]):
            temp += get_distance(stopover[a], stopover[b])

        if temp < answer:
            answer = temp

    print('#{} {}'.format(case_num + 1, answer))