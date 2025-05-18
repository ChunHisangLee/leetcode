// leetcode submit region begin(Prohibit modification and deletion)
public class Solution {
  private static final int MOD = 1_000_000_007;

  public int colorTheGrid(int m, int n) {
    List<int[]> states = new ArrayList<>();
    generateStates(m, new int[m], 0, states);
    int S = states.size();

    List<List<Integer>> adj = new ArrayList<>(S);
    for (int i = 0; i < S; i++) {
      adj.add(new ArrayList<>());
    }
    for (int i = 0; i < S; i++) {
      for (int j = 0; j < S; j++) {
        if (canStack(states.get(i), states.get(j), m)) {
          adj.get(i).add(j);
        }
      }
    }

    long[] dpPrev = new long[S];
    long[] dpCurr = new long[S];
    Arrays.fill(dpPrev, 1);

    for (int col = 2; col <= n; col++) {
      Arrays.fill(dpCurr, 0);
      for (int prev = 0; prev < S; prev++) {
        long ways = dpPrev[prev];
        if (ways == 0) continue;
        for (int next : adj.get(prev)) {
          dpCurr[next] = (dpCurr[next] + ways) % MOD;
        }
      }

      long[] tmp = dpPrev;
      dpPrev = dpCurr;
      dpCurr = tmp;
    }

    long ans = 0;
    for (long x : dpPrev) {
      ans = (ans + x) % MOD;
    }
    return (int) ans;
  }

  private void generateStates(int m, int[] arr, int pos, List<int[]> states) {
    if (pos == m) {
      states.add(arr.clone());
      return;
    }
    for (int c = 0; c < 3; c++) {
      if (pos > 0 && arr[pos - 1] == c) {
        continue;
      }
      arr[pos] = c;
      generateStates(m, arr, pos + 1, states);
    }
  }

  private boolean canStack(int[] a, int[] b, int m) {
    for (int i = 0; i < m; i++) {
      if (a[i] == b[i]) return false;
    }
    return true;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
