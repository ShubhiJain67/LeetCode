public class Solution {
    public int[][] reconstructQueue(int[][] people) {
        int[][] result = new int[people.length][];
        List<int[]> list = new ArrayList<int[]>();
        PriorityQueue<int[]> queue = new PriorityQueue<int[]>((int a[],int b[])->{
            if(a[0]!=b[0]) return b[0]-a[0];
            return a[1]-b[1];
        });
        for(int i = 0; i < people.length; i++){
            queue.add(people[i]);
        }
        while(queue.size() != 0){
            int [] popped=queue.poll();
            // for(int i:popped){
            //     System.out.print(i+" ");
            // }
            // System.out.println();
            insert(list, popped);
        }
        for(int i = 0; i < people.length; i++){
            result[i] = list.get(i);
        }
        return result;
    }
    private void insert(List<int[]> list, int[] element){
        if(list.size() == 0) {
            list.add(element);
            return;
        }
        int count = 0;
        for(int i = 0; i < list.size(); i++){
            if(count == element[1]){
                list.add(i, element);
                return;
            }else if(list.get(i)[0] >= element[0]){
                count++;
            }
        }
        list.add(element);
    }    
}