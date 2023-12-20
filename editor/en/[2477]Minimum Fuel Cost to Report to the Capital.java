2477
        Minimum Fuel Cost to Report to the Capital
        2023-02-12 10:43:14

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private long res = 0;
    private int seats;

    public long minimumFuelCost(int[][] roads, int seats) {
        this.seats = seats;
        int n = roads.length + 1;
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
        }
        for (int[] road : roads) {
            list.get(road[0]).add(road[1]);
            list.get(road[1]).add(road[0]);
        }
        dfs(0, 0, list);
        return res;
    }

    private int dfs(int city, int prev, List<List<Integer>> list) {
        int count = 1;
        for (Integer nei : list.get(city)) {
            if (nei == prev) {
                continue;
            }
            count += dfs(nei, city, list);
        }
        if (city != 0) {
            res += (count + seats - 1) / seats;
        }
        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
