990
        Satisfiability of Equality Equations
        2023-03-03 11:44:47

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean equationsPossible(String[] equations) {
        int[] arr = new int[26];
        for (int i = 0; i < 26; i++) {
            arr[i] = i;
        }
        for (String equ : equations) {
            if (equ.charAt(1) == '=') {
                int x = equ.charAt(0) - 'a';
                int y = equ.charAt(3) - 'a';
                union(arr, x, y);
            }
        }
        for (String equ : equations) {
            if (equ.charAt(1) == '!') {
                int x = equ.charAt(0) - 'a';
                int y = equ.charAt(3) - 'a';
                if (find(arr, x) == find(arr, y)) {
                    return false;
                }
            }
        }
        return true;
    }

    private int find(int[] arr, int x) {
        return arr[x] == x ? x : (arr[x] = find(arr, arr[x]));
    }

    private void union(int[] arr, int x, int y) {
        x = find(arr, x);
        y = find(arr, y);
        if (x != y) {
            arr[x] = y;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
