
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean halvesAreAlike(String s) {
        Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        int mid = s.length() / 2;
        int countFirst = getCount(s.substring(0, mid), vowels);
        int countSecond = getCount(s.substring(mid), vowels);
        return countFirst == countSecond;
    }

    private int getCount(String s, Set<Character> set) {
        int count = 0;

        for (char c : s.toCharArray()) {
            if (set.contains(c)) {
                count++;
            }
        }
        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
