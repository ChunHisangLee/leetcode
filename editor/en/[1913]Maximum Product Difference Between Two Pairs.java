
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxProductDifference(int[] nums) {
        int[] max = getMax(nums);
        int[] min = getMin(nums);
        return compute(max, min);
    }

    private int[] getMax(int[] nums) {
        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;

        for (int num : nums) {
            if (num > first) {
                second = first;
                first = num;
            } else if (num > second) {
                second = num;
            }
        }

        return new int[]{first, second};
    }

    private int[] getMin(int[] nums) {
        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;

        for (int num : nums) {
            if (num < first) {
                second = first;
                first = num;
            } else if (num < second) {
                second = num;
            }
        }

        return new int[]{first, second};
    }

    private int compute(int[] max, int[] min) {
        return (max[0] * max[1]) - (min[0] * min[1]);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
