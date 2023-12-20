1088
        Confusing Number II
        2023-01-02 09:18:07

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    final char[] digits = new char[]{'0', '1', '6', '8', '9'};

    public int confusingNumberII(int n) {
        return dfs(String.valueOf(n), false, new StringBuilder());
    }

    private int dfs(String s, boolean smaller, StringBuilder num) {
        if (num.length() == s.length()) {
            int zeros = 0;
            while (zeros < num.length() && num.charAt(zeros) == '0') {
                zeros++;
            }
            final String temp = num.substring(zeros);
            for (int i = 0, j = temp.length() - 1; i <= j; i++, j--) {
                if (temp.charAt(i) != other(temp.charAt(j))) {
                    return 1;
                }
            }
            return 0;
        }
        int ans = 0;
        for (char c : digits) {
            if (!smaller && c > s.charAt(num.length())) {
                break;
            }
            num.append(c);
            ans += dfs(s, smaller || c < s.charAt(num.length() - 1), num);
            num.setLength(num.length() - 1);
        }
        return ans;
    }

    private char other(char c) {
        switch (c) {
            case '0':
            case '1':
            case '8':
                return c;
            case '6':
                return '9';
            case '9':
                return '6';
            default:
                return '?';
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
