383
Ransom Note
2022-12-05 18:23:13
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] source = new int[26];
        int[] target = new int[26];
        for (char c : magazine.toCharArray()) {
            source[c - 'a']++;
        }
        for (char c : ransomNote.toCharArray()) {
            target[c - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (source[i] < target[i])
                return false;
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
