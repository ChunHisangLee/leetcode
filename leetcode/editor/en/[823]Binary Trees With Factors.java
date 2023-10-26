
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numFactoredBinaryTrees(int[] arr) {
        long result = 0L;
        final long MOD = (long) 1e9 + 7;
        Map<Integer, Long> dp = new HashMap<>();

        Arrays.sort(arr);

        for (int i = 0; i < arr.length; i++) {
            dp.put(arr[i], 1L);

            for (int j = 0; j < i; j++) {
                if (arr[i] % arr[j] == 0) {
                    dp.put(arr[i], (dp.get(arr[i]) + dp.get(arr[j]) * dp.getOrDefault(arr[i] / arr[j], 0L)) % MOD);
                }
            }

            result = (result + dp.get(arr[i])) % MOD;
        }

        return (int) result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
