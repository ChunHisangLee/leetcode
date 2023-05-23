
//leetcode submit region begin(Prohibit modification and deletion)
class UndergroundSystem {
    Map<Integer, Pair<String, Integer>> custs;
    Map<String, int[]> dists;

    public UndergroundSystem() {
        custs = new HashMap<>();
        dists = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        custs.put(id, new Pair(stationName, t));
    }

    public void checkOut(int id, String stationName, int t) {
        Pair<String, Integer> cust = custs.get(id);
        dists.putIfAbsent(cust.getKey() + "-" + stationName, new int[2]);
        int[] sum = dists.get(cust.getKey() + "-" + stationName);
        sum[0] += t - cust.getValue();
        sum[1]++;
        custs.remove(id);
    }

    public double getAverageTime(String startStation, String endStation) {
        int[] sum = dists.get(startStation + "-" + endStation);
        return (double) sum[0] / sum[1];
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */
//leetcode submit region end(Prohibit modification and deletion)
