
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int slidingPuzzle(int[][] board) {
        String target = "123450";
        StringBuilder sb = new StringBuilder();

        for(int[] row : board){
            for(int num : row){
                sb.append(num);
            }
        }

        String start = sb.toString();
        int[][] neighbors = {
                {1,3},
                {0,2,4},
                {1,5},
                {0,4},
                {1,3,5},
                {2,4}
        };

        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.offer(start);
        visited.add(start);
        int moves = 0;

        while(!queue.isEmpty()){
            int size = queue.size();

            for(int i = 0; i < size; i++){
                String curr = queue.poll();

                if(curr.equals(target)){
                    return moves;
                }

                int zeroIndex = curr.indexOf('0');

                for(int adj : neighbors[zeroIndex]){
                    String next = swap(curr, zeroIndex, adj);

                    if(!visited.contains(next)){
                        visited.add(next);
                        queue.offer(next);
                    }
                }
            }

            moves++;
        }

        return -1;
    }

    private String swap(String str, int i, int j){
        char[] ch = str.toCharArray();
        char temp = ch[i];
        ch[i] = ch[j];
        ch[j] = temp;
        return new String(ch);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
