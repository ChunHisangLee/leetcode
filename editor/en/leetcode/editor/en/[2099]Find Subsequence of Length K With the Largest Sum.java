
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        int[] sorted = Arrays.copyOf(nums, nums.length);
        Arrays.sort(sorted);

        Map<Integer, Integer> countMap = new HashMap<>(k * 2);
        for (int i = nums.length - 1; i >= nums.length - k; i--) {
            countMap.merge(sorted[i], 1, Integer::sum);
        }

        int[] result = new int[k];
        int idx = 0;
        for (int num : nums) {
            Integer cnt = countMap.get(num);
            if (cnt != null && cnt > 0) {
                result[idx++] = num;
                countMap.put(num, cnt - 1);
                if (idx == k) {
                    break;
                }
            }
        }

        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
