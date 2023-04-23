class Solution {
    public String minWindow(String s, String t) {
        int[] arr = new int[128];
        int minStart = 0;
        int minLen = Integer.MAX_VALUE;
        int n = t.length();
        for (char c : t.toCharArray()) {
            arr[c]++;
        }
        for (int left = 0, right = 0; right < s.length(); right++) {
            char c1 = s.charAt(right);
            arr[c1]--;
            if (arr[c1] >= 0) {
                n--;
            }
            while (n == 0) {
                char c2 = s.charAt(left);
                arr[c2]++;
                if (arr[c2] > 0) {
                    if (minLen > right - left + 1) {
                        minLen = right - left + 1;
                        minStart = left;
                    }
                    n++;
                }
                left++;
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
    }
}