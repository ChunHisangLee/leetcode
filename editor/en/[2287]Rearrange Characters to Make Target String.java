
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int rearrangeCharacters(String s, String target) {
        int[] countS = new int[26];
        int[] countT = new int[26];
        int count = Integer.MAX_VALUE;

        for (char c : s.toCharArray()) {
            countS[c - 'a']++;
        }

        for (char c : target.toCharArray()) {
            countT[c - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (countT[i] > 0) {
                count = Math.min(count, countS[i] / countT[i]);
            }
        }

        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
