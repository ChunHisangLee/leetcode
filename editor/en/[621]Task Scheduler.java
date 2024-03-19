//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] arr = new int[26];

        for (char task : tasks) {
            arr[task - 'A']++;
        }

        int maxFreq = 0;

        for (int freq : arr) {
            maxFreq = Math.max(maxFreq, freq);
        }

        int maxCount = 0;

        for (int freq : arr) {
            if (freq == maxFreq) {
                maxCount++;
            }
        }

        int emptySlots = (maxFreq - 1) * (n - maxCount + 1);
        int availableTasks = tasks.length - maxFreq * maxCount;
        int idleSlots = Math.max(0, emptySlots - availableTasks);
        return tasks.length + idleSlots;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
