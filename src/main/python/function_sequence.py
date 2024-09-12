MOD=10**9

def solve(a, b, c, d, e, f, g, h, n):
    xarr = [0 for _ in range(n+1)]
    yarr = [0 for _ in range(n+1)]

    # Precompute powers to avoid recalculating every time
    d_powers = [d**i for i in range(n+1)]
    h_powers = [h**i for i in range(n+1)]

    for i in range(n+1):
        # Instead of calling get() multiple times, we check for valid indices once
        x_a = xarr[i-a] if i-a >= 0 else 1
        y_b = yarr[i-b] if i-b >= 0 else 1
        y_c = yarr[i-c] if i-c >= 0 else 1
        
        y_e = yarr[i-e] if i-e >= 0 else 1
        x_f = xarr[i-f] if i-f >= 0 else 1
        x_g = xarr[i-g] if i-g >= 0 else 1        
        xarr[i] = x_a + y_b + y_c + i * d_powers[i]
        yarr[i] = y_e + x_f + x_g + i * h_powers[i]

    return [xarr[n], yarr[n]]

print(solve(1, 2, 3, 2, 2, 1, 1, 4, 100))
