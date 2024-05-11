//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        return Arrays.asList(getList(nums2, nums1), getList(nums1, nums2));
    }

    private List<Integer> getList(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        for (int num : nums1) {
            set1.add(num);
        }

        for (int num : nums2) {
            if (!set1.contains(num)) {
                set2.add(num);
            }
        }

        return new ArrayList<>(set2);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
