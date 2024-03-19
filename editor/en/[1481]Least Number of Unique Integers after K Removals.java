//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        Queue<Integer> heap = new PriorityQueue<>((a, b) -> map.get(a) - map.get(b));
        heap.addAll(map.keySet());

        while (k > 0) {
            k -= map.get(heap.poll());
        }

        return k < 0 ? heap.size() + 1 : heap.size();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
