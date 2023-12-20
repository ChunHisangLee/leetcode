
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String sortVowels(String s) {
        char[] chars = s.toCharArray();
        List<Character> list = new ArrayList<>();
        int index = 0;

        for (char c : chars) {
            if (isVowel(c)) {
                list.add(c);
            }
        }

        Collections.sort(list);

        for (int i = 0; i < chars.length; i++) {
            if (isVowel(chars[i])) {
                chars[i] = list.get(index++);
            }
        }

        return new String(chars);
    }

    private boolean isVowel(Character c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ||
                c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }
}
//leetcode submit region end(Prohibit modification and deletion)
