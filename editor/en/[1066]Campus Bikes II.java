
//leetcode submit region begin(Prohibit modification and deletion)

import java.util.Arrays;

class Solution {
    private static final int MAX = Integer.MAX_VALUE;

    private int countSetBits(int mask) {
        return Integer.bitCount(mask);
    }

    private int computeDistance(int[] worker, int[] bike) {
        return Math.abs(worker[0] - bike[0]) + Math.abs(worker[1] - bike[1]);
    }

    private int computeMinimumDistance(int[][] workers, int[][] bikes, int[] memo) {
        int numOfBikes = bikes.length;
        int numOfWorkers = workers.length;
        int minDistanceSum = MAX;
        Arrays.fill(memo, MAX);
        memo[0] = 0;

        for (int mask = 0; mask < (1 << numOfBikes); mask++) {
            int nextWorker = countSetBits(mask);

            if (nextWorker >= numOfWorkers) {
                minDistanceSum = Math.min(minDistanceSum, memo[mask]);
                continue;
            }

            for (int bikeIndex = 0; bikeIndex < numOfBikes; bikeIndex++) {
                if ((mask & (1 << bikeIndex)) == 0) {
                    int newMask = mask | (1 << bikeIndex);
                    int newDistance = memo[mask] + computeDistance(workers[nextWorker], bikes[bikeIndex]);
                    memo[newMask] = Math.min(memo[newMask], newDistance);
                }
            }
        }

        return minDistanceSum;
    }

    public int assignBikes(int[][] workers, int[][] bikes) {
        int[] memo = new int[1 << bikes.length];
        return computeMinimumDistance(workers, bikes, memo);
    }
}

//leetcode submit region end(Prohibit modification and deletion)
