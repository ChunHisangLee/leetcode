658
        Find K Closest Elements
        2022-12-09 23:57:06

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int left = 0;
        int right = arr.length - 1;
        while (right - left >= k) {
            if (Math.abs(arr[right] - x) < Math.abs(arr[left] - x)) {
                left++;
            } else {
                right--;
            }
        }
        List<Integer> list = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            list.add(arr[i]);
        }
        return list;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
