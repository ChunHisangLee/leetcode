
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String[] findRelativeRanks(int[] score) {
        final String FIRST = "Gold Medal";
        final String SECOND = "Silver Medal";
        final String THIRD = "Bronze Medal";
        int n = score.length;
        Integer[] indexArray = new Integer[n];

        for (int i = 0; i < n; i++) {
            indexArray[i] = i;
        }

        Arrays.sort(indexArray, (a, b) -> Integer.compare(score[b], score[a]));
        String[] ranks = new String[n];

        for (int i = 0; i < n; i++) {
            if (i == 0) {
                ranks[indexArray[i]] = FIRST;
            } else if (i == 1) {
                ranks[indexArray[i]] = SECOND;
            } else if (i == 2) {
                ranks[indexArray[i]] = THIRD;
            } else {
                ranks[indexArray[i]] = String.valueOf(i + 1);
            }
        }

        return ranks;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
