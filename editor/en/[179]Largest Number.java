179
        Largest Number
        2023-01-30 16:49:00

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String largestNumber(int[] nums) {
        List<String> list = new ArrayList<>();
        for (int num : nums) {
            list.add(Integer.toString(num));
        }
        Collections.sort(list, (a, b) -> (b + a).compareTo(a + b));
        if (list.get(0).equals("0")) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        for (String num : list) {
            sb.append(num);
        }
        return sb.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
