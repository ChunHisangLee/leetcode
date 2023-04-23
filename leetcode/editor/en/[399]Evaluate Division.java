399
        Evaluate Division
        2022-12-08 13:57:47

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        double[] res = new double[queries.size()];
        UnionFind uf = new UnionFind();
        for (int i = 0; i < values.length; i++) {
            List<String> equation = equations.get(i);
            uf.union(equation.get(0), equation.get(1), values[i]);
        }
        int index = 0;
        for (List<String> query : queries) {
            Pair<String, Double> pair0 = uf.find(query.get(0));
            Pair<String, Double> pair1 = uf.find(query.get(1));
            res[index] = -1.0;
            if (pair0 != null && pair1 != null && pair0.getKey().equals(pair1.getKey())) {
                res[index] = pair0.getValue() / pair1.getValue();
            }
            index++;
        }
        return res;
    }
}

class UnionFind {
    Map<String, Pair<String, Double>> map = new HashMap<>();

    public Pair<String, Double> find(String x) {
        if (!map.containsKey(x)) {
            return null;
        }
        Pair<String, Double> group = map.get(x);
        if (!group.getKey().equals(x)) {
            Pair<String, Double> newGroup = find(group.getKey());
            group = new Pair<>(newGroup.getKey(), group.getValue() * newGroup.getValue());
            map.put(x, group);
        }
        return group;
    }

    public void union(String x, String y, double value) {
        if (!map.containsKey(x)) {
            map.put(x, new Pair<>(x, 1.0));
        }
        if (!map.containsKey(y)) {
            map.put(y, new Pair<>(y, 1.0));
        }
        Pair<String, Double> groupX = find(x);
        Pair<String, Double> groupY = find(y);
        if (!groupX.getKey().equals(groupY.getKey())) {
            Pair<String, Double> pair = new Pair<>(groupY.getKey(), value * groupY.getValue() / groupX.getValue());
            map.put(groupX.getKey(), pair);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
