
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        List<List<Integer>> adj = new ArrayList<>();

        for(int i=0; i<n; i++) {
            adj.add(new ArrayList<>());
        }

        for(int i=0; i<n-1; i++) {
            adj.get(i).add(i+1);
        }

        int[] d = new int[n];

        for(int i=0; i<n; i++) {
            d[i] = i;
        }

        int qLen = queries.length;
        int[] answer = new int[qLen];

        for(int q=0; q<qLen; q++) {
            int u = queries[q][0];
            int v = queries[q][1];
            adj.get(u).add(v);

            if(d[u] + 1 < d[v]) {
                d[v] = d[u] + 1;
                Queue<Integer> queue = new LinkedList<>();
                queue.offer(v);

                while(!queue.isEmpty()) {
                    int current = queue.poll();

                    for(int neighbor : adj.get(current)) {
                        if(d[current] + 1 < d[neighbor]) {
                            d[neighbor] = d[current] + 1;
                            queue.offer(neighbor);
                        }
                    }
                }
            }

            answer[q] = d[n-1];
        }

        return answer;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
