//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            list.add(new ArrayList<>());
        }
        int[] inDegree = new int[numCourses];
        for (int[] pre : prerequisites) {
            list.get(pre[1]).add(pre[0]);
            inDegree[pre[0]]++;
        }
        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                dq.add(i);
            }
        }
        int count = 0;
        while (!dq.isEmpty()) {
            int curr = dq.poll();
            count++;
            for (int num : list.get(curr)) {
                inDegree[num]--;
                if (inDegree[num] == 0) {
                    dq.add(num);
                }
            }
        }
        return count == numCourses;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


    /*
        Approach
            -> We are given preRequisites for a course completion
            -> [1, 0] means, in order to complete course 1, we have to complete course 0
            -> Now, if we are given pre-requisites some thing like this
                -> [1, 0], [0, 1]
                -> This means, in order to complete 1, we need to complete course 0
                -> But, in order to complete course 0, we have to complete course 1
                -> This cycle makes it impossible to complete

            -> How can we solve such problem?
                -> We can think 1st item of the row to be the item of completion
                -> Any other item after first is something that we have to finish
                -> We can think it as traversing the adjacency list
                    -> And we have to make sure every node is visited
                    -> If any one node is unable to complete, this would mean course cannot be completed.

            -> After reading constraints, we know that row length of pre-requisites will always be 2
                -> numRows = 2
                -> Could be many columns

            -> We build an adjacency list of the pre-requisites
                ->
                o, {1}
                1, {0}

                -> Then do a DFS and check if it is possible to visit all.
                -> In case there are some loops
                    -> We can use set
                    -> While doing DFS, if we encounter something from set
                        -> We have encountered a cycle
                        -> Impossible to complete the course

            -> Time Complexity
                -> O(N + P)
                    -> N = number of nodes
                    -> P = number of pre-requisites


            -> In below solution, what happened?
                -> From pre-requisites 2-d array, we built a adjacency matrix
                -> A basic traversal was done, with a simple check
                    -> Do we see any cycles?
                    -> If yes, then return false
                -> Else return true;

                -> How was that cycle check performed?
                    -> It was a DFS done on the adjacency list
                    -> with a boolean visited array or a set, I would have needed 2 visited arrays
                        -> One for the DFS
                        -> one for the cycles
                    -> I used an array
                        -> 0 means default, item is not present
                        -> 1 means item is being visited currently
                            -> We are either on the item
                            -> Or checking it's adjacency list
                        -> 2 means, item is visited, no cycles found
                            -> And won't be visited further

    */
