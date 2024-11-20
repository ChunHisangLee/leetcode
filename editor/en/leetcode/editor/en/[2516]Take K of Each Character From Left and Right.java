
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int takeCharacters(String s, int k) {
        int n = s.length();
        int totalA = 0;
        int totalB = 0;
        int totalC = 0;

        for (char c : s.toCharArray()) {
            if (c == 'a') {
                totalA++;
            } else if (c == 'b') {
                totalB++;
            } else if (c == 'c') {
                totalC++;
            }
        }

        if (totalA < k || totalB < k || totalC < k) {
            return -1;
        }

        int allowedA = totalA - k;
        int allowedB = totalB - k;
        int allowedC = totalC - k;
        int left = 0;
        int maxWindow = 0;
        int windowA = 0;
        int windowB = 0;
        int windowC = 0;

        for (int right = 0; right < n; right++) {
            char c = s.charAt(right);
            if (c == 'a') {
                windowA++;
            } else if (c == 'b') {
                windowB++;
            } else if (c == 'c') {
                windowC++;
            }

            while (left <= right && (windowA > allowedA || windowB > allowedB || windowC > allowedC)) {
                char leftChar = s.charAt(left);
                if (leftChar == 'a') {
                    windowA--;
                } else if (leftChar == 'b') {
                    windowB--;
                } else if (leftChar == 'c') {
                    windowC--;
                }

                left++;
            }

            maxWindow = Math.max(maxWindow, right - left + 1);
        }

        return n - maxWindow;
    }
}

//leetcode submit region end(Prohibit modification and deletion)
