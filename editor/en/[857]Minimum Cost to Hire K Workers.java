
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        int n = quality.length;
        Worker[] workers = new Worker[n];

        for (int i = 0; i < n; i++) {
            workers[i] = new Worker(quality[i], wage[i]);
        }

        Arrays.sort(workers, (a, b) -> Double.compare(a.ratio, b.ratio));
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        long totalQuality = 0;
        double minWage = Double.MAX_VALUE;

        for (Worker worker : workers) {
            maxHeap.offer(worker.quality);
            totalQuality += worker.quality;

            if (maxHeap.size() > k) {
                totalQuality -= maxHeap.poll();
            }

            if (maxHeap.size() == k) {
                minWage = Math.min(minWage, totalQuality * worker.ratio);
            }
        }

        return minWage;
    }
}

class Worker {
    int quality;
    int wage;
    double ratio;

    public Worker(int quality, int wage) {
        this.quality = quality;
        this.wage = wage;
        this.ratio = (double) wage / quality;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
