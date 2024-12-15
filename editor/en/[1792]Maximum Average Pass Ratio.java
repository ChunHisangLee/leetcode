
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<ClassInfo> maxHeap = new PriorityQueue<>((a, b) -> Double.compare(b.getGain(), a.getGain()));

        for (int[] cls : classes) {
            int passed = cls[0];
            int total = cls[1];

            ClassInfo classInfo = new ClassInfo(passed, total);
            maxHeap.offer(classInfo);
        }

        for (int i = 0; i < extraStudents; i++) {
            ClassInfo bestClass = maxHeap.poll();
            if (bestClass == null) break; // Just in case, though it shouldn't happen

            bestClass.passed += 1;
            bestClass.total += 1;

            maxHeap.offer(bestClass);
        }

        double sum = 0.0;
        while (!maxHeap.isEmpty()) {
            ClassInfo cls = maxHeap.poll();
            sum += (double)cls.passed / cls.total;
        }

        return sum / classes.length;
    }

    static class ClassInfo {
        int passed;
        int total;

        public ClassInfo(int passed, int total) {
            this.passed = passed;
            this.total = total;
        }

        public double getGain() {
            return (double)(passed + 1) / (total + 1) - (double)passed / total;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
