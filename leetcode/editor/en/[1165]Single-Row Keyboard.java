1165
        Single-Row Keyboard
        2022-12-01 10:00:58

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int calculateTime(String keyboard, String word) {
        int[] arr = new int[26];
        for (int i = 0; i < keyboard.length(); i++) {
            arr[keyboard.charAt(i) - 'a'] = i;
        }
        int count = 0;
        int prev = 0;
        for (char c : word.toCharArray()) {
            count += Math.abs(prev - arr[c - 'a']);
            prev = arr[c - 'a'];
        }
        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
