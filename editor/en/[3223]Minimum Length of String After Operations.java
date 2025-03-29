
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minimumLength(String s) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        long totalRemovals = 0;
        for (int count : freq) {
            if (count >= 3) {
                long operations = (count - 1) / 2;
                totalRemovals += 2 * operations;
            }
        }

        return s.length() - (int) totalRemovals;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
