
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String[] divideString(String s, int k, char fill) {
        StringBuilder sb = new StringBuilder(s);
        while (sb.length() % k != 0) {
            sb.append(fill);
        }

        int groupCount = sb.length() / k;
        String[] result = new String[groupCount];
        for (int i = 0; i < groupCount; i++) {
            result[i] = sb.substring(i * k, (i + 1) * k);
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
