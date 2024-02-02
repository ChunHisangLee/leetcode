
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> list = new ArrayList<>();

        for (int i = 1; i < 10; i++) {
            int num = 0;
            int j = i;
            while (num <= high && j < 10) {
                num = num * 10 + j;

                if (num >= low && num <= high) {
                    list.add(num);
                }

                j++;
            }
        }

        Collections.sort(list);
        return list;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/*
class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> list = new ArrayList<>();
        String digits = "123456789";

        for (int len = 2; len <= digits.length(); len++) {
            for (int start = 0; start <= digits.length() - len; start++) {
                int num = Integer.parseInt(digits.substring(start, start + len));

                if (num >= low && num <= high) {
                    list.add(num);
                }
            }
        }

        return list;
    }
}

class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> list = new ArrayList<>();

        for (int i = 1; i < 10; i++) {
            int num = 0;
            int j = i;
            while (num <= high && j < 10) {
                num = num * 10 + j;

                if (num >= low && num <= high) {
                    list.add(num);
                }

                j++;
            }
        }

        Collections.sort(list);
        return list;
    }
}
 */