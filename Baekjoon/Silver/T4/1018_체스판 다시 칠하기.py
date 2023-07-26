R, C = map(int, input().split())
board = ''
for _ in range(R):
    board += input()

w = 'WBWBWBWBBWBWBWBW'*4
b = 'BWBWBWBWWBWBWBWB'*4

min_correction = float('inf')
for y in range(R-8+1):
    for x in range(C-8+1):
        target = ''
        for j in range(8):
            s = (x + y*C) + j*C
            target += board[s:s+8]

        w_correction = 0
        b_correction = 0
        for i in range(64):
            w_correction += 1 if w[i] == target[i] else 0
            b_correction += 1 if b[i] == target[i] else 0

        if min(w_correction, b_correction) < min_correction:
            min_correction = min(w_correction, b_correction)

        target = ''

print(min_correction)

