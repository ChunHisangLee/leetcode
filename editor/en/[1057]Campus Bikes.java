
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] assignBikes(int[][] workers, int[][] bikes) {
        int n = workers.length;
        int m = bikes.length;
        int[] result = new int[n];
        boolean[] workerAssigned = new boolean[n];
        boolean[] bikeAssigned = new boolean[m];

        List<int[]>[] list = new List[2001];

        for (int i = 0; i < 2001; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int dist = Math.abs(workers[i][0] - bikes[j][0]) + Math.abs(workers[i][1] - bikes[j][1]);
                list[dist].add(new int[]{i, j});
            }
        }

        for (List<int[]> pairs : list) {
            for (int[] pair : pairs) {
                int workerIndex = pair[0];
                int bikeIndex = pair[1];

                if (!workerAssigned[workerIndex] && !bikeAssigned[bikeIndex]) {
                    result[workerIndex] = bikeIndex;
                    workerAssigned[workerIndex] = true;
                    bikeAssigned[bikeIndex] = true;
                }
            }
        }

        return result;
    }
}


//leetcode submit region end(Prohibit modification and deletion)
/*
class Solution {
    public int[] assignBikes(int[][] workers, int[][] bikes) {
        int w = workers.length;
        int b = bikes.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            if (o1[0] != o2[0]) {
                return o1[0] - o2[0];
            }

            if (o1[1] != o2[1]) {
                return o1[1] - o2[1];
            }

            return o1[2] - o2[2];
        });

        for (int i = 0; i < w; i++) {
            int[] worker = workers[i];

            for (int j = 0; j < b; j++) {
                int[] bike = bikes[j];
                int dist = Math.abs(worker[0] - bike[0]) + Math.abs(worker[1] - bike[1]);
                pq.offer(new int[]{dist, i, j});
            }
        }

        int[] result = new int[w];
        boolean[] workerAssigned = new boolean[w];
        boolean[] bikeAssigned = new boolean[b];

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();

            if (!workerAssigned[curr[1]] && !bikeAssigned[curr[2]]) {
                result[curr[1]] = curr[2];
                workerAssigned[curr[1]] = true;
                bikeAssigned[curr[2]] = true;
            }
        }

        return result;
    }
}
 */