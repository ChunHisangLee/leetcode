

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxDiff(int num) {
        String original = Integer.toString(num);
        String maxStr = buildMaxString(original);
        String minStr = buildMinString(original);
        int maxValue = Integer.parseInt(maxStr);
        int minValue = Integer.parseInt(minStr);
        return maxValue - minValue;
    }

    private String buildMaxString(String s) {
        char[] chars = s.toCharArray();
        char targetChar = 0;
        for (char c : chars) {
            if (c != '9') {
                targetChar = c;
                break;
            }
        }
        if (targetChar == 0) {
            return s;
        }
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == targetChar) {
                chars[i] = '9';
            }
        }
        return new String(chars);
    }

    private String buildMinString(String s) {
        char[] chars = s.toCharArray();
        char firstChar = chars[0];
        if (firstChar != '1') {
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] == firstChar) {
                    chars[i] = '1';
                }
            }
            return new String(chars);
        }
        char targetChar = 0;
        for (int i = 1; i < chars.length; i++) {
            char c = chars[i];
            if (c != '0' && c != '1') {
                targetChar = c;
                break;
            }
        }
        if (targetChar == 0) {
            return s;
        }
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == targetChar) {
                chars[i] = '0';
            }
        }
        return new String(chars);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
