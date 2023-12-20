692
        Top K Frequent Words
        2022-12-10 00:48:51

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        PriorityQueue<String> pq = new PriorityQueue<>((a, b) -> map.get(a) == map.get(b) ? b.compareTo(a) : map.get(a) - map.get(b));
        for (String key : map.keySet()) {
            pq.add(key);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        List<String> list = new ArrayList<>();
        while (!pq.isEmpty()) {
            list.add(0, pq.poll());
        }
        return list;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
