//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int nthUglyNumber(int n) {
        int arr[] = new int[n];
        int i2 = 0;
        int i3 = 0;
        int i5 = 0;
        int nextMultipleOf2 = 2;
        int nextMultipleOf3 = 3;
        int nextMultipleOf5 = 5;
        int res = 1;
        arr[0] = 1;
        for (int i = 1; i < n; i++) {
            res = Math.min(nextMultipleOf2, Math.min(nextMultipleOf3, nextMultipleOf5));
            arr[i] = res;
            if (res == nextMultipleOf2)
                nextMultipleOf2 = arr[++i2] * 2;
            if (res == nextMultipleOf3)
                nextMultipleOf3 = arr[++i3] * 3;
            if (res == nextMultipleOf5)
                nextMultipleOf5 = arr[++i5] * 5;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
