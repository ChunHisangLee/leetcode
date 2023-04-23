/*
還不會
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] comps = path.split("/");
        for (String comp : comps) {
            if (comp.equals(".") || comp.isEmpty()) {
                continue;
            } else if (comp.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.add(comp);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (String dir : stack) {
            sb.append("/");
            sb.append(dir);
        }

        return sb.length() > 0 ? sb.toString() : "/";
    }
}
//leetcode submit region end(Prohibit modification and deletion)
