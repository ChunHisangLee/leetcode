//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> frequencyMap = new HashMap<>();

        for (char c : s.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }

        List<Character>[] buckets = new List[s.length() + 1];

        for (Map.Entry<Character, Integer> entry : frequencyMap.entrySet()) {
            int freq = entry.getValue();
            char c = entry.getKey();

            if (buckets[freq] == null) {
                buckets[freq] = new ArrayList<>();
            }

            buckets[freq].add(c);
        }

        StringBuilder sb = new StringBuilder(s.length());

        for (int freq = buckets.length - 1; freq >= 1; freq--) {
            if (buckets[freq] != null) {
                for (char c : buckets[freq]) {
                    sb.append(repeatChar(c, freq));
                }
            }
        }

        return sb.toString();
    }

    private String repeatChar(char c, int count) {
        char[] chars = new char[count];
        Arrays.fill(chars, c);
        return new String(chars);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
