import java.util.PriorityQueue;332
        Reconstruct Itinerary
        2023-02-04 15:09:09

//leetcode submit region begin(Prohibit modification and deletion)
/*
還不會
 */
class Solution {
    Map<String, PriorityQueue<String>> map = new HashMap<>();
    LinkedList<String> list = new LinkedList<>();

    public List<String> findItinerary(List<List<String>> tickets) {
        for (List<String> ticket : tickets) {
            if (!map.containsKey(ticket.get(0))) {
                map.put(ticket.get(0), new PriorityQueue<>());
            }
            map.get(ticket.get(0)).add(ticket.get(1));
        }
        dfs("JFK");
        return list;
    }

    public void dfs(String departure) {
        PriorityQueue<String> pq = map.get(departure);
        while (pq != null && !pq.isEmpty()) {
            dfs(pq.poll());
        }
        list.addFirst(departure);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
