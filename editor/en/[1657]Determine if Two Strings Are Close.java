
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length())
            return false;
        int[] arr1 = getCount(word1);
        int[] arr2 = getCount(word2);

        for (int i = 0; i < 26; i++) {
            if (arr1[i] == 0 && arr2[i] > 0 || ar1657r2[i] == 0 && arr1[i] > 0) {
                return false;
            }
        }

        Arrays.sort(arr1);
        Arrays.sort(arr2);
        return Arrays.equals(arr1, arr2);
    }

    private int[] getCount(String s) {
        int[] arr = new int[26];

        for (char c : s.toCharArray()) {
            arr[c - 'a']++;
        }

        return arr;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
