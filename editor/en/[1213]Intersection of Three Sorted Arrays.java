//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {
        List<Integer> result = new ArrayList<>();
        int i = 0;
        int j = 0;
        int k = 0;

        while (i < arr1.length && j < arr2.length && k < arr3.length) {
            if (arr1[i] == arr2[j] && arr2[j] == arr3[k]) {
                result.add(arr1[i]);
                i++;
                j++;
                k++;
            } else {
                int min = Math.min(arr1[i], Math.min(arr2[j], arr3[k]));

                if (arr1[i] == min) {
                    i++;
                }

                if (arr2[j] == min) {
                    j++;
                }

                if (arr3[k] == min) {
                    k++;
                }
            }
        }

        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
