// leetcode submit region begin(Prohibit modification and deletion)
class Solution {
  public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
    int n = startTime.length;
    Job[] jobs = new Job[n];

    for (int i = 0; i < n; i++) {
      jobs[i] = new Job(startTime[i], endTime[i], profit[i]);
    }

    Arrays.sort(jobs, (a, b) -> Integer.compare(a.end, b.end));

    int[] ends = new int[n];
    for (int i = 0; i < n; i++) {
      ends[i] = jobs[i].end;
    }

    int[] dp = new int[n + 1];

    for (int i = 1; i <= n; i++) {
      int notTake = dp[i - 1];
      Job curr = jobs[i - 1];
      int j = findPrevIndex(ends, curr.start);
      int take = curr.profit + dp[j + 1];
      dp[i] = Math.max(notTake, take);
    }

    return dp[n];
  }

  private int findPrevIndex(int[] ends, int target) {
    int left = 0;
    int right = ends.length - 1;
    int answer = -1;

    while (left <= right) {
      int mid = left + (right - left) / 2;

      if (ends[mid] <= target) {
        answer = mid;
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }

    return answer;
  }
}

class Job {
  final int start;
  final int end;
  final int profit;

  Job(int s, int e, int p) {
    this.start = s;
    this.end = e;
    this.profit = p;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
