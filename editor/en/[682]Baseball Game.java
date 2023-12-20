
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<Integer> list = new ArrayList<>();

    public int calPoints(String[] operations) {
        for (String str : operations) {
            if (str.equals("C")) {
                list.remove(list.size() - 1);
            } else if (str.equals("D")) {
                int num = 2 * list.get(list.size() - 1);
                list.add(num);
            } else if (str.equals("+")) {
                int sum = list.get(list.size() - 1) + list.get(list.size() - 2);
                list.add(sum);
            } else {
                list.add(Integer.parseInt(str));
            }
        }
        int res = 0;
        for (int num : list) {
            res += num;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
