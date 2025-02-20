//leetcode submit region begin(Prohibit modification and deletion)
import java.util.*;

class Solution {
    public int[] leftmostBuildingQueries(int[] heights, int[][] queries) {
        int n = heights.length, qn = queries.length;
        List<int[]>[] que = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            que[i] = new ArrayList<>();
        }

        PriorityQueue<int[]> h = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        int[] res = new int[qn];
        Arrays.fill(res, -1);

        for (int qi = 0; qi < qn; qi++) {
            int ai = queries[qi][0], bi = queries[qi][1];

            if (ai < bi && heights[ai] < heights[bi]) {
                res[qi] = bi;
            } else if (ai > bi && heights[ai] > heights[bi]) {
                res[qi] = ai;
            } else if (ai == bi) {
                res[qi] = ai;
            } else {
                que[Math.max(ai, bi)].add(new int[]{Math.max(heights[ai], heights[bi]), qi});
            }
        }

        for (int i = 0; i < n; i++) {
            while (!h.isEmpty() && h.peek()[0] < heights[i]) {
                res[h.poll()[1]] = i;
            }

            for (int[] q : que[i]) {
                h.add(q);
            }
        }

        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
