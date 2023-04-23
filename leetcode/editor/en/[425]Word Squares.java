import org.apache.commons.collections4.Trie;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    class Trie {
        Trie parent;
        Map<Character, Trie> chars = new HashMap<>();
        String word = null;
        public Trie(Trie parent) {
            this.parent = parent;
        }
    }

    class CharTrie {
        char c;
        Trie t;
        public CharTrie(char c, Trie t) {
            this.c = c;
            this.t = t;
        }
    }

    List<List<String>> squares = new ArrayList<>();
    Trie sRoot;
    public List<List<String>> wordSquares(String[] words) {
        squares = new ArrayList<>();
        sRoot = new Trie(null);
        for (String word : words) {
            Trie temp = sRoot;
            for (Character c : word.toCharArray()) {
                if (!temp.chars.containsKey(c))
                    temp.chars.put(c, new Trie(temp));
                temp = temp.chars.get(c);
            }
            temp.word = word;
        }

        int n = words[0].length();
        CharTrie[][] b = new CharTrie[n][n];
        wordSquares(b, sRoot, 0, 0, n);

        return squares;
    }

    public void wordSquares(CharTrie[][] b, Trie root, int i, int j, int n) {
        if (i >= n || j >= n || root == null) return;

        for (Character c : root.chars.keySet()) {
            if (i == j);
            else if (i == 0)
                b[j][i] = new CharTrie(c, b[i][i].t.parent.chars.get(c));
            else if (b[j][i - 1] != null && b[j][i - 1].t != null && b[j][i - 1].t.chars.get(c) != null)
                b[j][i] = new CharTrie(c, b[j][i - 1].t.chars.get(c));
            else {
                b[i][j] = null;
                b[j][i] = null;
                continue;
            }

            b[i][j] = new CharTrie(c, root.chars.get(c));

            if (i == n - 1 && j == n - 1) {
                List<String> square = new ArrayList<>();
                for (int w = 0; w < n; w++) {
                    square.add(b[w][n - 1].t.word);
                }
                squares.add(square);
            }

            wordSquares(b, root.chars.get(c), i, j + 1, n);

            if (j == n - 1 && i + 1 < n && b[i + 1][i] != null && b[i + 1][i].t != null) {
                wordSquares(b, b[i + 1][i].t, i + 1, i + 1, n);
            }
        }



    }
}
//leetcode submit region end(Prohibit modification and deletion)
