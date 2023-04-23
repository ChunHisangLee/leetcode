648
        Replace Words
        2023-03-07 14:12:46

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public String replaceWords(List<String> roots, String sentence) {
        Trie trie = new Trie();
        for (String word : roots) {
            trie.insert(word);
        }
        StringBuilder sb = new StringBuilder();
        for (String word : sentence.split("\\s+")) {
            String str = trie.search(word);
            if (str == null) {
                sb.append(word).append(" ");
            } else {
                sb.append(str).append(" ");
            }
        }
        return sb.toString().trim();
    }
}

class Trie {
    TrieNode root = new TrieNode();

    public void insert(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            if (node.children.get(c) == null) {
                node.children.put(c, new TrieNode());
            }
            node = node.children.get(c);
        }
        node.isWord = true;
    }

    public String search(String word) {
        TrieNode node = root;
        StringBuilder sb = new StringBuilder();
        for (char c : word.toCharArray()) {
            if (node.children.get(c) == null) {
                return node.isWord ? sb.toString() : null;
            }
            node = node.children.get(c);
            sb.append(c);
            if (node.isWord) {
                return sb.toString();
            }
        }
        return node.isWord ? sb.toString() : null;
    }
}

class TrieNode {
    Map<Character, TrieNode> children = new HashMap<>();
    boolean isWord;
}
//leetcode submit region end(Prohibit modification and deletion)
