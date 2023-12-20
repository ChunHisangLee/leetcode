260Single Number III 2023-01-26 13:27:55

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int[] arr = new int[2];
        int index = 0;
        for (int key : map.keySet()) {
            if (map.get(key) == 1) {
                arr[index] = key;
                index++;
            }
        }
        return arr;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/*
class Solution {
    public int[] singleNumber(int[] nums) {
        int bitmask = 0;
        for (int num : nums) {
            bitmask ^= num;
        }
        int diff = bitmask & (-bitmask);
        int x = 0;
        for (int num : nums) {
            if ((num & diff) != 0) {
                x ^= num;
            }
        }
        return new int[]{x, bitmask ^ x};
    }
}
 */