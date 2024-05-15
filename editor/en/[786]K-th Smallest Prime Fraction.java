//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        double low = 0;
        double high = 1;
        int n = arr.length;
        int[] ans = new int[2];

        while (low < high) {
            double mid = (low + high) / 2;
            int count = 0;
            int left = 0;
            int[] temp = new int[]{0, 1};

            for (int right = 1; right < n; right++) {
                while (arr[left] <= mid * arr[right]) {
                    left++;

                    if (left == right) {
                        break;
                    }
                }

                count += left;

                if (left > 0) {
                    left--;

                    if (arr[left] * temp[1] > arr[right] * temp[0]) {
                        temp[0] = arr[left];
                        temp[1] = arr[right];
                    }
                }
            }

            if (count == k) {
                ans = temp;
                break;
            } else if (count < k) {
                low = mid;
            } else {
                high = mid;
            }
        }

        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
