//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxLength(List<String> arr) {
        return backtrack(arr, "", 0);
    }

    private int backtrack(List<String> arr, String curr, int index) {
        if (index == arr.size()) {
            return curr.length();
        }

        int maxLength = curr.length();

        for (int i = index; i < arr.size(); i++) {
            String next = arr.get(i);

            if (isUnique(curr + next)) {
                maxLength = Math.max(maxLength, backtrack(arr, curr + next, i + 1));
            }
        }

        return maxLength;
    }

    private boolean isUnique(String str) {
        Set<Character> set = new HashSet<>();

        for (char c : str.toCharArray()) {
            if (set.contains(c)) {
                return false;
            }

            set.add(c);
        }

        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
