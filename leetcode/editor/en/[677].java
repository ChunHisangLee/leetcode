677
        Map Sum Pairs
        2023-03-07 11:03:05

//leetcode submit region begin(Prohibit modification and deletion)
class MapSum {
    Map<String, Integer> map;
    TrieNode root;

    public MapSum() {
        root = new TrieNode();
        map = new HashMap<>();
    }

    public void insert(String key, int val) {
        int diff = val - map.getOrDefault(key, 0);
        map.put(key, val);
        TrieNode node = root;
        node.num += diff;
        for (char c : key.toCharArray()) {
            node.children.putIfAbsent(c, new TrieNode());
            node = node.children.get(c);
            node.num += diff;
        }
    }

    public int sum(String prefix) {
        TrieNode node = root;
        for (char c : prefix.toCharArray()) {
            node = node.children.get(c);
            if (node == null) {
                return 0;
            }
        }
        return node.num;
    }
}

class TrieNode {
    Map<Character, TrieNode> children = new HashMap<>();
    int num;
}
/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */
//leetcode submit region end(Prohibit modification and deletion)
