/*
還不會
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        UnionFind uf = new UnionFind(n);
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            List<String> list = accounts.get(i);
            for (int j = 1; j < list.size(); j++) {
                String email = list.get(j);
                if (map.containsKey(email)) {
                    uf.union(i, map.get(email));
                } else {
                    map.put(email, i);
                }
            }
        }
        Map<Integer, List<String>> idToEmails = new HashMap<>();
        for (String key : map.keySet()) {
            int root = uf.find(map.get(key));
            if (!idToEmails.containsKey(root)) {
                idToEmails.put(root, new ArrayList<String>());
            }
            idToEmails.get(root).add(key);
        }
        List<List<String>> mergedList = new ArrayList<>();
        for (Integer id : idToEmails.keySet()) {
            List<String> emails = idToEmails.get(id);
            Collections.sort(emails);
            emails.add(0, accounts.get(id).get(0));
            mergedList.add(emails);
        }
        return mergedList;
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

    public void union(int i, int j) {
        int x = find(i);
        int y = find(j);
        if (x != y) {
            group[x] = y;
        }
    }

    public int find(int x) {
        return group[x] == x ? x : (group[x] = find(group[x]));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
