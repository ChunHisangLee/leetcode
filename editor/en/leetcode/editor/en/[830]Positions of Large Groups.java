
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> result = new ArrayList<>();
        int n = s.length();
        int i = 0;

        while (i < n) {
            int start = i;
            char currentChar = s.charAt(i);

            while (i < n && s.charAt(i) == currentChar) {
                i++;
            }

            int end = i;

            if (end - start >= 3) {
                List<Integer> group = new ArrayList<>();
                group.add(start);
                group.add(end - 1);
                result.add(group);
            }
        }

        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
