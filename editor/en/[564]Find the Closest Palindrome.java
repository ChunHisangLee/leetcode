
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String nearestPalindromic(String n) {
        int len = n.length();
        long num = Long.parseLong(n);

        long power10LenMinus1 = 1;

        for (int i = 1; i < len; i++) {
            power10LenMinus1 *= 10;
        }

        long smaller = power10LenMinus1 - 1;
        long power10Len = power10LenMinus1 * 10;
        long larger = power10Len + 1;
        int halfLen = (len + 1) / 2;
        long prefix = Long.parseLong(n.substring(0, halfLen));
        long[] candidates = new long[]{
                smaller,
                larger,
                createPalindrome(prefix, len % 2 == 0),
                createPalindrome(prefix - 1, len % 2 == 0),
                createPalindrome(prefix + 1, len % 2 == 0)
        };

        long closest = -1;
        long minDiff = Long.MAX_VALUE;

        for (long candidate : candidates) {
            if (candidate == num) {
                continue;
            }

            long diff = Math.abs(candidate - num);

            if (diff < minDiff || (diff == minDiff && candidate < closest)) {
                minDiff = diff;
                closest = candidate;
            }
        }

        return String.valueOf(closest);
    }

    private long createPalindrome(long prefix, boolean isEvenLength) {
        StringBuilder sb = new StringBuilder();
        sb.append(prefix);
        String reversed = new StringBuilder(String.valueOf(prefix)).reverse().toString();

        if (!isEvenLength) {
            reversed = reversed.substring(1);
        }

        sb.append(reversed);
        return Long.parseLong(sb.toString());
    }
}
//leetcode submit region end(Prohibit modification and deletion)
