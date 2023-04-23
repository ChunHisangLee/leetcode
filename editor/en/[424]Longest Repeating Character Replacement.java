// 424
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int characterReplacement(String s, int k) {
        int[] count = new int[26];
        int left = 0;
        int right = 0;
        int max = 0;
        int len = s.length();
        char[] ch = s.toCharArray();
        while (right < len) {
            count[ch[right] - 'A']++;
            max = Math.max(max, count[ch[right] - 'A']);
            right++;
            if (right - left > k + max) {
                count[ch[left] - 'A']--;
                left++;
            }
        }
        return right - left;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
