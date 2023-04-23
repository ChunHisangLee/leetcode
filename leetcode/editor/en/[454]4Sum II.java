454
        4Sum II
        2023-01-30 16:30:37

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        Arrays.sort(nums3);
        Arrays.sort(nums4);
        Map<Integer, Integer> map = new HashMap<>();
        for (int x : nums1) {
            for (int y : nums2) {
                map.compute((x + y), (k, v) -> v == null ? 1 : v + 1);
            }
        }
        int count = 0;
        for (int x : nums3) {
            for (int y : nums4) {
                count += map.getOrDefault(-(x + y), 0);
            }
        }
        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
