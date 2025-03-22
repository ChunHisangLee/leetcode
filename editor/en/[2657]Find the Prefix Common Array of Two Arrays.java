
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        int[] C = new int[n];
        int[] counter = new int[n + 1];
        int count = 0;

        for (int i = 0; i < n; i++) {
            counter[A[i]]++;
            if (counter[A[i]] == 2) {
                count++;
            }

            counter[B[i]]++;
            if (counter[B[i]] == 2) {
                count++;
            }

            C[i] = count;
        }

        return C;
    }
}

//leetcode submit region end(Prohibit modification and deletion)
