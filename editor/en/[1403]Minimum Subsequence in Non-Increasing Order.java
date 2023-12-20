
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> minSubsequence(int[] nums) {
        int n = nums.length;
        int sum = 0;
        int prefixSum = 0;
        List<Integer> list = new ArrayList<>();

        Arrays.sort(nums);

        for (int i = 0; i < n; i++) {
            prefixSum += nums[i];
        }

        while (sum <= prefixSum) {
            sum += nums[n - 1];
            prefixSum-=nums[n-1];
            list.add(nums[n - 1]);
            n--;
        }

        return list;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
