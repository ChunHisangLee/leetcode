
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> buildArray(int[] target, int n) {
        List<String> list = new ArrayList<>();
        int index = 0;
        int count = 0;

        while (index < target.length && count++ < n) {
            list.add("Push");

            if (target[index] == count) {
                index++;
            } else {
                list.add("Pop");
            }
        }

        return list;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
