import sys, itertools
sys.stdin = open("input.txt", "r")

T = int(input())
for case_num in range(T):
    N, M = map(int, input().split())
    relationships = [input().split() for _ in range(M)]

    # consider when M = 0
    groups = []

    for idx, relation in enumerate(relationships):
        if idx == 0:
            groups.append(relationships[0])
            continue

        is_relation_new = True
        idx_to_be_joined = []

        for idx, group in enumerate(groups):
            is_group = len(group + relation) != len(set(group + relation))
            if is_group:
                groups[idx] = list(set(group + relation))
                is_relation_new = False
                idx_to_be_joined.append(idx)
        
        if len(idx_to_be_joined) == 2:
            x, y = idx_to_be_joined
            groups[x] = list(set(groups[x] + groups[y]))
            del groups[y]

        if is_relation_new:
            groups.append(relation)

    # there might be people not metioned in M-case
    solo_num = N - len(list(itertools.chain.from_iterable(groups)))

    print(f'#{case_num + 1} {len(groups) + solo_num}')