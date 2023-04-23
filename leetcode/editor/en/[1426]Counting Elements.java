1426
        Counting Elements
        2022-11-26 00:55:50

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int countElements(int[] arr) {
        Set<Integer> set = new HashSet<>();
        int ans = 0;
        for (int num : arr) {
            set.add(num);
        }
        for (int i = 0; i < arr.length; i++) {
            if (set.contains(arr[i] + 1))
                ans++;
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
