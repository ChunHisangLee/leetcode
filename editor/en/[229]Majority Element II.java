229
        Majority Element II
        2023-01-14 00:04:32

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        List<Integer> list = new ArrayList<>();
        int bar = n / 3;
        int count = 1;

        Arrays.sort(nums);

        for (int i = 1; i < n; i++) {
            if (nums[i] == nums[i - 1]) {
                count++;
                continue;
            }

            if (count > bar) {
                list.add(nums[i - 1]);
            }

            count = 1;
        }

        if (count > bar) {
            list.add(nums[n - 1]);
        }

        return list;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/*
class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int bar = nums.length / 3;
        List<Integer> list = new ArrayList<>();
        int count = 1;
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                count++;
                continue;
            }
            if (count > bar) {
                list.add(nums[i - 1]);
            }
            count = 1;
        }
        if (count > bar) {
            list.add(nums[nums.length - 1]);
        }
        return list;
    }
}

class Solution {
    public List<Integer> majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int bar = nums.length / 3;
        for (int key : map.keySet()) {
            if (map.get(key) > bar) {
                list.add(key);
            }
        }
        return list;
    }
}
 */