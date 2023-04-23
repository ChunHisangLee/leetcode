//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    Map<String, List<String>> adjacency = new HashMap<>();
    Set<String> visited = new HashSet<>();

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        for (List<String> account : accounts) {
            String firstEmail = account.get(1);
            for (int i = 2; i < account.size(); i++) {
                String otherEmail = account.get(i);
                if (!adjacency.containsKey(firstEmail))
                    adjacency.put(firstEmail, new ArrayList<>());
                adjacency.get(firstEmail).add(otherEmail);
                if (!adjacency.containsKey(otherEmail))
                    adjacency.put(otherEmail, new ArrayList<>());
                adjacency.get(otherEmail).add(firstEmail);
            }
        }
        List<List<String>> mergedAccountsList = new ArrayList<>();
        for (List<String> account : accounts) {
            String firstEmail = account.get(1);
            if (!visited.contains(firstEmail)) {
                List<String> mergedAccount = new ArrayList<>();
                dfs(firstEmail, mergedAccount);
                Collections.sort(mergedAccount);
                mergedAccount.add(0, account.get(0));
                mergedAccountsList.add(mergedAccount);
            }
        }
        return mergedAccountsList;
    }

    public void dfs(String email, List<String> mergedAccount) {
        visited.add(email);
        mergedAccount.add(email);
        if (!adjacency.containsKey(email))
            return;
        for (String nei : adjacency.get(email)) {
            if (visited.contains(nei))
                continue;
            dfs(nei, mergedAccount);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
