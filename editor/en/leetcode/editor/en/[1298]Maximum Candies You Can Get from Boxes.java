// leetcode submit region begin(Prohibit modification and deletion)
public class Solution {
  public int maxCandies(
      int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {
    int n = status.length;
    boolean[] inPossession = new boolean[n];
    boolean[] visited = new boolean[n];
    boolean[] hasKey = new boolean[n];

    Queue<Integer> queue = new LinkedList<>();

    for (int box : initialBoxes) {
      if (!inPossession[box]) {
        inPossession[box] = true;
        queue.offer(box);
      }
      if (status[box] == 1) {
        hasKey[box] = true;
      }
    }

    int totalCandies = 0;
    while (!queue.isEmpty()) {
      int cur = queue.poll();
      if (visited[cur]) {
        continue;
      }
      if (!hasKey[cur]) {
        continue;
      }

      visited[cur] = true;
      totalCandies += candies[cur];

      for (int k : keys[cur]) {
        if (!hasKey[k]) {
          hasKey[k] = true;
          if (inPossession[k] && !visited[k]) {
            queue.offer(k);
          }
        }
      }

      for (int nextBox : containedBoxes[cur]) {
        if (!inPossession[nextBox]) {
          inPossession[nextBox] = true;
          if (status[nextBox] == 1) {
            hasKey[nextBox] = true;
          }
          queue.offer(nextBox);
        }
      }
    }

    return totalCandies;
  }
}

// leetcode submit region end(Prohibit modification and deletion)
