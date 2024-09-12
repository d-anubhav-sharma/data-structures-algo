import math

dc = {(0,0): 1, (1,0): 1, (1,1): 1}
MOD = 10**9 + 7

def get_or_find_ncr(m,n):
    if n==0 or n==m: return 1
    if (m,n) not in dc.keys():
        dc[(m,n)] = (get_or_find_ncr(m-1,n-1)+get_or_find_ncr(m-1,n))%MOD
    return dc[(m,n)]

for i in range(2,1000):
    for j in range(2,i):
        get_or_find_ncr(i,j)
        if a!=b: print("{}\t{}\t{}\t{}".format(i,j,a,b))
