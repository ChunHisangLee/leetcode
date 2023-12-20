
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Boolean> prefixesDivBy5(int[] nums) {
        List<Boolean> list = new ArrayList<>();
        int n = 0;
        for (int num : nums) {
            n = (n * 2 + num) % 5;
            list.add(n == 0);
        }
        return list;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/*
- 2ms
class Solution {
    public List<Boolean> prefixesDivBy5(int[] nums) {
        int n = nums.length;
        Boolean[] arr = new Boolean[n];
        int index = 0;
        int temp = 0;
        for (int num : nums) {
            temp = (temp * 2 + num) % 5;
            arr[index++] = (temp == 0);
        }
        return Arrays.asList(arr);
    }
}
 */