//leetcode submit region begin(Prohibit modification and deletion)
class Trie {
  private static class TrieNode {
    TrieNode[] children = new TrieNode[26];
    boolean isEndofWord = false;
  }

  private final TrieNode root;

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
    }
    node.isEndofWord = true;
  }

  public boolean search(String word) {
    TrieNode node = root;
    for (char c : word.toCharArray()) {
      int index = c - 'a';
      if (node.children[index] == null) {
        return false;
      }
      node = node.children[index];
    }
    return node.isEndofWord;
  }

  public boolean startsWith(String prefix) {
    TrieNode node = root;
    for (char c : prefix.toCharArray()) {
      int index = c - 'a';
      if (node.children[index] == null) {
        return false;
      }
      node = node.children[index];
    }
    return true;
  }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
//leetcode submit region end(Prohibit modification and deletion)
