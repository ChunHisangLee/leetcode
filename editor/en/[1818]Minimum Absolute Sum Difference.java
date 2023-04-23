// 1818
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums1.length; i++) {
            min = Math.min(min, Math.min(nums1[i], nums2[i]));
            max = Math.max(max, Math.max(nums1[i], nums2[i]));
        }
        int[] less = new int[max - min + 1];
        int[] more = new int[max - min + 1];
        // set default value so it can be skipped for calculation
        less[0] = -max - 1;
        more[more.length - 1] = ((max + 1) << 1);
        for (int num : nums1) {
            less[num - min] = num;
            more[num - min] = num;
        }
        // because nums[i] > 1, if less or more is 0, which means it's not set yet, we can fill the nearest value
        // fill less from smaller to larger
        for (int i = 1; i < less.length; i++) {
            if (less[i] == 0) {
                less[i] = less[i - 1];
            }
        }
        // fill more from larger to smaller
        for (int i = more.length - 2; i >= 0; i--) {
            if (more[i] == 0) {
                more[i] = more[i + 1];
            }
        }
        int total = 0;
        int preSave = 0;
        for (int i = 0; i < nums1.length; i++) {
            int current = Math.abs(nums1[i] - nums2[i]);
            total += current;
            int save = current - Math.min(Math.abs(less[nums2[i] - min] - nums2[i]), Math.abs(more[nums2[i] - min] - nums2[i]));
            if (save > preSave) {
                total = total + preSave - save;
                preSave = save;
            }
            total = total % 1_000_000_007;
        }
        return total;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/*
public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
    int mod = (int)1e9 + 7;
    long res = 0;
    int maxIdx = -1, maxDiff = Integer.MIN_VALUE;
    for(int i = 0; i < nums1.length; i++) {
        int diff = Math.abs(nums1[i] - nums2[i]);
        res = (res + diff) % mod;
        if(diff > maxDiff) {
            maxDiff = diff;
            maxIdx = i;
        }
    }

    int ded = maxDiff;
    for(int num : nums1) {
        ded = Math.min(ded, Math.abs(num - nums2[maxIdx]));
    }

    res = res- (maxDiff - ded);
    return (int)res;
}
 */