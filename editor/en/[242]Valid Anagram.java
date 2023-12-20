242
Valid Anagram
        2023-01-01 22:43:23

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isAnagram(String s, String t) {
        int[] arr = new int[26];
        countLetters(s, arr, 1);
        countLetters(t, arr, -1);

        return checkEqual(arr);
    }

    private void countLetters(String str, int[] arr, int i) {
        for (char c : str.toCharArray()) {
            arr[c - 'a'] += i;
        }
    }

    private boolean checkEqual(int[] arr) {
        for (int num : arr) {
            if (num != 0) {
                return false;
            }
        }

        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
