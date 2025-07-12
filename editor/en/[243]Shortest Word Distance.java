
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int shortestDistance(String[] wordsDict, String word1, String word2) {
        int index = -1;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < wordsDict.length; i++) {
            if (wordsDict[i].equals(word1) || wordsDict[i].equals(word2)) {
                if (index != -1 && !wordsDict[index].equals(wordsDict[i])) {
                    min = Math.min(min, i - index);
                }

                index = i;
            }
        }

        return min;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
