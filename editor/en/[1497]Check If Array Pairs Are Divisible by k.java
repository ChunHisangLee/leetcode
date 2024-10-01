
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean canArrange(int[] arr, int k) {
        int[] count = new int[k];

        for (int num : arr) {
            int remainder = ((num % k) + k) % k;
            count[remainder]++;
        }

        if (count[0] % 2 != 0) {
            return false;
        }

        for (int i = 1; i <= k / 2; i++) {
            if (i == k - i) {
                if (count[i] % 2 != 0) {
                    return false;
                }
            } else {
                if (count[i] != count[k - i]) {
                    return false;
                }
            }
        }

        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
