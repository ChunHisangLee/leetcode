2068
        Check Whether Two Strings are Almost Equivalent
        2023-03-03 17:52:15

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean checkAlmostEquivalent(String word1, String word2) {
        int[] arr = new int[26];
        char[] c1 = word1.toCharArray();
        char[] c2 = word2.toCharArray();
        for (int i = 0; i < word1.length(); i++) {
            arr[c1[i] - 'a']++;
            arr[c2[i] - 'a']--;
        }
        for (int num : arr) {
            if (num > 3 || num < -3) {
                return false;
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
