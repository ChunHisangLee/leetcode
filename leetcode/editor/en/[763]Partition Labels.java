
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> partitionLabels(String s) {
        char[] c = s.toCharArray();
        int[] arr = new int[26];
        for (int i = 0; i < c.length; i++) {
            arr[c[i] - 'a'] = i;
        }
        List<Integer> list = new ArrayList<>();
        int j = 0;
        int index = 0;
        for (int i = 0; i < c.length; i++) {
            j = Math.max(j, arr[c[i] - 'a']);
            if (i == j) {
                list.add(i - index + 1);
                index = i + 1;
            }
        }
        return list;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
