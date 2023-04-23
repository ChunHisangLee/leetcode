// 205
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length())
            return false;
        int[] sIndex = new int[256];
        int[] tIndex = new int[256];
        for (int i = 1; i < s.length() + 1; i++) {
            if (sIndex[s.charAt(i - 1)] != tIndex[t.charAt(i - 1)])
                return false;
            sIndex[s.charAt(i - 1)] = i;
            tIndex[t.charAt(i - 1)] = i;
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
