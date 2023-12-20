315
        Count of Smaller Numbers After Self
        2023-02-18 14:49:24

//leetcode submit region begin(Prohibit modification and deletion)
/*
還不會
 */
class Solution {
    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n];
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }
        mergeSort(nums, arr, res, 0, n);
        List<Integer> list = new ArrayList<>(n);
        for (int num : res) {
            list.add(num);
        }
        return list;
    }

    private void mergeSort(int[] nums, int[] arr, int[] res, int left, int right) {
        if (right - left <= 1) {
            return;
        }
        int mid = left + (right - left) / 2;
        mergeSort(nums, arr, res, left, mid);
        mergeSort(nums, arr, res, mid, right);
        merge(nums, arr, res, left, right, mid);
    }

    private void merge(int nums[], int[] arr, int[] res, int left, int right, int mid) {
        int i = left;
        int j = mid;
        List<Integer> list = new ArrayList<>(right - left);
        while (i < mid && j < right) {
            if (nums[arr[i]] <= nums[arr[j]]) {
                res[arr[i]] += j - mid;
                list.add(arr[i]);
                i++;
            } else {
                list.add(arr[j]);
                j++;
            }
        }
        while (i < mid) {
            res[arr[i]] += j - mid;
            list.add(arr[i]);
            i++;
        }
        while (j < right) {
            list.add(arr[j]);
            j++;
        }
        for (int k = left; k < right; k++) {
            arr[k] = list.get(k - left);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
