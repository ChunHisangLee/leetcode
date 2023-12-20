
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String largestGoodInteger(String num) {
        int max = -1;
        StringBuilder sb = new StringBuilder();
        char[] charsNum = num.toCharArray();

        for (int i = 0; i < num.length() - 2; i++) {
            if (charsNum[i] == charsNum[i + 1] && charsNum[i + 1] == charsNum[i + 2]) {
                max = Math.max(max, charsNum[i] - '0');
            }
        }

        if (max != -1) {
            for (int i = 0; i < 3; i++) {
                sb.append(String.valueOf(max));
            }
        }

        return sb.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/*
class Solution {
    public String largestGoodInteger(String num) {
        int max = Integer.MIN_VALUE;
        StringBuilder sb = new StringBuilder();
        char[] charsNum = num.toCharArray();

        for (int i = 0; i < num.length() - 2; i++) {
            if (charsNum[i] == charsNum[i + 1] && charsNum[i + 1] == charsNum[i + 2]) {
                int sum = Integer.valueOf(charsNum[i] * 100 + charsNum[i + 1] * 10 + charsNum[i + 2]);

                if (sum > max) {
                    sb.setLength(0);
                    max = sum;
                    sb.append(charsNum[i + 2]).append(charsNum[i + 1]).append(charsNum[i]);
                }
            }
        }

        return sb.toString();
    }
}
 */