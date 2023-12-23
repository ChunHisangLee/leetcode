
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private static final String SEPARATOR = ",";

    public boolean isPathCrossing(String path) {
        Set<String> set = new HashSet<>();
        int x = 0;
        int y = 0;
        set.add("0,0");

        for (char c : path.toCharArray()) {
            switch (c) {
                case 'N' -> y++;
                case 'S' -> y--;
                case 'E' -> x++;
                case 'W' -> x--;
            }

            String curr = getString(x, y);

            if (set.contains(curr)) {
                return true;
            }

            set.add(curr);
        }

        return false;
    }

    private String getString(int x, int y) {
        StringBuilder sb = new StringBuilder();
        sb.append(x).append(SEPARATOR).append(y);
        return sb.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
