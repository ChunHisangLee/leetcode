
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minimumTeachings(int n, int[][] languages, int[][] friendships) {
        int m = languages.length;
        Set<Integer>[] knows = new HashSet[m + 1];

        for (int u = 1; u <= m; u++) {
            knows[u] = new HashSet<>();
            for (int language : languages[u - 1]) {
                knows[u].add(language);
            }
        }

        Set<Integer> affected = new HashSet<>();

        for (int[] e : friendships) {
            int u = e[0];
            int v = e[1];

            Set<Integer> a = knows[u].size() <= knows[v].size() ? knows[u] : knows[v];
            Set<Integer> b = a == knows[u] ? knows[v] : knows[u];

            boolean ok = false;
            for (int language : a) {
                if (b.contains(language)) {
                    ok = true;
                    break;
                }
            }

            if (!ok) {
                affected.add(u);
                affected.add(v);
            }
        }

        if (affected.isEmpty()) {
            return 0;
        }

        int[] freq = new int[n + 1];
        for (int u : affected) {
            for (int language : knows[u]) {
                freq[language]++;
            }
        }

        int res = 0;
        for (int i = 1; i <= n; i++) {
            if (freq[i] > res) {
                res = freq[i];
            }
        }

        return affected.size() - res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
