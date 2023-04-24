//leetcode submit region begin(Prohibit modification and deletion)
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

    public boolean dyP(String s, TrieNode root, Boolean[] dp, int left) {
        if (left == s.length()) {
            return true;
        }
        if (dp[left] != null) {
            return dp[left];
        }
        TrieNode node = root;
        for (int right = left; right < s.length(); right++) {
            if (!node.children.containsKey(s.charAt(right))) {
                return dp[left] = false;
            }
            node = node.children.get(s.charAt(right));
            if (node.isWord) {
                if (dyP(s, root, dp, right + 1)) {
                    return dp[left] = true;
                }
            }
        }
        return dp[left] = false;
    }
}

class TrieNode {
    Map<Character, TrieNode> children = new HashMap<>();
    boolean isWord;
}
//leetcode submit region end(Prohibit modification and deletion)
//https://blog.jiebu-lang.com/leetcode-139-word-break/
/*
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Boolean[] dp = new Boolean[s.length()];
        return dyP(s, new HashSet<>(wordDict), dp, 0);
    }

    public boolean dyP(String s, Set<String> set, Boolean[] dp, int left) {
        if (left == s.length()) {
            return true;
        }
        if (dp[left] != null) {
            return dp[left];
        }
        for (int right = left + 1; right <= s.length(); right++) {
            if (set.contains(s.substring(left, right)) && dyP(s, set, dp, right)) {
                return dp[left] = true;
            }
        }
        return dp[left] = false;
    }
}
 */