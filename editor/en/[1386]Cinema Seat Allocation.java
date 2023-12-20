
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] arr : reservedSeats) {
            if (!map.containsKey(arr[0])) {
                map.put(arr[0], new ArrayList<>());
            }
            map.get(arr[0]).add(arr[1]);
        }
        int res = 2 * (n - map.size());
        for (Integer key : map.keySet()) {
            List<Integer> list = map.get(key);
            boolean isLeft = true;
            boolean isMiddle = true;
            boolean isRight = true;
            for (int col : list) {
                if (col >= 2 && col <= 5) {
                    isLeft = false;
                }
                if (col >= 4 && col <= 7) {
                    isMiddle = false;
                }
                if (col >= 6 && col <= 9) {
                    isRight = false;
                }
                if (!isLeft && !isMiddle && !isRight) {
                    break;
                }
            }
            res += Math.max((isLeft ? 1 : 0) + (isRight ? 1 : 0), (isMiddle ? 1 : 0));
        }
        return res;
    }
}

//leetcode submit region end(Prohibit modification and deletion)
