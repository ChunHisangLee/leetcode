//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private Map<Character, List<Integer>> ringPositions;
    private Integer[][] memo;
    private String ring;
    private String key;
    private int n;

    public int findRotateSteps(String ring, String key) {
        this.ring = ring;
        this.key = key;
        this.n = ring.length();
        int m = key.length();
        this.memo = new Integer[m][n];
        this.ringPositions = new HashMap<>();

        for (int i = 0; i < n; i++) {
            char c = ring.charAt(i);
            ringPositions.computeIfAbsent(c, k -> new ArrayList<>()).add(i);
        }

        return findMinSteps(0, 0) + m;
    }

    private int findMinSteps(int keyIndex, int ringIndex) {
        if (keyIndex == key.length()) {
            return 0;
        }

        if (memo[keyIndex][ringIndex] != null) {
            return memo[keyIndex][ringIndex];
        }

        int minSteps = Integer.MAX_VALUE;
        char keyChar = key.charAt(keyIndex);

        for (int pos : ringPositions.get(keyChar)) {
            int diff = Math.abs(ringIndex - pos);
            int step = Math.min(diff, n - diff);
            int nextSteps = findMinSteps(keyIndex + 1, pos);
            minSteps = Math.min(minSteps, step + nextSteps);
        }

        memo[keyIndex][ringIndex] = minSteps;
        return minSteps;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
