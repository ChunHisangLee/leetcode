841
        Keys and Rooms
        2022-12-06 12:14:03

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<List<Integer>> res;
    int[] arr;
    int count;
    int n;

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        n = rooms.size();
        arr = new int[n];
        count = n;
        res = rooms;
        dfs(0);
        return count == 0;
    }

    public void dfs(int i) {
        arr[i] = 1;
        count--;
        List<Integer> list = res.get(i);
        for (int key : list) {
            if (arr[key] == 0) {
                dfs(key);
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
