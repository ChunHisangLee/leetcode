
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int n = letters.length;
        if (letters[n - 1] <= target) {
            return letters[0];
        }
        int left = 0;
        int right = n - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (letters[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return letters[left];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
