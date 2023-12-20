288
        Unique Word Abbreviation
        2023-01-30 09:48:08

//leetcode submit region begin(Prohibit modification and deletion)
class ValidWordAbbr {
    Map<String, Set<String>> map;

    public ValidWordAbbr(String[] dictionary) {
        map = new HashMap<>();
        for (String word : dictionary) {
            String str = abbr(word);
            map.putIfAbsent(str, new HashSet<>());
            map.get(str).add(word);
        }
    }

    public boolean isUnique(String word) {
        String str = abbr(word);
        return !map.containsKey(str) || (map.get(str).contains(word) && map.get(str).size() == 1);
    }

    String abbr(String word) {
        String str = word;
        if (word.length() > 2) {
            StringBuilder sb = new StringBuilder();
            sb.append(word.charAt(0)).append(word.length() - 2).append(word.charAt(word.length() - 1));
            str = sb.toString();
        }
        return str;
    }
}

/**
 * Your ValidWordAbbr object will be instantiated and called as such:
 * ValidWordAbbr obj = new ValidWordAbbr(dictionary);
 * boolean param_1 = obj.isUnique(word);
 */
//leetcode submit region end(Prohibit modification and deletion)
