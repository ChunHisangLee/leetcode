// 1855
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxDistance(int[] nums1, int[] nums2) {
        int result = 0;
        for (int i = 0, j = i; i < nums1.length && j < nums2.length; i++) {
            while (j < nums2.length && nums2[j] >= nums1[i]) {
                j++;
            }
            result = Math.max(result, j - i - 1);
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
