import java.util.*;

public class Solution {

    public static void main(String[] args){

        Solution a = new Solution();
        int n = 5;
        int [][] edges = {{0, 1}, {1, 2}, {2, 0}, {3, 4}};
        System.out.println(a.validTree(n,edges));

    }


    /*
     * @param n: An integer
     * @param edges: a list of undirected edges
     * @return: true if it's a valid tree, or false
     */
    public boolean validTree(int n, int[][] edges) {

        Map<Integer, Set<Integer>> graph = initializeGraph(n,edges);
        if(n == 0){
            return false;
        }
        if(n - 1 != edges.length){
            return false;
        }

        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> set = new HashSet<>();

        queue.offer(0);
        set.add(0);


        while (!queue.isEmpty()){
            int node = queue.poll();
            for(Integer neighbor : graph.get(node)){
                if(set.contains(neighbor)){
                    continue;
                }
                queue.offer(neighbor);
                set.add(neighbor);
            }
        }

        return set.size() == n;
    }

    public Map<Integer, Set<Integer>> initializeGraph(int n, int [][] edges){

        Map<Integer,Set<Integer>> initialization = new HashMap<>();
        for(int i = 0 ; i < n ; i++){
            initialization.put(i, new HashSet<>());
        }
        for(int i = 0 ; i < edges.length ; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            initialization.get(u).add(v);
            initialization.get(v).add(u);
        }
        return initialization;
    }


}
