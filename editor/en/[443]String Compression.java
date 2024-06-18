//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int compress(char[] chars) {
        int n = chars.length;
        int write = 0;
        int i = 0;

        while (i < n) {
            char curr = chars[i];
            int count = 0;

            while (i < n && chars[i] == curr) {
                i++;
                count++;
            }

            chars[write++] = curr;

            if (count > 1) {
                for (char c : String.valueOf(count).toCharArray()) {
                    chars[write++] = c;
                }
            }
        }

        return write;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
