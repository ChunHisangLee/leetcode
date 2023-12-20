
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numFactoredBinaryTrees(int[] arr) {
        long result = 1L;
        final long MOD = (long) 1e9 + 7;
        Map<Integer, Long> dp = new HashMap<>();

        Arrays.sort(arr);
        dp.put(arr[0], result);

        for (int i = 1; i < arr.length; i++) {
            long sum = 1;

            for (int j = 0; j < i; j++) {
                if (arr[i] % arr[j] == 0 && dp.containsKey(arr[i] / arr[j])) {
                    sum = (sum + dp.get(arr[i] / arr[j]) * dp.get(arr[j])) % MOD;
                }
            }
            dp.put(arr[i], sum);
            result = (result + sum) % MOD;
        }

        return (int) result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
