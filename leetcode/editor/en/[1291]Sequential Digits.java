
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        String str = "123456789";
        int n = 10;
        List<Integer> list = new ArrayList<>();
        int lowLen = String.valueOf(low).length();
        int highLen = String.valueOf(high).length();
        for (int i = lowLen; i < highLen + 1; i++) {
            for (int j = 0; j < n - i; j++) {
                int num = Integer.parseInt(str.substring(j, j + i));
                if (num >= low && num <= high) {
                    list.add(num);
                }
            }
        }
        return list;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/*
class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        String str = "123456789";
        int n = 10;
        List<Integer> list = new ArrayList<>();
        int lowLen = String.valueOf(low).length();
        int highLen = String.valueOf(high).length();
        for (int i = lowLen; i < highLen + 1; i++) {
            for (int j = 0; j < n - i; j++) {
                int num = Integer.parseInt(str.substring(j, j + i));
                if (num >= low && num <= high) {
                    list.add(num);
                }
            }
        }
        return list;
    }
}
 */