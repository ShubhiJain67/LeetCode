class Solution 
{    
    public int numBusesToDestination(int[][] routes, int S, int T)
        {
            
            HashMap<Integer,ArrayList<Integer>> map=new HashMap<>();
            for (int i = 0; i < routes.length; i++)
            {
                for (int ele : routes[i])
                {
                    map.putIfAbsent(ele,new ArrayList<>());
                    map.get(ele).add(i);
                }
            }

            HashSet<Integer> busStandVis=new HashSet();
            boolean[] busVis=new boolean[routes.length];

            LinkedList<Integer> que=new LinkedList<>();
            que.addLast(S);
            int level = 0;
            busStandVis.add(S);

            while (que.size() != 0)
            {
                int size = que.size();
                while (size-- > 0)
                {
                    int stand = que.removeFirst();

                    if (stand == T)
                        return level;

                    for (int bus : map.get(stand))
                    {
                        if (busVis[bus])
                            continue;

                        for (int busStand : routes[bus])
                        {
                            if (!busStandVis.contains(busStand))
                            {
                                que.addLast(busStand);
                                busStandVis.add(busStand);
                            }
                        }
                        busVis[bus] = true;
                    }
                }
                level++;
            }

            return -1;
        }
}