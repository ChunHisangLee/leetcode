1089
        Duplicate Zeros
        2023-01-16 23:39:35

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void duplicateZeros(int[] arr) {
        int n = arr.length;
        int[] res = arr.clone();
        int indexArr = 0;
        int indexRes = 0;
        while (indexArr < n) {
            if (res[indexRes] == 0 && indexArr <= n - 2) {
                arr[indexArr] = 0;
                arr[indexArr + 1] = 0;
                indexRes++;
                indexArr += 2;
            } else {
                arr[indexArr] = res[indexRes];
                indexRes++;
                indexArr++;
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
