1345
        Jump Game IV
        2023-03-05 09:54:47

//leetcode submit region begin(Prohibit modification and deletion)
/*
還不會，但是DP不能用
 */
class Solution {
    public int minJumps(int[] arr) {
        int n = arr.length;
        if (n <= 1) {
            return 0;
        }
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.putIfAbsent(arr[i], new ArrayList<>());
            map.get(arr[i]).add(i);
        }

        List<Integer> list = new LinkedList<>();
        list.add(0);
        Set<Integer> set = new HashSet<>();
        int step = 0;
        while (!list.isEmpty()) {
            List<Integer> next = new LinkedList<>();
            for (int node : list) {
                if (node == n - 1) {
                    return step;
                }
                for (int child : map.get(arr[node])) {
                    if (!set.contains(child)) {
                        set.add(child);
                        next.add(child);
                    }
                }
                map.get(arr[node]).clear();
                if (node + 1 < n && !set.contains(node + 1)) {
                    set.add(node + 1);
                    next.add(node + 1);
                }
                if (node - 1 >= 0 && !set.contains(node - 1)) {
                    set.add(node - 1);
                    next.add(node - 1);
                }
            }
            list = next;
            step++;
        }
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
