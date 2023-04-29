621
        Task Scheduler
        2023-01-14 23:28:03

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] arr = new int[26];
        for (char task : tasks) {
            arr[task - 'A']++;
        }
        Arrays.sort(arr);
        int max = arr[25];
        int idle = (max - 1) * n;
        for (int i = arr.length - 2; i >= 0 && idle > 0; i--) {
            idle -= Math.min(max - 1, arr[i]);
        }
        idle = Math.max(idle, 0);
        return idle + tasks.length;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
