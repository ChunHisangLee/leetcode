2306
        Naming a Company
        2023-02-09 09:07:01

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public long distinctNames(String[] ideas) {
        Set<String>[] set = new Set[26];
        for (int i = 0; i < 26; i++) {
            set[i] = new HashSet<>();
        }
        for (String idea : ideas) {
            set[idea.charAt(0) - 'a'].add(idea.substring(1));
        }
        int[][] same = new int[26][26];
        for (int i = 0; i < 26; i++) {
            for (String str : set[i]) {
                for (int j = i + 1; j < 26; j++) {
                    if (set[j].contains(str)) {
                        same[i][j]++;
                    }
                }
            }
        }
        long res = 0;
        for (int i = 0; i < 26; i++) {
            for (int j = i + 1; j < 26; j++) {
                res += (set[i].size() - same[i][j]) * (set[j].size() - same[i][j]) * 2;
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
