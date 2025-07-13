//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public long kthSmallestProduct(int[] nums1, int[] nums2, long k) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        long minProd = Long.MAX_VALUE;
        long maxProd = Long.MIN_VALUE;
        long[] candidates = new long[]{
                (long) nums1[0] * nums2[0],
                (long) nums1[0] * nums2[n2 - 1],
                (long) nums1[n1 - 1] * nums2[0],
                (long) nums1[n1 - 1] * nums2[n2 - 1]
        };
        for (long v : candidates) {
            minProd = Math.min(minProd, v);
            maxProd = Math.max(maxProd, v);
        }

        long left = minProd;
        long right = maxProd;
        while (left < right) {
            long mid = left + ((right - left) >> 1);
            long cnt = countLessEqual(nums1, nums2, mid);
            if (cnt >= k) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private long countLessEqual(int[] nums1, int[] nums2, long target) {
        long count = 0;
        int n2 = nums2.length;
        for (int x : nums1) {
            if (x == 0) {
                if (target >= 0) {
                    count += n2;
                }
            } else if (x > 0) {
                long t = target / x;
                if (target < 0 && target % x != 0) {
                    t -= 1;
                }
                int cntLe = upperBound(nums2, t);
                count += cntLe;
            } else {
                long t = target / x;
                if (target < 0 && x < 0 && target % x != 0) {
                    t += 1;
                }
                int idx = lowerBound(nums2, t);
                count += (n2 - idx);
            }
        }
        return count;
    }

    private int upperBound(int[] arr, long value) {
        int lo = 0, hi = arr.length;
        while (lo < hi) {
            int mid = lo + ((hi - lo) >> 1);
            if ((long) arr[mid] <= value) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }

    private int lowerBound(int[] arr, long value) {
        int lo = 0, hi = arr.length;
        while (lo < hi) {
            int mid = lo + ((hi - lo) >> 1);
            if ((long) arr[mid] < value) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
