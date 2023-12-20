1796
        Second Largest Digit in a String
        2022-12-27 16:22:53

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int secondHighest(String s) {
        int first = -1;
        int second = -1;
        char[] chars = s.toCharArray();
        for (char ch : chars) {
            if (ch >= '0' && ch <= '9') {
                int digit = ch - '0';
                if (digit > first) {
                    second = first;
                    first = digit;
                } else if (digit > second && digit < first) {
                    second = digit;
                }
            }
        }
        return second;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
