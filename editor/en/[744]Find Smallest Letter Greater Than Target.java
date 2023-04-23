// 744
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        if (letters[letters.length - 1] <= target)
            return letters[0];
        int left = 0;
        int right = letters.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (letters[mid] <= target)
                left = mid + 1;
            else
                right = mid;
        }
        return letters[right];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
