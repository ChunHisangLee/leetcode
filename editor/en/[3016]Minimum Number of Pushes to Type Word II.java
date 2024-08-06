//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minimumPushes(String word) {
        int[] arr = new int[26];

        for (char c : word.toCharArray()) {
            arr[c - 'a']++;
        }

        Arrays.sort(arr);
        int total = 0;
        int count = 1;
        int processed = 0;

        for (int i = 25; i >= 0 && arr[i] > 0; i--) {
            total += count * arr[i];
            processed++;

            if (processed % 8 == 0) {
                count++;
            }
        }

        return total;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
