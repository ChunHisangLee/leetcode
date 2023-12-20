
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        UnionFind uf = new UnionFind(n);
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            List<String> list = accounts.get(i);
            for (int j = 1; j < list.size(); j++) {
                String email = list.get(j);
                if (!map.containsKey(email)) {
                    map.put(email, i);
                } else {
                    uf.union(i, map.get(email));
                }
            }
        }
        Map<Integer, List<String>> idToEmail = new HashMap<>();
        for (String key : map.keySet()) {
            int id = uf.find(map.get(key));
            if (!idToEmail.containsKey(id)) {
                idToEmail.put(id, new ArrayList<>());
            }
            idToEmail.get(id).add(key);
        }
        List<List<String>> res = new ArrayList<>();
        for (Integer id : idToEmail.keySet()) {
            List<String> email = idToEmail.get(id);
            Collections.sort(email);
            email.add(0, accounts.get(id).get(0));
            res.add(email);
        }
        return res;
    }
}

class UnionFind {
    int[] group;

    public UnionFind(int n) {
        group = new int[n];
        for (int i = 0; i < n; i++) {
            group[i] = i;
        }
    }

    public int find(int x) {
        return group[x] == x ? x : (group[x] = find(group[x]));
    }

    public void union(int i, int j) {
        int x = find(i);
        int y = find(j);
        if (x != y) {
            group[x] = y;
        }
    }
}

//leetcode submit region end(Prohibit modification and deletion)
