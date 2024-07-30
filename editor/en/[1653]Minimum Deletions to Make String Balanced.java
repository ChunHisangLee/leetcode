
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minimumDeletions(String s) {
        int count = 0;
        int result = 0;

        for (char c : s.toCharArray()) {
            if (c == 'b') {
                count++;
            } else if (count != 0) {
                result++;
                count--;
            }
        }

        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
