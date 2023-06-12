
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean canPermutePalindrome(String s) {
        boolean isSingle = false;
        int[] arr = new int[26];
        for (char c : s.toCharArray()) {
            arr[c - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (arr[i] % 2 != 0) {
                if (isSingle) {
                    return false;
                } else {
                    isSingle = true;
                }
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
