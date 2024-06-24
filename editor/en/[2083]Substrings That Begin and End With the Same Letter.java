
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public long numberOfSubstrings(String s) {
        int[] count = new int[26];
        long result = 0;
        int n = s.length();

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            count[c - 'a']++;
            result += count[c - 'a'];
        }

        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
