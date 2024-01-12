
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maximumSetSize(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        Set<Integer> set = new HashSet<>();
        int n = nums1.length;
        int count = 0;

        for (int num : nums1) {
            set1.add(num);
            set.add(num);
        }

        for (int num : nums2) {
            set2.add(num);
            set.add(num);
        }

        count += set1.size() > n / 2 ? n / 2 : set1.size();
        count += set2.size() > n / 2 ? n / 2 : set2.size();
        return set.size() > count ? count : set.size();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
