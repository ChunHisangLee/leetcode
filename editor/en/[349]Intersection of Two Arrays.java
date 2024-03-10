//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = getSet(nums1);
        Set<Integer> set2 = getSet(nums2);
        set1.retainAll(set2);
        return convertSetToArray(set1);
    }

    private Set<Integer> getSet(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }

        return set;
    }

    private int[] convertSetToArray(Set<Integer> set) {
        int[] result = new int[set.size()];
        int index = 0;

        for (int num : set) {
            result[index++] = num;
        }

        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
