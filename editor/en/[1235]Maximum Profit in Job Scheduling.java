
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        Job[] jobs = new Job[n];

        for (int i = 0; i < n; i++) {
            jobs[i] = new Job(startTime[i], endTime[i], profit[i]);
        }

        Arrays.sort(jobs, (a, b) -> a.end - b.end);
        int[] dp = new int[n];
        dp[0] = jobs[0].profit;

        for (int i = 1; i < n; i++) {
            int includedProfit = jobs[i].profit;
            int index = binarySearch(jobs, i);

            if (index != -1) {
                includedProfit += dp[index];
            }

            dp[i] = Math.max(dp[i - 1], includedProfit);
        }

        return dp[n - 1];
    }

    private int binarySearch(Job[] jobs, int index) {
        int left = 0;
        int right = jobs.length - 1;

        while (left <= right) {
            int mid = (left + right) >> 1;

            if (jobs[mid].end <= jobs[index].start) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return right;
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
