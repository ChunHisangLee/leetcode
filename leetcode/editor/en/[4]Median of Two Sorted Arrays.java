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
        return (m + n) % 2 == 0 ? (arr[(m + n) / 2 - 1] + arr[(m + n) / 2]) / 2.0 : arr[(m + n) / 2];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/*
-- 7ms
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        List<Integer> list = new ArrayList<>();
        for (int num : nums1) {
            list.add(num);
        }
        for (int num : nums2) {
            list.add(num);
        }
        Collections.sort(list);
        return list.size() % 2 == 0 ? (list.get((m + n) / 2 - 1) + list.get((m + n) / 2)) / 2.0 : list.get((m + n) / 2);
    }
}

-- 3ms
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        List<Integer> list = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i < m && j < n) {
            if (nums1[i] < nums2[j]) {
                list.add(nums1[i++]);
            } else {
                list.add(nums2[j++]);
            }
        }
        while (i < m) {
            list.add(nums1[i++]);
        }
        while ((j < n)) {
            list.add(nums2[j++]);
        }
        return list.size() % 2 == 0 ? (list.get((m + n) / 2 - 1) + list.get((m + n) / 2)) / 2.0 : list.get((m + n) / 2);
    }
}
 */