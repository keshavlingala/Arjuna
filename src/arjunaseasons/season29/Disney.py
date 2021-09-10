# to avoid iterating through all the days in year
# instead taking a factor dictionary called paid where each day is mapped to a boolean value
def buymonth(cost, paid, day):
    cost += prices[2]
    for i in range(days[day], days[day] + 30):
        if i in paid.keys():
            paid[i] = True
    if all((p is True for p in paid.values())):
        return cost
    return bt(days, prices, paid, cost, day + 1)


def buyday(cost, paid, day):
    cost += prices[0]
    paid[days[day]] = True
    return bt(days, prices, paid, cost, day + 1)


def buyweek(cost, paid, day):
    cost += prices[1]
    for i in range(days[day], days[day] + 7):
        if i in paid.keys():
            paid[i] = True
    if all((p is True for p in paid.values())):
        return cost
    return bt(days, prices, paid, cost, day + 1)


def bt(days, prices, paid, cost, day):
    if all((p is True for p in paid.values())):  # if all the days are already paid for then return current cost
        return cost
    if day >= len(days):  # or if days exceeded the number of days present do the same
        return cost
    if not paid[days[day]]:
        return min(buyday(cost, paid.copy(), day), buyweek(cost, paid.copy(), day), buymonth(cost, paid.copy(), day))
    if paid[days[day]]:
        return bt(days, prices, paid, cost, day + 1)


days = [int(i) for i in input().split()]  # input days
prices = [int(i) for i in input().split()]  # input prices
paid = dict(zip(days, [False] * len(days)))  # creating a list with given number of days size
print(bt(days, prices, paid, cost=0, day=0))  # calling the recursion function initially for day 1
