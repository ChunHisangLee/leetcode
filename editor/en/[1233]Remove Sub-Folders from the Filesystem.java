
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder);
        List<String> result = new ArrayList<>();

        for (String currentFolder : folder) {
            if (result.isEmpty() || !currentFolder.startsWith(result.get(result.size() - 1) + "/")) {
                result.add(currentFolder);
            }
        }

        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
