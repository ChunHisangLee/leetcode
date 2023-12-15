
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String destCity(List<List<String>> paths) {
        Set<String> set = new HashSet<>();

        for (List<String> name : paths) {
            set.add(name.get(0));
        }

        for (List<String> name : paths) {
            if (!set.contains(name.get(1))) {
                return name.get(1);
            }
        }

        return "";
    }
}
//leetcode submit region end(Prohibit modification and deletion)
