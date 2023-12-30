
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] == b[1] ? b[0] - a[0] : a[1] - b[1]);

        for (int key : map.keySet()) {
            pq.offer(new int[]{key, map.get(key)});
        }

        int[] arr = new int[nums.length];
        int index = 0;

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int num = curr[0];
            int freq = curr[1];

            for (int i = 0; i < freq; i++) {
                arr[index++] = num;
            }
        }

        return arr;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
