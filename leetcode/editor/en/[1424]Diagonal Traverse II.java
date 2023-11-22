
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        Deque<int[]> deque = new ArrayDeque<>();
        deque.offer(new int[]{0, 0});
        List<Integer> list = new ArrayList();

        while (!deque.isEmpty()) {
            int[] curr = deque.poll();
            int row = curr[0];
            int col = curr[1];
            list.add(nums.get(row).get(col));

            if (col == 0 && row + 1 < nums.size()) {
                deque.offer(new int[]{row + 1, col});
            }

            if (col + 1 < nums.get(row).size()) {
                deque.offer(new int[]{row, col + 1});
            }
        }

        int[] result = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }

        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/*
BFS - 19 ms
class Solution {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        Deque<int[]> deque = new ArrayDeque<>();
        deque.offer(new int[]{0, 0});
        List<Integer> list = new ArrayList();

        while (!deque.isEmpty()) {
            int[] curr = deque.poll();
            int row = curr[0];
            int col = curr[1];
            list.add(nums.get(row).get(col));

            if (col == 0 && row + 1 < nums.size()) {
                deque.offer(new int[]{row + 1, col});
            }

            if (col + 1 < nums.get(row).size()) {
                deque.offer(new int[]{row, col + 1});
            }
        }

        int[] result = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }

        return result;
    }
}

HashMap - 34 ms
class Solution {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int size = 0;

        for (int i = 0; i < nums.size(); i++) {
            for (int j = 0; j < nums.get(i).size(); j++) {
                map.putIfAbsent(i + j, new ArrayList<>());
                map.get(i + j).add(nums.get(i).get(j));
                size++;
            }
        }

        int[] result = new int[size];
        int index = 0;
        int curr = 0;

        while (map.containsKey(curr)) {
            List<Integer> list = map.get(curr);

            for (int i = list.size() - 1; i >= 0; i--) {
                result[index++] = list.get(i);
            }

            curr++;
        }

        return result;
    }
}
 */