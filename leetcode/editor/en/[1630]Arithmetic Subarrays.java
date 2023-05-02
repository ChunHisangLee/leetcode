
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> list = new ArrayList<>();
        int n = l.length;
        for (int i = 0; i < n; i++) {
            list.add(check(nums, l[i], r[i]));
        }
        return list;
    }

    public boolean check(int[] nums, int left, int right) {
        int n = right - left;
        if (n == 0) {
            return true;
        }
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = left; i <= right; i++) {
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[i]);
        }
        if ((max - min) % n != 0) {
            return false;
        }
        int diff = (max - min) / n;
        if (diff == 0) {
            return true;
        }
        boolean[] isCheck = new boolean[max - min + 1];
        for (int i = left; i <= right; i++) {
            int currDiff = nums[i] - min;
            if (isCheck[currDiff] || currDiff % diff != 0) {
                return false;
            }
            isCheck[currDiff] = true;
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/*
class Solution {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> list = new ArrayList<>();
        int n = l.length;
        for (int i = 0; i < n; i++) {
            int[] arr = Arrays.copyOfRange(nums, l[i], r[i] + 1);
            Arrays.sort(arr);
            int diff = arr[1] - arr[0];
            boolean isFalse = false;
            for (int k = 2; k < arr.length; k++) {
                if ((arr[k] - arr[k - 1]) != diff) {
                    list.add(false);
                    isFalse = true;
                    break;
                }
            }
            if (!isFalse) {
                list.add(true);
            }
        }
        return list;
    }
}
 */