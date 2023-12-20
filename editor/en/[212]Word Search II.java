/*
還不會
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    char[][] board;
    boolean[][] isVisited;
    int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    List<String> list = new ArrayList<>();
    int m;
    int n;

    public List<String> findWords(char[][] board, String[] words) {
        this.board = board;
        m = board.length;
        n = board[0].length;
        isVisited = new boolean[m][n];
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                if (!node.children.containsKey(c)) {
                    node.children.put(c, new TrieNode());
                }
                node = node.children.get(c);
            }
            node.word = word;
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (root.children.containsKey(board[i][j])) {
                    isVisited[i][j] = true;
                    backtrack(i, j, root);
                    isVisited[i][j] = false;
                }
            }
        }
        return list;
    }

    public void backtrack(int i, int j, TrieNode root) {
        char c = board[i][j];
        TrieNode node = root.children.get(c);
        if (node.word != null) {
            list.add(node.word);
            node.word = null;
        }
        for (int[] dir : dirs) {
            int x = i + dir[0];
            int y = j + dir[1];
            if (x < 0 || x >= m || y < 0 || y >= n || isVisited[x][y] == true) {
                continue;
            }
            if (node.children.containsKey(board[x][y])) {
                isVisited[x][y] = true;
                backtrack(x, y, node);
                isVisited[x][y] = false;
            }
        }
        if (node.children.isEmpty()) {
            root.children.remove(c);
        }
    }
}

class TrieNode {
    Map<Character, TrieNode> children = new HashMap<>();
    String word = null;
}

//leetcode submit region end(Prohibit modification and deletion)
