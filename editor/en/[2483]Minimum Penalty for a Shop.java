
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int bestClosingTime(String customers) {
        int currPenalty = 0;
        int minPenalty = 0;
        int minTime = 0;
        for (int i = 0; i < customers.length(); i++) {
            if (customers.charAt(i) == 'Y') {
                currPenalty--;
            } else {
                currPenalty++;
            }
            if (currPenalty < minPenalty) {
                minPenalty = currPenalty;
                minTime = i + 1;
            }
        }
        return minTime;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
