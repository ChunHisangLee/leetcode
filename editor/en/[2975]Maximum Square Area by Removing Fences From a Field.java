

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private static final long MOD = (long) 1e9 + 7;

    public int maximizeSquareArea(int m, int n, int[] hFences, int[] vFences) {
        Arrays.sort(hFences);
        Arrays.sort(vFences);
        long max = 0;

        if (m == n) {
            max = m - 1;
        }

        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < hFences.length; i++) {
            for (int j = i + 1; j < hFences.length; j++) {
                set.add(hFences[j] - hFences[i]);
            }

            set.add(hFences[i] - 1);
            set.add(m - hFences[i]);
        }
        set.add(m - 1);

        for (int i = 0; i < vFences.length; i++) {
            for (int j = i + 1; j < vFences.length; j++) {
                if (set.contains(vFences[j] - vFences[i])) {
                    max = Math.max(max, vFences[j] - vFences[i]);
                }
            }

            if (set.contains(vFences[i] - 1)) {
                max = Math.max(max, vFences[i] - 1);
            }
            if (set.contains(n - vFences[i])) {
                max = Math.max(max, n - vFences[i]);
            }
        }
        if (set.contains(n - 1)) {
            max = Math.max(max, n - 1);
        }

        return (max == 0) ? -1 : (int) (max * max % MOD);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
