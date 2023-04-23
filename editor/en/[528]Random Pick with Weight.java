// 528
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    Random random;
    int[] ranges;
    int bound;

    public Solution(int[] w) {
        random = new Random();
        int len = w.length;
        ranges = new int[len];
        ranges[0] = w[0] - 1;
        for (int i = 1; i < len; i++) {
            ranges[i] = ranges[i - 1] + w[i];
        }
        bound = ranges[len - 1] + 1;
    }

    public int pickIndex() {
        int rand = random.nextInt(bound);
        int left = 0;
        int right = ranges.length;
        while (left < right) {
            int mid = (left + right) >> 1;
            if (ranges[mid] >= rand)
                right = mid;
            else
                left = mid + 1;
        }
        return left;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */
//leetcode submit region end(Prohibit modification and deletion)
