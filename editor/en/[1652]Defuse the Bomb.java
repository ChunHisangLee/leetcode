
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] decrypt(int[] code, int k) {
        int n = code.length;
        int[] result = new int[n];

        if (k == 0) {
            return result;
        }

        int determint = Math.abs(k);
        boolean isPositive = k > 0;

        for (int i = 0; i < n; i++) {
            int sum = 0;

            for (int j = 1; j <= determint; j++) {
                int index;

                if (isPositive) {
                    index = (i + j) % n;
                } else {
                    index = (i - j + n) % n;
                }

                sum += code[index];
            }

            result[i] = sum;
        }

        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
