
//leetcode submit region begin(Prohibit modification and deletion)
class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode node = root;

        for (char c : word.toCharArray()) {
            int index = c - 'a';

            if (node.children[index] == null) {
                node.children[index] = new TrieNode();
            }

            node = node.children[index];
            node.prefixCount++;
        }

        node.count++;
    }

    public int countWordsEqualTo(String word) {
        TrieNode node = root;

        for (char c : word.toCharArray()) {
            int index = c - 'a';

            if (node.children[index] == null) {
                return 0;
            }

            node = node.children[index];
        }

        return node.count;
    }

    public int countWordsStartingWith(String prefix) {
        TrieNode node = root;

        for (char c : prefix.toCharArray()) {
            int index = c - 'a';

            if (node.children[index] == null) {
                return 0;
            }

            node = node.children[index];
        }

        return node.prefixCount;
    }

    public void erase(String word) {
        TrieNode node = root;

        for (char c : word.toCharArray()) {
            int index = c - 'a';
            node = node.children[index];
            node.prefixCount--;
        }

        node.count--;
    }
}

class TrieNode {
    public int count;
    public int prefixCount;
    public TrieNode[] children;

    public TrieNode() {
        count = 0;
        prefixCount = 0;
        children = new TrieNode[26];
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * int param_2 = obj.countWordsEqualTo(word);
 * int param_3 = obj.countWordsStartingWith(prefix);
 * obj.erase(word);
 */
//leetcode submit region end(Prohibit modification and deletion)
