642
Design Search Autocomplete System
2023-03-08 11:51:10
//leetcode submit region begin(Prohibit modification and deletion)
class Node {
    Map<String, Integer> freq = new HashMap<>();
    Map<Character, Node> children = new HashMap<>();
}

class AutocompleteSystem {
    Node root = new Node();
    String prefix = "";

    public void add(String s, Integer time) {
        Node node = root;
        for (char c : s.toCharArray()) {
            if (!node.children.containsKey(c)) {
                node.children.put(c, new Node());
            }
            node = node.children.get(c);
            node.freq.put(s, node.freq.getOrDefault(s, 0) + time);
        }
    }

    public AutocompleteSystem(String[] sentences, int[] times) {
        for (int i = 0; i < sentences.length; i++) {
            add(sentences[i], times[i]);
        }
    }

    public List<String> input(char ch) {
        if (ch == '#') {
            add(prefix, 1);
            prefix = "";
            return new ArrayList<>();
        }
        prefix += ch;
        Node node = root;
        for (char c : prefix.toCharArray()) {
            if (!node.children.containsKey(c)) {
                return new ArrayList<>();
            }
            node = node.children.get(c);
        }
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>((a, b) -> a.getValue() == b.getValue() ? b.getKey().compareTo(a.getKey()) : a.getValue() - b.getValue());
        for (Map.Entry<String, Integer> entry : node.freq.entrySet()) {
            pq.add(entry);
            if (pq.size() > 3) {
                pq.poll();
            }
        }
        List<String> list = new ArrayList<>();
        while (!pq.isEmpty()) {
            list.add(0, pq.poll().getKey());
        }
        return list;
    }
}

/**
 * Your AutocompleteSystem object will be instantiated and called as such:
 * AutocompleteSystem obj = new AutocompleteSystem(sentences, times);
 * List<String> param_1 = obj.input(c);
 */
//leetcode submit region end(Prohibit modification and deletion)
