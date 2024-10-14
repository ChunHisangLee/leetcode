
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private Map<Integer, List<Integer>> numToIndicesMap;
    private Random rand;

    public Solution(int[] nums) {
        numToIndicesMap = new HashMap<>();
        rand = new Random(42);

        for (int i = 0; i < nums.length; i++) {
            numToIndicesMap.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }
    }

    public int pick(int target) {
        List<Integer> indices = numToIndicesMap.get(target);

        if (indices == null || indices.isEmpty()) {
            throw new IllegalArgumentException("Target not found in the array.");
        }

        int randomIndex = rand.nextInt(indices.size());
        return indices.get(randomIndex);
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */
//leetcode submit region end(Prohibit modification and deletion)
