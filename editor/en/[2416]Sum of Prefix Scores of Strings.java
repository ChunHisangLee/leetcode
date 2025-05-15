
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] sumPrefixScores(String[] words) {
        int n = words.length;
        int[] answer = new int[n];
        TrieNode root = buildTrie(words);

        for (int i = 0; i < n; i++) {
            String word = words[i];
            TrieNode current = root;
            int sum = 0;

            for (char ch : word.toCharArray()) {
                int idx = ch - 'a';

                if (current.children[idx] == null) {
                    break;
                }

                current = current.children[idx];
                sum += current.count;
            }

            answer[i] = sum;
        }

        return answer;
    }

    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();

        for (String word : words) {
            TrieNode current = root;

            for (char ch : word.toCharArray()) {
                int idx = ch - 'a';

                if (current.children[idx] == null) {
                    current.children[idx] = new TrieNode();
                }

                current = current.children[idx];
                current.count++;
            }
        }

        return root;
    }
}

class TrieNode {
    TrieNode[] children;
    int count;

    TrieNode() {
        children = new TrieNode[26];
        count = 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
