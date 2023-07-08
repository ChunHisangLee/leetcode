
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public long putMarbles(int[] weights, int k) {
        int n = weights.length - 1;
        long[] arr = new long[n];
        long res = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = weights[i] + weights[i + 1];
        }
        for(long num:arr){
            System.out.print(num+"\t");
        }
        Arrays.sort(arr);
        for (int i = 0; i < k-1; i++) {
            res += arr[n - 1 - i] - arr[i];
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/*
- 38ms
class Solution {
    public long putMarbles(int[] weights, int k) {
        int n = weights.length - 1;
        long[] arr = new long[n];
        long res = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = weights[i] + weights[i + 1];
        }
        Arrays.sort(arr);
        for (int i = 0; i < k-1; i++) {
            res += arr[n - 1 - i] - arr[i];
        }
        return res;
    }
}

- 381ms
class Solution {
    public long putMarbles(int[] weights, int k) {
        int n = weights.length;
        if (k == 1 || k == n) {
            return 0;
        }
        PriorityQueue<Long> pqMax = new PriorityQueue<>();
        PriorityQueue<Long> pqMin = new PriorityQueue<Long>((a, b) -> {
            return Long.compare(b, a);
        });
        for (int i = 0; i < n - 1; i++) {
            long sum = (long) weights[i] + weights[i + 1];
            pqMin.add(sum);
            pqMax.add(sum);
            if (pqMin.size() == k) {
                pqMin.poll();
            }
            if (pqMax.size() == k) {
                pqMax.poll();
            }
        }
        long res = 0;
        while (!pqMin.isEmpty()) {
            res += pqMax.poll() - pqMin.poll();
        }
        return res;
    }
}
 */