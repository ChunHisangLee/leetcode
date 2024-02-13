// leetcode submit region begin(Prohibit modification and deletion)
class Solution {
  public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    int m = nums1.length;
    int n = nums2.length;
    double result = 0;
    List<Integer> list = new ArrayList<>();

    for (int num : nums1) {
      list.add(num);
    }

    for (int num : nums2) {
      list.add(num);
    }

    Collections.sort(list);

    if (list.size() % 2 == 0) {
      result = (list.get((m + n) / 2 - 1) + list.get((m + n) / 2)) / 2.0;
    } else {
      result = list.get((m + n) / 2);
    }

    return result;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
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
