
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean makeEqual(String[] words) {
        final int LETTERS = 26;
        int[] arr = new int[LETTERS];
        int n = words.length;

        for (String word : words) {
            for (char c : word.toCharArray()) {
                arr[c - 'a']++;
            }
        }

        for (int num : arr) {
            if (num % n != 0) {
                return false;
            }
        }

        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
