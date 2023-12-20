

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    Map<String, Boolean> map = new HashMap<>();

    public boolean isScramble(String s1, String s2) {
        String key = s1 + s2;
        if (!map.containsKey(key)) {
            map.put(key, is(s1, s2));
        }
        return map.get(key);
    }

    private boolean is(String s1, String s2) {
        if (s1.equals(s2)) {
            return true;
        }
        int[] count = new int[26];
        int[] countF = new int[26];
        int[] countB = new int[26];
        for (int i = 0; i < s1.length() - 1; i++) {
            int j = s2.length() - 1 - i;
            count[s1.charAt(i) - 'a'] += 1;
            countF[s2.charAt(i) - 'a'] += 1;
            countB[s2.charAt(j) - 'a'] += 1;
            if (Arrays.equals(count, countF)) {
                if (isScramble(s1.substring(0, i + 1), s2.substring(0, i + 1)) && isScramble(s1.substring(i + 1), s2.substring(i + 1))) {
                    return true;
                }
            }
            if (Arrays.equals(count, countB)) {
                if (isScramble(s1.substring(0, i + 1), s2.substring(j)) && isScramble(s1.substring(i + 1), s2.substring(0, j))) {
                    return true;
                }
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
