658
        Find K Closest Elements
        2022-12-09 23:57:06

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int left = 0;
        int right = arr.length - 1 - k;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (x - arr[mid] > arr[mid + k] - x) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            list.add(arr[i + left]);
        }
        return list;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/*
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int left = 0;
        int right = arr.length - 1;
        while (right - left >= k) {
            int mid = (left + right) >> 1;
            if (Math.abs(arr[right] - x) < Math.abs(arr[left] - x)) {
                left++;
            } else {
                right--;
            }
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            list.add(arr[i + left]);
        }
        return list;
    }
}
 */