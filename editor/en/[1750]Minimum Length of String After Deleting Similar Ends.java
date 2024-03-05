//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minimumLength(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right && s.charAt(left) == s.charAt(right)) {
            char currChar = s.charAt(left);

            while (left <= right && s.charAt(left) == currChar) {
                left++;
            }

            while (left <= right && s.charAt(right) == currChar) {
                right--;
            }
        }

        return right - left + 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
