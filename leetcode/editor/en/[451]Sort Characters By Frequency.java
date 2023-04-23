451
        Sort Characters By Frequency
        2022-12-03 08:03:02

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        List<Character> chars = new ArrayList<>(map.keySet());
        Collections.sort(chars, (a, b) -> map.get(b) - map.get(a));
        StringBuilder sb = new StringBuilder();
        for (char ch : chars) {
            int copies = map.get(ch);
            for (int i = 0; i < copies; i++) {
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
