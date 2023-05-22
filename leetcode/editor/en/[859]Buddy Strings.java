
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean buddyStrings(String s, String goal) {
        if (s.length() != goal.length() || s.length() < 2) {
            return false;
        }
        if (s.equals(goal)) {
            int[] arr = new int[26];
            for (char c : s.toCharArray()) {
                if (arr[c - 'a'] == 1) {
                    return true;
                } else {
                    arr[c - 'a'] = 1;
                }
            }
        }
        char[] c1 = s.toCharArray();
        char[] c2 = goal.toCharArray();
        int first = -1;
        int second = -1;
        for (int i = 0; i < c1.length; i++) {
            if (c1[i] != c2[i]) {
                if (first == -1) {
                    first = i;
                } else if (second == -1) {
                    second = i;
                    if (c1[first] != c2[second] || c1[second] != c2[first]) {
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
