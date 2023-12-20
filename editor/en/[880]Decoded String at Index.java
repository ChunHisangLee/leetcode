
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String decodeAtIndex(String s, int k) {
        long size = 0;

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                size *= c - '0';
            } else {
                size++;
            }
        }

        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            k %= size;

            if (Character.isDigit(c)) {
                size /= c - '0';
            } else {
                if (k == 0 || k == size) {
                    return String.valueOf(c);
                }

                size--;
            }
        }

        return "";
    }
}
//leetcode submit region end(Prohibit modification and deletion)
