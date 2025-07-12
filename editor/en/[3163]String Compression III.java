
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String compressedString(String word) {
        StringBuilder comp = new StringBuilder();
        int i = 0;
        int n = word.length();

        while (i < n) {
            char c = word.charAt(i);
            int count = 1;

            while (i + count < n && word.charAt(i + count) == c && count < 9) {
                count++;
            }

            comp.append(count).append(c);
            i += count;
        }

        return comp.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
