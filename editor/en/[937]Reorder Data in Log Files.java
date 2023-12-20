
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, (a, b) -> {
            int indexA = a.indexOf(" ") + 1;
            int indexB = b.indexOf(" ") + 1;
            boolean isLetterA = Character.isLetter(a.charAt(indexA));
            boolean isLetterB = Character.isLetter(b.charAt(indexB));
            if (isLetterA && isLetterB) {
                int cmp = a.substring(indexA).compareTo(b.substring(indexB));
                if (cmp != 0) {
                    return cmp;
                }
                return a.compareTo(b);
            }
            if (isLetterA && !isLetterB) {
                return -1;
            } else if (!isLetterA && isLetterB) {
                return 1;
            } else {
                return 0;
            }
        });
        return logs;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
