119
        Pascal's Triangle II
        2022-12-22 00:47:08

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<>();
        long num = 1;

        for (int i = 0; i <= rowIndex; i++) {
            result.add((int) num);
            num = num * (rowIndex - i) / (1 + i);
        }

        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/*
class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i <= rowIndex; i++) {
            List<Integer> list = new ArrayList<>();

            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    list.add(1);
                } else {
                    list.add(result.get(i - 1).get(j - 1) + result.get(i - 1).get(j));
                }
            }
            result.add(list);
        }

        return result.get(rowIndex);
    }
}
 */