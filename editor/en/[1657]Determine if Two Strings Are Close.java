1657
        Determine if Two Strings Are Close
        2022-12-02 09:57:43

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length())
            return false;
        int[] word1Arr = new int[26];
        int[] word2Arr = new int[26];
        for (char c : word1.toCharArray()) {
            word1Arr[c - 'a']++;
        }
        for (char c : word2.toCharArray()) {
            word2Arr[c - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (word1Arr[i] == 0 && word2Arr[i] > 0 || word2Arr[i] == 0 && word1Arr[i] > 0)
                return false;
        }
        Arrays.sort(word1Arr);
        Arrays.sort(word2Arr);
        return Arrays.equals(word1Arr, word2Arr);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
