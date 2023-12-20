443
        String Compression
        2023-03-02 09:58:19

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int compress(char[] chars) {
        int n = chars.length;
        int i = 0;
        int res = 0;
        while (i < n) {
            int len = 1;
            while (i + len < n && chars[i + len] == chars[i]) {
                len++;
            }
            chars[res] = chars[i];
            res++;
            if (len > 1) {
                for (char c : Integer.toString(len).toCharArray()) {
                    chars[res] = c;
                    res++;
                }
            }
            i += len;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
