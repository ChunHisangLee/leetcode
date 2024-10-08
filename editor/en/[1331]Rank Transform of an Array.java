
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] arrayRankTransform(int[] arr) {
        if (arr == null || arr.length == 0) {
            return arr;
        }

        TreeSet<Integer> set = new TreeSet();
        int n = arr.length;

        for (int num : arr) {
            set.add(num);
        }

        Map<Integer, Integer> map = new HashMap();
        int rank = 1;

        for (int num : set) {
            map.put(num, rank++);
        }

        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            result[i] = map.get(arr[i]);
        }

        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
