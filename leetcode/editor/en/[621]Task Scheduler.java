621
        Task Scheduler
        2023-01-14 23:28:03

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] arr = new int[26];
        for (int task : tasks) {
            arr[task - 'A']++;
        }
        Arrays.sort(arr);
        int max = arr[25];
        int idleTime = (max - 1) * n;

        for (int i = arr.length - 2; i >= 0 && idleTime > 0; i--) {
            idleTime -= Math.min(max - 1, arr[i]);
        }
        idleTime = Math.max(0, idleTime);

        return idleTime + tasks.length;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
