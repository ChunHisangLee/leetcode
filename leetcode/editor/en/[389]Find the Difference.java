//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public char findTheDifference(String s, String t) {
        int[] arr = new int[26];

        for (char c : t.toCharArray()) {
            arr[c - 'a']++;
        }

        for (char c : s.toCharArray()) {
            arr[c - 'a']--;
        }

        for (int i = 0; i < 26; i++) {
            if (arr[i] != 0) {
                return (char) (i + 'a');
            }
        }

        return '0';
    }
}
//leetcode submit region end(Prohibit modification and deletion)
