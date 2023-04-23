1066
        Campus Bikes II
        2022-12-15 09:25:53

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int memo[] = new int[1024];

    private int countNumOfOnes(int mask) {
        int count = 0;
        while (mask != 0) {
            mask &= (mask - 1);
            count++;
        }
        return count;
    }

    private int findDistance(int[] worker, int[] bike) {
        return Math.abs(worker[0] - bike[0]) + Math.abs(worker[1] - bike[1]);
    }

    private int minimumDistanceSum(int[][] workers, int[][] bikes) {
        int numOfBikes = bikes.length;
        int numOfWorkers = workers.length;
        int smallestDistanceSum = Integer.MAX_VALUE;
        memo[0] = 0;
        for (int mask = 0; mask < (1 << numOfBikes); mask++) {
            int nextWorkerIndex = countNumOfOnes(mask);
            if (nextWorkerIndex >= numOfWorkers) {
                smallestDistanceSum = Math.min(smallestDistanceSum, memo[mask]);
                continue;
            }
            for (int bikeIndex = 0; bikeIndex < numOfBikes; bikeIndex++) {
                if ((mask & (1 << bikeIndex)) == 0) {
                    int newMask = (1 << bikeIndex) | mask;
                    memo[newMask] = Math.min(memo[newMask], memo[mask] + findDistance(workers[nextWorkerIndex], bikes[bikeIndex]));
                }
            }
        }
        return smallestDistanceSum;
    }

    public int assignBikes(int[][] workers, int[][] bikes) {
        Arrays.fill(memo, Integer.MAX_VALUE);
        return minimumDistanceSum(workers, bikes);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
