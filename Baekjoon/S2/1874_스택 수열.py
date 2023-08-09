import sys
sys.stdin = open("input.txt", "r")

N = int(sys.stdin.readline())

stack = []
start = 1
answer = ''

for _ in range(N):
    num = int(sys.stdin.readline())
    if num < start:
        if num != stack.pop():
            answer = 'NO'
            break
        else:
            answer += '-'

    else:
        for i in range(start, num + 1):
            stack.append(i)
            answer += '+'
        stack.pop()
        answer += '-'
        start = num + 1

if answer == 'NO':
    print(answer)
else:
    for i in answer:
        print(i)