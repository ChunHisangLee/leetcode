//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private int where;

    public String countOfAtoms(String formula) {
        where = 0;
        TreeMap<String, Integer> elementCounts = parseFormula(formula.toCharArray(), 0);
        StringBuilder result = new StringBuilder();

        for (Map.Entry<String, Integer> entry : elementCounts.entrySet()) {
            result.append(entry.getKey());

            if (entry.getValue() > 1) {
                result.append(entry.getValue());
            }
        }

        return result.toString();
    }

    private void updateElementCounts(TreeMap<String, Integer> counts, StringBuilder element, TreeMap<String, Integer> subCounts, int multiplier) {
        if (element.length() != 0 || subCounts != null) {
            multiplier = (multiplier == 0) ? 1 : multiplier;

            if (element.length() > 0) {
                String elementName = element.toString();
                counts.put(elementName, counts.getOrDefault(elementName, 0) + multiplier);
            } else {
                for (Map.Entry<String, Integer> entry : subCounts.entrySet()) {
                    counts.put(entry.getKey(), counts.getOrDefault(entry.getKey(), 0) + multiplier * entry.getValue());
                }
            }
        }
    }

    private TreeMap<String, Integer> parseFormula(char[] formula, int index) {
        int currentMultiplier = 0;
        TreeMap<String, Integer> counts = new TreeMap<>();
        StringBuilder currentElement = new StringBuilder();
        TreeMap<String, Integer> subCounts = null;

        while (index < formula.length && formula[index] != ')') {
            if (formula[index] == '(' || Character.isUpperCase(formula[index])) {
                updateElementCounts(counts, currentElement, subCounts, currentMultiplier);
                currentMultiplier = 0;
                subCounts = null;
                currentElement.setLength(0);

                if (formula[index] == '(') {
                    subCounts = parseFormula(formula, index + 1);
                    index = where + 1;
                } else {
                    currentElement.append(formula[index++]);
                }
            } else if (Character.isDigit(formula[index])) {
                currentMultiplier = currentMultiplier * 10 + formula[index++] - '0';
            } else {
                currentElement.append(formula[index++]);
            }
        }

        where = index;
        updateElementCounts(counts, currentElement, subCounts, currentMultiplier);
        return counts;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
