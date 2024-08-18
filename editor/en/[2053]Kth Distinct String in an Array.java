
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String kthDistinct(String[] arr, int k) {
        Map<String, Integer> map = new HashMap<>();

        for (String str : arr) {
            map.merge(str, 1, Integer::sum);
        }

        int count = 0;

        for (String str : arr) {
            if (map.get(str) == 1) {
                count++;

                if (count == k) {
                    return str;
                }
            }
        }

        return "";
    }
}
//leetcode submit region end(Prohibit modification and deletion)
