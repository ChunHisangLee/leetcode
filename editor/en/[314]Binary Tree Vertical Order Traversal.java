class Solution {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        TreeMap<Integer, List<Integer>> map = new TreeMap<>();
        Deque<Pair<TreeNode, Integer>> deque = new ArrayDeque<>();
        deque.offer(new Pair<>(root, 0));

        while (!deque.isEmpty()) {
            Pair<TreeNode, Integer> pair = deque.poll();
            TreeNode node = pair.getKey();
            int column = pair.getValue();

            if (!map.containsKey(column)) {
                map.put(column, new ArrayList<>());
            }

            map.get(column).add(node.val);

            if (node.left != null) {
                deque.offer(new Pair<>(node.left, column - 1));
            }

            if (node.right != null) {
                deque.offer(new Pair<>(node.right, column + 1));
            }
        }

        return new ArrayList<>(map.values());
    }
}

class Pair<K, V> {
    private K key;
    private V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
