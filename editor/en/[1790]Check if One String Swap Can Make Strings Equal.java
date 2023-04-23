
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        if (s1.length() != s2.length())
            return false;
        int count = 0;
        int index = -1;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                count++;
                if (index == -1)
                    index = i;
            }
            if (count == 2 && index != -1) {
                if (s1.charAt(index) != s2.charAt(i) || s1.charAt(i) != s2.charAt(index)) {
                    return false;
                }
                index = -1;
            }
            if (count > 2)
                return false;
        }
        return count == 1 ? false : true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
