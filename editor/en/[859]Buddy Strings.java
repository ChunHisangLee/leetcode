
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean buddyStrings(String s, String goal) {
        if (s.length() != goal.length() || s.length() < 2) {
            return false;
        }
        if (s.equals(goal)) {
            int[] arr = new int[26];
            for (char c : s.toCharArray()) {
                arr[c - 'a']++;
                if (arr[c - 'a'] == 2) {
                    return true;
                }
            }
            return false;
        }
        char[] c = s.toCharArray();
        char[] g = goal.toCharArray();
        int first = -1;
        int second = -1;
        for (int i = 0; i < c.length; i++) {
            if (c[i] != g[i]) {
                if (first == -1) {
                    first = i;
                } else if (second == -1) {
                    second = i;
                    if (c[first] != g[second] || c[second] != g[first]) {
                        return false;
                    }
                } else {
                    return false;
                }
            }
        }
        return second != -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
