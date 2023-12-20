347
        Top K Frequent Elements
        2022-12-09 17:07:00

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        for (int key : map.keySet()) {
            pq.add(new int[]{key, map.get(key)});
            if (pq.size() > k) {
                pq.poll();
            }
        }
        int[] arr = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            arr[i] = pq.poll()[0];
        }
        return arr;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
