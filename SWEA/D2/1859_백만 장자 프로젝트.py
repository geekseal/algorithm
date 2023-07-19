import sys
sys.stdin = open("input.txt", "r")

T = int(input())
for case_num in range(T):
    N = int(input())
    market_price_by_day = list(map(int, input().split()))

    cost = 0
    profit = 0

    while len(market_price_by_day) != 0:
        max_price = max(market_price_by_day)
        for day, price in enumerate(market_price_by_day):
            if price == max_price:
                profit += (price * day) - cost
                cost = 0
                market_price_by_day = market_price_by_day[day + 1:] # list[len(list):] == [], while list[len(list)] raises IndexError
                break
            cost += price

    print(f'#{case_num + 1} {profit}')