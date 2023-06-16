
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int left = 0;
        int right = letters.length - 1;
        if (letters[right] <= target) {
            return letters[left];
        }
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (letters[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return letters[left];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
