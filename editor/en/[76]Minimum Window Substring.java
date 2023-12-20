class Solution {
    public String minWindow(String s, String t) {
        int[] arr = new int[128];
        int n = t.length();
        for (char c : t.toCharArray()) {
            arr[c]++;
        }
        char[] cs = s.toCharArray();
        int start = 0;
        int len = Integer.MAX_VALUE;
        for (int left = 0, right = 0; right < cs.length; right++) {
            char c1 = cs[right];
            arr[c1]--;
            if (arr[c1] >= 0) {
                n--;
            }
            while (n == 0) {
                char c2 = cs[left];
                arr[c2]++;
                if (arr[c2] > 0) {
                    if (len > right - left + 1) {
                        len = right - left + 1;
                        start = left;
                    }
                    n++;
                }
                left++;
            }
        }
        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }
}