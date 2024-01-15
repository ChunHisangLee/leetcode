
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int calculateTime(String keyboard, String word) {
        final int LEN = 26;
        int[] arr = new int[LEN];

        for (int i = 0; i < LEN; i++) {
            arr[keyboard.charAt(i) - 'a'] = i;
        }

        int time = 0;
        int prevIndex = 0;

        for (char c : word.toCharArray()) {
            int currIndex = arr[c - 'a'];
            time += Math.abs(currIndex - prevIndex);
            prevIndex = currIndex;
        }

        return time;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
