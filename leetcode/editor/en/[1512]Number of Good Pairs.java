
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numIdenticalPairs(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (int num : map.values()) {
            if (num > 1) {
                count += num * (num - 1) / 2;
            }
        }

        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/*
 - 0ms
class Solution {
    public int numIdenticalPairs(int[] nums) {
        int[] arr = new int[101];
        int count = 0;
        for (int num : nums) {
            arr[num]++;
        }
        for (int num : arr) {
            if (num > 1) {
                count += num * (num - 1) / 2;
            }
        }
        return count;
    }
}

- 1ms;
class Solution {
    public int numIdenticalPairs(int[] nums) {
        int n = nums.length;
        int count = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] == nums[j]) {
                    count++;
                }
            }
        }
        return count;
    }
}
 */