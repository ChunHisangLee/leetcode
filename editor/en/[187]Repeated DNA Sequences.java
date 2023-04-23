import java.util.ArrayList;
import java.util.HashSet;

// 187
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> set = new HashSet<>();
        Set<String> list = new HashSet<>();
        for (int i = 0; i <= s.length() - 10; i++) {
            String str = s.substring(i, i + 10);
            if (set.contains(str)) {
                list.add(str);
            } else {
                set.add(str);
            }
        }
        return new ArrayList<String>(list);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
