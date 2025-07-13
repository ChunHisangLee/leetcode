
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int countPrefixSuffixPairs(String[] words) {
        int count = 0;
        int n = words.length;

        for(int i = 0; i < n; i++) {
            String prefixSuffix = words[i];
            for(int j = i + 1; j < n; j++) {
                String target = words[j];
                if(isPrefixAndSuffix(prefixSuffix, target)) {
                    count++;
                }
            }
        }

        return count;

    }
    private boolean isPrefixAndSuffix(String str1, String str2) {
        if(str1.length() > str2.length()) {
            return false;
        }

        return str2.startsWith(str1) && str2.endsWith(str1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
