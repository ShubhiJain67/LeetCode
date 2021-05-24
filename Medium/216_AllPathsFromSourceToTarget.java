class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        calculatedPaths = new ArrayList[graph.length];
        List<List<Integer>> paths = getPaths_Memoization(graph, 0, graph.length - 1);
        return paths;
    }
    public List<List<Integer>> getPaths(int[][] graph, int currNode, int targetNode){
        List<List<Integer>> paths = new ArrayList<>();
        //System.out.println("CurrNode : " + currNode);
        if(currNode == targetNode){
            //System.out.println("Found Target Node");
            List<Integer> path = new ArrayList<>();
            path.add(currNode);
            paths.add(path);
            return paths;
        }
        else{
            List<List<Integer>> tempPaths = new ArrayList<>();
            for(int neighbourNode : graph[currNode]){
                tempPaths = getPaths(graph, neighbourNode, targetNode);
                for(List<Integer> path : tempPaths){
                    path.add(0, currNode);
                    paths.add(path);
                }
            }
        }
        return paths;
    }
    
    List<List<Integer>>[] calculatedPaths;
    public List<List<Integer>> getPaths_Memoization(int[][] graph, int currNode, int targetNode){
        List<List<Integer>> paths = new ArrayList<>();
        //System.out.println("CurrNode : " + currNode);
        if(currNode == targetNode){
            //System.out.println("Found Target Node");
            List<Integer> path = new ArrayList<>();
            path.add(currNode);
            paths.add(path);
        }
        else if(calculatedPaths[currNode] != null){
            return calculatedPaths[currNode];
        }
        else{
            List<List<Integer>> tempPaths = new ArrayList<>();
            for(int neighbourNode : graph[currNode]){
                tempPaths = getPaths(graph, neighbourNode, targetNode);
                for(List<Integer> path : tempPaths){
                    path.add(0, currNode);
                    paths.add(path);
                }
            }
        }
        calculatedPaths[currNode] = paths;
        return paths;
    }
}