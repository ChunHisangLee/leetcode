
/**
 * // This is the Master's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface Master {
 *     public int guess(String word) {}
 * }
 */
class Solution {
    public void findSecretWord(String[] words, Master master) {
        int n = words.length;
        matchWord(Arrays.asList(words), master);
    }

    private int getMatches(String w1, String w2) {
        int matches = 0;

        for(int i = 0; i < 6; i++) {
            if(w1.charAt(i) == w2.charAt(i)) {
                matches++;
            }
        }

        return matches;
    }

    private boolean matchWord(List<String> words, Master master) {
        int randomId = new Random().nextInt(words.size());
        String word = words.get(randomId);
        int matches = master.guess(word);

        if(matches == 6) {
            return true;
        }

        List<String> newWordList = new ArrayList<>();

        for(String word2: words) {
            if(!word2.equals(word) && matches == getMatches(word, word2)) {
                newWordList.add(word2);
            }
        }

        return matchWord(newWordList, master);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
