
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numberOfWays(String corridor) {
        final int MOD = (int) 1e9 + 7;
        int a = 1;
        int b = 0;
        int c = 0;

        for (char ch : corridor.toCharArray()) {
            if (ch == 'S') {
                a = (a + c) % MOD;
                c = b;
                b = a;
                a = 0;
            } else {
                a = (a + c) % MOD;
            }
        }

        return c;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/*
Solution 1: Combination
Assume a[i] is the index of ith seat,
there are a[i+1] - a[i] ways to put a divider between ith and i+1th seats.
We only needs to calculate the produit of all these a[i+1] - a[i].

If the number of seat is odd or is less than 2, then no way to divide the corridor.

class Solution {
    public int numberOfWays(String corridor) {
        final long MOD = (long) 1e9 + 7;
        long result = 1;
        long j = 0;
        long k = 0;

        for (int i = 0; i < corridor.length(); i++) {
            if (corridor.charAt(i) == 'S') {
                if (++k > 2 && k % 2 == 1) {
                    result = result * (i - j) % MOD;
                }

                j = i;
            }
        }

        return k % 2 == 0 && k > 0 ? (int) result : 0;
    }
}

Solution 2: DP
a the number of 0 seat
b the number of 1 seat
c the number of 2 seats

class Solution {
    public int numberOfWays(String corridor) {
        final int MOD = (int) 1e9 + 7;
        int a = 1;
        int b = 0;
        int c = 0;

        for (char ch : corridor.toCharArray()) {
            if (ch == 'S') {
                a = (a + c) % MOD;
                c = b;
                b = a;
                a = 0;
            } else {
                a = (a + c) % MOD;
            }
        }

        return c;
    }
}
 */