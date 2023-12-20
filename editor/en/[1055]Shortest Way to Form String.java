1055
        Shortest Way to Form String
        2023-03-08 11:55:39

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int shortestWay(String source, String target) {
        char[]chTarget = target.toCharArray();
        int count = 1;
        String str = source;
        int i = 0;
        while (i < chTarget.length) {
            char curr = chTarget[i];
            int index = str.indexOf(curr);
            if (str.equals(source) && index == -1) {
                return -1;
            }
            if (index != -1) {
                str = str.substring(index + 1);
                i++;
            } else {
                count++;
                str = source;
            }
        }
        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
