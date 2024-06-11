
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> map = new TreeMap<>();

        for (int num : arr1) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int[] arr = new int[arr1.length];
        int index = 0;

        for (int num : arr2) {
            int count = map.get(num);

            while (count-- > 0) {
                arr[index++] = num;
            }

            map.put(num, 0);
        }

        for (int key : map.keySet()) {
            int count = map.get(key);

            while (count-- > 0) {
                arr[index++] = key;
            }
        }

        return arr;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
