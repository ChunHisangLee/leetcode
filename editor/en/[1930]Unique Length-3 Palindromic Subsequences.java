
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int countPalindromicSubsequence(String s) {
        char[] ch = s.toCharArray();
        Set<Character> set = new HashSet<>();
        int result = 0;

        for (char c : ch) {
            set.add(c);
        }

        for (char c : set) {
            int left = s.indexOf(c);
            int right = s.lastIndexOf(c);

            if (left > -1) {
                boolean[] isVisited = new boolean[26];
                int count = 0;

                for (int i = left + 1; i < right; i++) {
                    if (!isVisited[ch[i] - 'a']) {
                        isVisited[ch[i] - 'a'] = true;
                        count++;
                    }
                }

                result += count;
            }
        }

        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/*
越少Set效率越高

181 ms
class Solution {
    public int countPalindromicSubsequence(String s) {
        char[] ch = s.toCharArray();
        Set<Character> set = new HashSet<>();
        int result = 0;

        for (char c : ch) {
            set.add(c);
        }

        for (char c : set) {
            int left = s.indexOf(c);
            int right = s.lastIndexOf(c);

            if (left > -1) {
                Set<Character> letters = new HashSet<>();

                for (int i = left + 1; i < right; i++) {
                    letters.add(ch[i]);
                }

                result += letters.size();
            }
        }

        return result;
    }
}


28 ms
class Solution {
    public int countPalindromicSubsequence(String s) {
        char[] ch = s.toCharArray();
        Set<Character> set = new HashSet<>();
        int result = 0;

        for (char c : ch) {
            set.add(c);
        }

        for (char c : set) {
            int left = s.indexOf(c);
            int right = s.lastIndexOf(c);

            if (left > -1) {
                boolean[] isVisited = new boolean[26];
                int count = 0;

                for (int i = left + 1; i < right; i++) {
                    if (!isVisited[ch[i] - 'a']) {
                        isVisited[ch[i] - 'a'] = true;
                        count++;
                    }
                }

                result += count;
            }
        }

        return result;
    }
}

17 ms
class Solution {
    public int countPalindromicSubsequence(String s) {
        char[] ch = s.toCharArray();
        int[] first = new int[26];
        int[] last = new int[26];
        int result = 0;

        Arrays.fill(first, -1);

        for (int i = 0; i < ch.length; i++) {
            int curr = ch[i] - 'a';
            if (first[curr] == -1) {
                first[curr] = i;
            }

            last[curr] = i;
        }

        for (int i = 0; i < 26; i++) {
            if (first[i] == -1) {
                continue;
            }

            boolean[] isVisited = new boolean[26];
            int count = 0;

            for (int j = first[i] + 1; j < last[i]; j++) {
                if (!isVisited[ch[j] - 'a']) {
                    isVisited[ch[j] - 'a'] = true;
                    count++;
                }
            }

            result += count;
        }

        return result;
    }
}
 */