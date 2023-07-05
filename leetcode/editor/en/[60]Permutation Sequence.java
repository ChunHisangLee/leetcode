
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String getPermutation(int n, int k) {
        List<Integer> list = new ArrayList<>();
        int[] arr = new int[n + 1];
        StringBuilder sb = new StringBuilder();
        arr[0] = 1;
        for (int i = 1; i <= n; i++) {
            arr[i] = arr[i - 1] * i;
            list.add(i);
        }
        k--;
        for (int i = 1; i <= n; i++) {
            int index = k / arr[n - i];
            sb.append(list.get(index));
            list.remove(index);
            k -= index * arr[n - i];
        }
        return sb.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
