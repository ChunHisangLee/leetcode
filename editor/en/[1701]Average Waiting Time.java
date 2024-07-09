
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public double averageWaitingTime(int[][] customers) {
        int currentTime = 0;
        long totalWaitingTime = 0;

        for (int[] customer : customers) {
            int arrivalTime = customer[0];
            int preparationTime = customer[1];

            if (currentTime < arrivalTime) {
                currentTime = arrivalTime;
            }

            currentTime += preparationTime;
            totalWaitingTime += (currentTime - arrivalTime);
        }

        return (double) totalWaitingTime / customers.length;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
