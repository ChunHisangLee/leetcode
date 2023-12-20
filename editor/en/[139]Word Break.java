//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        return dyP(s, wordDict, new Boolean[s.length()], 0);
    }

    private boolean dyP(String s, List<String> wordDict, Boolean[] dp, int index) {
        if (index == s.length()) {
            return true;
        }
        if (dp[index] != null) {
            return dp[index];
        }
        for (String word : wordDict) {
            if (s.startsWith(word, index) && dyP(s, wordDict, dp, index + word.length())) {
                dp[index] = true;
                return dp[index];
            }
        }
        dp[index] = false;
        return dp[index];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
//https://blog.jiebu-lang.com/leetcode-139-word-break/
/*
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Boolean[] dp = new Boolean[s.length()];
        TrieNode root = new TrieNode();
        for (String word : wordDict) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                if (!node.children.containsKey(c)) {
                    node.children.put(c, new TrieNode());
                }
                node = node.children.get(c);
            }
            node.isWord = true;
        }
        return dyP(s, root, dp, 0);
    }

    public boolean dyP(String s, TrieNode root, Boolean[] dp, int index) {
        if (index == s.length()) {
            return true;
        }
        if (dp[index] != null) {
            return dp[index];
        }
        TrieNode node = root;
        for (int right = index; right < s.length(); right++) {
            if (!node.children.containsKey(s.charAt(right))) {
                return dp[index] = false;
            }
            node = node.children.get(s.charAt(right));
            if (node.isWord) {
                if (dyP(s, root, dp, right + 1)) {
                    return dp[index] = true;
                }
            }
        }
        return dp[index] = false;
    }
}

class TrieNode {
    Map<Character, TrieNode> children = new HashMap<>();
    boolean isWord;
}
 */