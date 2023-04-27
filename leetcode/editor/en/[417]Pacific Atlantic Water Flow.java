
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    boolean[][] isAtl;
    boolean[][] isPac;
    List<List<Integer>> res=new ArrayList<>();
    int m;
    int n;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        m=heights.length;
        n=heights[0].length;
        isAtl=new boolean[m][n];
        isPac=new boolean[m][n];
        for(int i=0;i<n;i++){
            dfs(is)
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
