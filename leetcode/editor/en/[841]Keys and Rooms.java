841
        Keys and Rooms
        2022-12-06 12:14:03

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    Set<Integer> set = new HashSet<>();

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        set.add(0);
        dfs(rooms, 0);
        return set.size() == rooms.size();
    }

    private void dfs(List<List<Integer>> rooms, int node) {
        for (int neighbor : rooms.get(node)) {
            if (!set.contains(neighbor)) {
                set.add(neighbor);
                dfs(rooms, neighbor);
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
