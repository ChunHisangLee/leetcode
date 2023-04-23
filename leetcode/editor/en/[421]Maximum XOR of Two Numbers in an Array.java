//leetcode submit region begin(Prohibit modification and deletion)
/*
還不會
 */
class Solution {
    public int findMaximumXOR(int[] nums) {
        int n = nums.length;
        Trie root = new Trie();
        for (int i = 0; i < n; i++) {
            Trie node = root;
            for (int j = 31; j >= 0; j--) {
                int bit = (nums[i] >> j) & 1;
                if (node.children[bit] == null) {
                    node.children[bit] = new Trie();
                }
                node = node.children[bit];
            }
        }
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int temp = 0;
            Trie node = root;
            for (int j = 31; j >= 0; j--) {
                int bit = (nums[i] >> j) & 1;
                if (node.children[1 - bit] != null) {
                    node = node.children[1 - bit];
                    temp += (1 << j);
                } else {
                    node = node.children[bit];
                }
            }
            res = Math.max(res, temp);
        }
        return res;
    }
}
class Trie {
    Trie[] children = new Trie[2];
}
//leetcode submit region end(Prohibit modification and deletion)
