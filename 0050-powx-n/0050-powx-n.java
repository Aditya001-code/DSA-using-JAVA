class Solution {
    public double myPow(double x, int n) {
        long N = n;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }

        double ans = 1.0;
        while (N > 0) {
            if (N % 2 == 1) {
                ans *= x;
            }
            x *= x;
            N /= 2;
        }

        return ans;
    }
}

/*
Algorithm: Binary Exponentiation (Iterative)
--------------------------------------------
1. Handle Edge Cases / Negative Exponents:
   - Convert 'n' to a 64-bit integer 'N' (long) to prevent overflow when n = -2^31 (since -Integer.MIN_VALUE overflows 32-bit int).
   - If N < 0, invert the base (x = 1 / x) and make N positive (N = -N).

2. Binary Exponentiation Loop:
   - Initialize ans = 1.0.
   - While N > 0:
     * If N is odd (N % 2 == 1), multiply ans by the current base x.
     * Square the base x (x = x * x).
     * Divide N by 2 (N /= 2).

3. Return ans.


Dry Run Example: x = 2.0, n = 10
--------------------------------
Initial State:
N = 10
x = 2.0
ans = 1.0

Iteration 1:
- Check: N = 10 > 0 (True)
- Is N odd? 10 % 2 == 0 (False) -> ans remains 1.0
- Square x: x = 2.0 * 2.0 = 4.0
- Halve N: N = 10 / 2 = 5

Iteration 2:
- Check: N = 5 > 0 (True)
- Is N odd? 5 % 2 == 1 (True) -> ans = 1.0 * 4.0 = 4.0
- Square x: x = 4.0 * 4.0 = 16.0
- Halve N: N = 5 / 2 = 2

Iteration 3:
- Check: N = 2 > 0 (True)
- Is N odd? 2 % 2 == 0 (False) -> ans remains 4.0
- Square x: x = 16.0 * 16.0 = 256.0
- Halve N: N = 2 / 2 = 1

Iteration 4:
- Check: N = 1 > 0 (True)
- Is N odd? 1 % 2 == 1 (True) -> ans = 4.0 * 256.0 = 1024.0
- Square x: x = 256.0 * 256.0 = 65536.0
- Halve N: N = 1 / 2 = 0

Loop Ends: N = 0
Return Value: 1024.0
*/