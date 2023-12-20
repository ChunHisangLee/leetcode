
//leetcode submit region begin(Prohibit modification and deletion)
public class Codec {
    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(str.length()).append("-").append(str);
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> list = new ArrayList<>();
        int index = 0;
        while (index < s.length()) {
            int dashPos = s.indexOf('-', index);
            String str = s.substring(index, dashPos);
            int start = index + str.length() + 1;
            int end = start + Integer.valueOf(str);
            list.add(s.substring(start, end));
            index = end;
        }
        return list;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));
//leetcode submit region end(Prohibit modification and deletion)
