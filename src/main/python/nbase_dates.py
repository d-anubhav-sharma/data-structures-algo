def add_date_to_map(date, date_map):
    base = date[0]
    if(base==1): return
    value = date[1]
    base10value = 0
    place = 0
    while value>0:
        digit = value%10
        if(digit>=base): return
        base10value += digit*(base**place)
        place+=1
        value/=10
    date_map[base10value] = 1 if base10value not in date_map.keys() else date_map[base10value]+1

def solve(dates):
    date_map = {}
    for date in dates:
        add_date_to_map(date, date_map)
    sum = 0
    for x in date_map.values():
          if x>1:
                sum+=(x*(x-1))/2
    return sum

