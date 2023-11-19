
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int reductionOperations(int[] nums) {
        int count = 0;
        int result = 0;
        Arrays.sort(nums);

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                count++;
            }

            result += count;
        }

        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/*
自己想的
class Solution {
    public int reductionOperations(int[] nums) {
        Map<Integer, Integer> map = new TreeMap<>();
        int index = 0;
        int result = 0;

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (int key : map.keySet()) {
            result += map.get(key) * index;
            index++;
        }

        return result;
    }
}
 */