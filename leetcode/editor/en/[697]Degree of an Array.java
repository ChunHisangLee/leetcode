
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findShortestSubArray(int[] nums) {
        int n = nums.length;
        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        MinMax[] arr = new MinMax[max + 1];
        int freq = 0;
        for (int i = 0; i < n; i++) {
            if (arr[nums[i]] == null) {
                arr[nums[i]] = new MinMax(i);
            }
            arr[nums[i]].max = i;
            arr[nums[i]].count++;
            if (arr[nums[i]].count > freq) {
                freq = arr[nums[i]].count;
            }
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != null && arr[i].count == freq) {
                res = Math.min(res, arr[i].max - arr[i].min + 1);
            }
        }
        return res;
    }
}

class MinMax {
    int count = 0;
    int min;
    int max;

    public MinMax(int i) {
        min = i;
        max = i;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
