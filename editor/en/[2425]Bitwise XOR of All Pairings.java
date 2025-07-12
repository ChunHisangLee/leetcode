
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int xorAllNums(int[] nums1, int[] nums2) {
        int xorA = 0;
        for (int num : nums1) {
            xorA ^= num;
        }

        int xorB = 0;
        for (int num : nums2) {
            xorB ^= num;
        }

        int n1 = nums1.length;
        int n2 = nums2.length;

        if ((n2 & 1) == 0) {
            if ((n1 & 1) == 1) {
                return xorB;
            } else {
                return 0;
            }
        } else {
            if ((n1 & 1) == 1) {
                return xorA ^ xorB;
            } else {
                return xorA;
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
