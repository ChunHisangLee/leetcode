1346
        Check If N and Its Double Exist
        2023-01-17 23:06:13

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean checkIfExist(int[] arr) {
        int n = arr.length;
        for(int i = 0 ; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(i != j && arr[i] == 2 * arr[j]) {
                    return true;
                }
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
