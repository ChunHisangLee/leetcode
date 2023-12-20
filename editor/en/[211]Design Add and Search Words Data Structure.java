//leetcode submit region begin(Prohibit modification and deletion)
class TrieNode {
    Map<Character, TrieNode> children = new HashMap<>();
    boolean isWord = false;
}

class WordDictionary {
    TrieNode trie;
    int max;

    public WordDictionary() {
        trie = new TrieNode();
        max = 0;
    }

    public void addWord(String word) {
        TrieNode node = trie;
        for (char c : word.toCharArray()) {
            if (node.children.get(c) == null) {
                node.children.put(c, new TrieNode());
            }
            node = node.children.get(c);
        }
        node.isWord = true;
        max = Math.max(max, word.length());
    }

    public boolean searchInNode(String word, TrieNode node, int index) {
        if (index >= word.length()) {
            return node.isWord;
        }
        char c = word.charAt(index);
        if (c == '.') {
            for (char key : node.children.keySet()) {
                TrieNode child = node.children.get(key);
                if (child == null) {
                    continue;
                }
                if (searchInNode(word, child, index + 1)) {
                    return true;
                }
            }
            return false;
        } else {
            if (node.children.get(c) == null) {
                return false;
            }
            return searchInNode(word, node.children.get(c), index + 1);
        }
    }

    public boolean search(String word) {
        if (word.length() > max) {
            return false;
        }
        return searchInNode(word, trie, 0);
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 * <p>
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 * <p>
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 * <p>
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 * <p>
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
//leetcode submit region end(Prohibit modification and deletion)
