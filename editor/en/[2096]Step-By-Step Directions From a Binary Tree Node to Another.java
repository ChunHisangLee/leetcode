
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String getDirections(TreeNode root, int startValue, int destValue) {
        StringBuilder pathToStart = new StringBuilder();
        StringBuilder pathToDest = new StringBuilder();

        findPath(root, startValue, pathToStart);
        findPath(root, destValue, pathToDest);

        int commonLength = 0;

        while (commonLength < pathToStart.length() && commonLength < pathToDest.length()
                && pathToStart.charAt(commonLength) == pathToDest.charAt(commonLength)) {
            commonLength++;
        }

        StringBuilder directions = new StringBuilder();

        for (int i = commonLength; i < pathToStart.length(); i++) {
            directions.append('U');
        }

        directions.append(pathToDest.substring(commonLength));
        return directions.toString();
    }

    private boolean findPath(TreeNode root, int target, StringBuilder path) {
        if (root == null) {
            return false;
        }

        if (root.val == target) {
            return true;
        }

        path.append('L');

        if (findPath(root.left, target, path)) {
            return true;
        }

        path.deleteCharAt(path.length() - 1);
        path.append('R');

        if (findPath(root.right, target, path)) {
            return true;
        }

        path.deleteCharAt(path.length() - 1);
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/*
class Solution {
    public String getDirections(TreeNode root, int startValue, int destValue) {
        List<Character> pathToStart = new ArrayList<>();
        List<Character> pathToDest = new ArrayList<>();

        findPath(root, startValue, pathToStart);
        findPath(root, destValue, pathToDest);

        int commonLength = (int) IntStream.range(0, Math.min(pathToStart.size(), pathToDest.size()))
                .filter(i -> pathToStart.get(i) != pathToDest.get(i))
                .findFirst()
                .orElse(Math.min(pathToStart.size(), pathToDest.size()));

        String directions = Stream.concat(
                        IntStream.range(commonLength, pathToStart.size()).mapToObj(i -> 'U'),
                        pathToDest.subList(commonLength, pathToDest.size())
                                .stream())
                .map(Objects::toString)
                .collect(Collectors.joining());
        return directions;
    }

    private boolean findPath(TreeNode root, int target, List<Character> path) {
        if (root == null) {
            return false;
        }

        if (root.val == target) {
            return true;
        }

        path.add('L');

        if (findPath(root.left, target, path)) {
            return true;
        }

        path.remove(path.size() - 1);
        path.add('R');

        if (findPath(root.right, target, path)) {
            return true;
        }

        path.remove(path.size() - 1);
        return false;
    }
}
 */