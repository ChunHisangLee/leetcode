
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minDeletions(String s) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }
        Set<Integer> set = new HashSet<>();
        int res = 0;
        for (int num : freq) {
            int curr = num;
            while (curr > 0) {
                if (!set.contains(curr)) {
                    set.add(curr);
                    break;
                }
                curr--;
                res++;
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
