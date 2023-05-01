841
        Keys and Rooms
        2022-12-06 12:14:03

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<List<Integer>> res;
    boolean[] isVisited;
    int n;
    int count;

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        n = rooms.size();
        res = rooms;
        count = n;
        isVisited = new boolean[n];
        dfs(0);
        return count == 0;
    }

    public void dfs(int i) {
        isVisited[i] = true;
        count--;
        if (count == 0) {
            return;
        }
        List<Integer> list = res.get(i);
        for (int key : list) {
            if (!isVisited[key]) {
                dfs(key);
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
