446
        Arithmetic Slices II-Subsequence
        2022-11-27 08:31:48

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        int count = 0;
        Map<Long, Integer>[] maps = new Map[n];

        for (int i = 0; i < n; i++) {
            maps[i] = new HashMap<>();

            for (int j = 0; j < i; j++) {
                long diff = (long) nums[i] - nums[j];
                int endAtJ = maps[j].getOrDefault(diff, 0);
                int endAtI = maps[i].getOrDefault(diff, 0);
                count += endAtJ;
                maps[i].put(diff, endAtI + endAtJ + 1);
            }
        }

        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
