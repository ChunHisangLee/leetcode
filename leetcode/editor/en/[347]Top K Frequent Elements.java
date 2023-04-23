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
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> map.get(a) == map.get(b) ? a - b : map.get(a) - map.get(b));
        for (int key : map.keySet()) {
            pq.add(key);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        int[] arr = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            arr[i] = pq.poll();
        }
        return arr;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
