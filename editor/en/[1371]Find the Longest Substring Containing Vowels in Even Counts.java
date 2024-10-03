
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private static final int[] VOWEL_MASK = new int[128];

    static {
        VOWEL_MASK['a'] = 1;
        VOWEL_MASK['e'] = 2;
        VOWEL_MASK['i'] = 4;
        VOWEL_MASK['o'] = 8;
        VOWEL_MASK['u'] = 16;
    }

    public int findTheLongestSubstring(String s) {
        int[] firstOccurrence = new int[32];
        Arrays.fill(firstOccurrence, -1);
        firstOccurrence[0] = 0;
        int maxLength = 0;
        int mask = 0;
        int n = s.length();

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);

            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                mask ^= VOWEL_MASK[c];
            }

            if (firstOccurrence[mask] != -1) {
                maxLength = Math.max(maxLength, i + 1 - firstOccurrence[mask]);
            } else {
                firstOccurrence[mask] = i + 1;
            }
        }

        return maxLength;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
