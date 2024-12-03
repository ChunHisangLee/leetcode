
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        int m = s.length(), n = p.length();

        if (m < n) {
            return list;
        }

        int[] arrs = new int[26];
        int[] arrp = new int[26];

        for (int i = 0; i < n; i++) {
            arrs[s.charAt(i) - 'a']++;
            arrp[p.charAt(i) - 'a']++;
        }

        int matches = 0;

        for (int i = 0; i < 26; i++) {
            if (arrs[i] == arrp[i]) {
                matches++;
            }
        }

        for (int i = 0; i <= m - n; i++) {
            if (matches == 26) {
                list.add(i);
            }

            if (i + n == m) {
                break;
            }

            int left = s.charAt(i) - 'a';
            int right = s.charAt(i + n) - 'a';
            arrs[left]--;

            if (arrs[left] == arrp[left]) {
                matches++;
            } else if (arrs[left] + 1 == arrp[left]) {
                matches--;
            }

            arrs[right]++;

            if (arrs[right] == arrp[right]) {
                matches++;
            } else if (arrs[right] - 1 == arrp[right]) {
                matches--;
            }
        }

        return list;
    }
}

//leetcode submit region end(Prohibit modification and deletion)
