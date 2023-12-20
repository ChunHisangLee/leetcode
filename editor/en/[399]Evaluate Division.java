399
        Evaluate Division
        2022-12-08 13:57:47

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    Map<String, String> group = new HashMap<>();
    Map<String, Double> ratio = new HashMap<>();

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int m = equations.size();
        for (int i = 0; i < m; i++) {
            union(equations.get(i).get(0), equations.get(i).get(1), values[i]);
        }
        int n = queries.size();
        double[] res = new double[n];
        for (int i = 0; i < n; i++) {
            String x = queries.get(i).get(0);
            String y = queries.get(i).get(1);
            res[i] = -1;
            if (group.containsKey(x) && group.containsKey(y) && find(x).equals(find(y))) {
                res[i] = ratio.get(x) / ratio.get(y);
            }
        }
        return res;
    }

    public void union(String i, String j, double val) {
        if (!group.containsKey(i)) {
            group.put(i, i);
            ratio.put(i, 1.0);
        }
        if (!group.containsKey(j)) {
            group.put(j, j);
            ratio.put(j, 1.0);
        }
        String x = find(i);
        String y = find(j);
        group.put(x, y);
        ratio.put(x, val * ratio.get(j) / ratio.get(i));
    }

    public String find(String i) {
        if (i.equals(group.get(i))) {
            return i;
        }
        String x = group.get(i);
        String y = find(x);
        group.put(i, y);
        ratio.put(i, ratio.get(i) * ratio.get(x));
        return y;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
