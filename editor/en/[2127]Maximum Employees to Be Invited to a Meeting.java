
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maximumInvitations(int[] favorite) {
        int n = favorite.length;

        List<List<Integer>> reverseGraph = new ArrayList<>();
        for(int i=0; i<n; i++) {
            reverseGraph.add(new ArrayList<>());
        }
        for(int i=0; i<n; i++) {
            reverseGraph.get(favorite[i]).add(i);
        }

        boolean[] visited = new boolean[n];
        boolean[] onStack = new boolean[n];
        List<List<Integer>> cycles = new ArrayList<>();
        List<int[]> mutualPairs = new ArrayList<>();

        for(int i=0; i<n; i++) {
            if(!visited[i]) {
                List<Integer> stack = new ArrayList<>();
                dfsCycle(i, favorite, visited, onStack, stack, cycles, mutualPairs);
            }
        }

        boolean[] inCycle = new boolean[n];
        for(List<Integer> cycle : cycles){
            if(cycle.size() > 2){
                for(int node : cycle){
                    inCycle[node] = true;
                }
            }
        }

        int[] maxChain = new int[n];
        Arrays.fill(maxChain, -1);
        int mutualPairsContribution = 0;

        for(int[] pair : mutualPairs){
            int A = pair[0];
            int B = pair[1];
            int chainA = findMaxChain(A, reverseGraph, inCycle, B, maxChain);
            int chainB = findMaxChain(B, reverseGraph, inCycle, A, maxChain);
            mutualPairsContribution += 2 + chainA + chainB;
        }

        int maxCycle = 0;
        for(List<Integer> cycle : cycles){
            if(cycle.size() > 2){
                maxCycle = Math.max(maxCycle, cycle.size());
            }
        }

        return Math.max(maxCycle, mutualPairsContribution);
    }

    private void dfsCycle(int node, int[] favorite, boolean[] visited, boolean[] onStack,
                          List<Integer> stack, List<List<Integer>> cycles, List<int[]> mutualPairs){
        visited[node] = true;
        onStack[node] = true;
        stack.add(node);

        int fav = favorite[node];
        if(!visited[fav]){
            dfsCycle(fav, favorite, visited, onStack, stack, cycles, mutualPairs);
        }
        else if(onStack[fav]){
            int index = stack.indexOf(fav);
            if(index != -1){
                List<Integer> cycle = new ArrayList<>(stack.subList(index, stack.size()));
                if(cycle.size() == 2){
                    mutualPairs.add(new int[]{cycle.get(0), cycle.get(1)});
                }
                else{
                    cycles.add(cycle);
                }
            }
        }

        onStack[node] = false;
        stack.remove(stack.size()-1);
    }

    private int findMaxChain(int node, List<List<Integer>> reverseGraph, boolean[] inCycle,
                             int excludeNode, int[] maxChain){
        if(maxChain[node] != -1){
            return maxChain[node];
        }

        int max = 0;
        for(int neighbor : reverseGraph.get(node)){
            if(neighbor == excludeNode || inCycle[neighbor]){
                continue;
            }
            max = Math.max(max, 1 + findMaxChain(neighbor, reverseGraph, inCycle, excludeNode, maxChain));
        }
        maxChain[node] = max;
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/*
class Solution {
    public int maximumInvitations(int[] favorite) {
        int n = favorite.length;
        int[] indegrees = new int[n];
        int[] maxDepth = new int[n];
        for(int i = 0; i < n; ++i) {
            indegrees[favorite[i]]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < n; ++i) {
            if(indegrees[i] == 0) {
                q.add(i);
                maxDepth[i] = 0;
            }
        }
        while(!q.isEmpty()) {
            int top = q.poll();
            int v = favorite[top];
            indegrees[v]--;
            maxDepth[v] = Integer.max(maxDepth[v], 1 + maxDepth[top]);
            if(indegrees[v] == 0) {
                q.add(v);
            }
        }

        int resultWithTwoNodeCycle = 0;
        int resultWithFullCycle = 0;

        int[] visited = new int[n];
        for(int i = 0; i < n; ++i) {
            if(indegrees[i] != 0 && visited[i] == 0) {
                int length = 0;
                int j = i;
                while(visited[j] != 1) {
                    visited[j] = 1;
                    j = favorite[j];
                    length++;
                }
                if(length == 2) {
                    resultWithTwoNodeCycle += maxDepth[i] + maxDepth[favorite[i]] + 2;
                }
                resultWithFullCycle = Integer.max(resultWithFullCycle, length);
            }
        }

        return Integer.max(resultWithFullCycle, resultWithTwoNodeCycle);
    }
}
 */
