
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxChunksToSorted(int[] arr) {
        int max = 0;
        int chunks = 0;

        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);

            if (max == i) {
                chunks++;
            }
        }

        return chunks;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
