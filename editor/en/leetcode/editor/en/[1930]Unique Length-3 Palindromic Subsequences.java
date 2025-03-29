
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int countPalindromicSubsequence(String s) {
        int n = s.length();
        int[] first = new int[26];
        int[] last = new int[26];
        Arrays.fill(first, n);
        Arrays.fill(last, -1);

        List<Integer>[] charIndices = new ArrayList[26];
        for(int i = 0; i < 26; i++) {
            charIndices[i] = new ArrayList<>();
        }

        for(int i = 0; i < n; i++) {
            char c = s.charAt(i);
            int idx = c - 'a';
            if(i < first[idx]) first[idx] = i;
            if(i > last[idx]) last[idx] = i;
            charIndices[idx].add(i);
        }

        int total = 0;

        for(int a = 0; a < 26; a++) {
            if(first[a] < last[a]) {
                int start = first[a] + 1;
                int end = last[a] - 1;

                for(int b = 0; b < 26; b++) {
                    List<Integer> indices = charIndices[b];
                    if(indices.isEmpty()) {
                        continue;
                    }

                    int left = 0;
                    int right = indices.size() - 1;
                    int pos = -1;
                    while(left <= right) {
                        int mid = left + (right - left) / 2;
                        if(indices.get(mid) >= start && indices.get(mid) <= end) {
                            pos = mid;
                            break;
                        } else if(indices.get(mid) < start) {
                            left = mid + 1;
                        } else {
                            right = mid - 1;
                        }
                    }

                    if(pos != -1) {
                        total++;
                    }
                }
            }
        }

        return total;
    }
}

//leetcode submit region end(Prohibit modification and deletion)
