1235
        Maximum Profit in Job Scheduling
        2022-11-26 10:54:56

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        Job[] jobs = new Job[n];
        for (int i = 0; i < n; i++) {
            jobs[i] = new Job(startTime[i], endTime[i], profit[i]);
        }
        Arrays.sort(jobs, (a, b) -> a.start - b.start);
        int[] dp = new int[n];
        dp[n - 1] = jobs[n - 1].profit;
        for (int i = n - 2; i >= 0; i--) {
            dp[i] = Math.max(dp[i + 1], jobs[i].profit);
            for (int j = i + 1; j < n; j++) {
                if (jobs[i].end <= jobs[j].start) {
                    dp[i] = Math.max(dp[i], dp[j] + jobs[i].profit);
                    break;
                }
            }
        }
        return dp[0];
    }
}

class Job {
    int start;
    int end;
    int profit;

    public Job(int start, int end, int profit) {
        this.start = start;
        this.end = end;
        this.profit = profit;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/*
https://leetcode.com/problems/maximum-profit-in-job-scheduling/solutions/1358899/maximum-profit-in-job-scheduling/

- 55ms
class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = profit.length;
        int[][] jobs = new int[n][3];
        for (int i = 0; i < n; i++) {
            jobs[i] = new int[]{startTime[i], endTime[i], profit[i]};
        }
        Arrays.sort(jobs, (a, b) -> a[1] - b[1]);
        TreeMap<Integer, Integer> dp = new TreeMap<>();
        dp.put(0, 0);
        for (int[] job : jobs) {
            int curr = dp.floorEntry(job[0]).getValue() + job[2];
            if (curr > dp.lastEntry().getValue()) {
                dp.put(job[1], curr);
            }
        }
        return dp.lastEntry().getValue();
    }
}
 */
