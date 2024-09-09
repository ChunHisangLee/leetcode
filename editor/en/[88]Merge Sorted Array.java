//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int last = m + n - 1;
        int first = m - 1;
        int second = n - 1;

        while (first >= 0 && second >= 0) {
            if (nums1[first] > nums2[second]) {
                nums1[last--] = nums1[first--];
            } else {
                nums1[last--] = nums2[second--];
            }
        }

        while (second >= 0) {
            nums1[last--] = nums2[second--];
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
