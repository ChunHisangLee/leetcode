
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String reorganizeString(String S) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : S.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        PriorityQueue<Character> pq = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));
        pq.addAll(map.keySet());
        StringBuilder sb = new StringBuilder();
        while (pq.size() > 1) {
            char first = pq.poll();
            char second = pq.poll();
            sb.append(first);
            sb.append(second);
            map.put(first, map.get(first) - 1);
            map.put(second, map.get(second) - 1);
            if (map.get(first) > 0) {
                pq.add(first);
            }
            if (map.get(second) > 0) {
                pq.add(second);
            }
        }
        if (!pq.isEmpty()) {
            if (map.get(pq.peek()) > 1) {
                return "";
            } else {
                sb.append(pq.poll());
            }
        }
        return sb.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
