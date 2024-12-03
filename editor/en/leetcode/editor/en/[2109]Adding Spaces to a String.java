
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String addSpaces(String s, int[] spaces) {
        StringBuilder sb = new StringBuilder();
        int spaceIdx = 0;
        int n = s.length();
        int spaceLen = spaces.length;

        for (int i = 0; i < n; i++) {
            if (spaceIdx < spaceLen && spaces[spaceIdx] == i) {
                sb.append(' ');
                spaceIdx++;
            }

            sb.append(s.charAt(i));
        }

        return sb.toString();
    }
}

//leetcode submit region end(Prohibit modification and deletion)
