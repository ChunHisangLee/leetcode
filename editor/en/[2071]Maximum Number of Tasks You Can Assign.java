//leetcode submit region begin(Prohibit modification and deletion)
public class Solution {
    public int maxTaskAssign(int[] tasks, int[] workers, int pills, int strength) {
        Arrays.sort(tasks);
        Arrays.sort(workers);
        int n = tasks.length, m = workers.length;

        int lo = 0, hi = Math.min(n, m), ans = 0;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (canAssign(tasks, workers, mid, pills, strength)) {
                ans = mid;
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return ans;
    }

    private boolean canAssign(int[] tasks, int[] workers, int k, int pills, int strength) {
        if (k == 0) return true;

        int m = workers.length;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = m - k; i < m; i++) {
            map.merge(workers[i], 1, Integer::sum);
        }

        for (int i = k - 1; i >= 0; i--) {
            int t = tasks[i];
            Integer w = map.lastKey();
            if (w >= t) {
                removeOne(map, w);
            } else {
                if (pills == 0) return false;
                Integer candidate = map.ceilingKey(t - strength);
                if (candidate == null) return false;
                removeOne(map, candidate);
                pills--;
            }
        }
        return true;
    }

    private void removeOne(TreeMap<Integer, Integer> map, int key) {
        int cnt = map.get(key);
        if (cnt == 1) map.remove(key);
        else map.put(key, cnt - 1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
