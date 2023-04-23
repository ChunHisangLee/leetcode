4
        Median of Two Sorted Arrays 2022-12-03 09:36:59

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[] arr = new int[m + n];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < m && j < n) {
            if (nums1[i] < nums2[j]) {
                arr[k++] = nums1[i++];
            } else {
                arr[k++] = nums2[j++];
            }
        }
        while (i < m) {
            arr[k++] = nums1[i++];
        }
        while (j < n) {
            arr[k++] = nums2[j++];
        }
        return (m + n) % 2 == 0 ? (arr[(m + n) / 2] + arr[(m + n) / 2 - 1]) / 2.0 : arr[(m + n) / 2];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
