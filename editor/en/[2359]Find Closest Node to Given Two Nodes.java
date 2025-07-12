// leetcode submit region begin(Prohibit modification and deletion)

class Solution {
  public int closestMeetingNode(int[] edges, int node1, int node2) {
    int n = edges.length;
    int[] dist1 = computeDistances(edges, node1, n);
    int[] dist2 = computeDistances(edges, node2, n);
    int answer = -1;
    int bestMaxDist = Integer.MAX_VALUE;

    for (int i = 0; i < n; i++) {
      int d1 = dist1[i];
      int d2 = dist2[i];

      if (d1 >= 0 && d2 >= 0) {
        int maxDist = Math.max(d1, d2);

        if (maxDist < bestMaxDist) {
          bestMaxDist = maxDist;
          answer = i;
        }
      }
    }

    return answer;
  }

  private int[] computeDistances(int[] edges, int start, int n) {
    int[] dist = new int[n];
    Arrays.fill(dist, -1);
    int distance = 0;
    int node = start;

    while (node != -1 && dist[node] == -1) {
      dist[node] = distance++;
      node = edges[node];
    }

    return dist;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
