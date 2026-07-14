class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
                                       Comparator.comparingInt(a -> a[0]));
        Map<Integer, List<int[]>> edges = new HashMap();
        for(int[] time : times){
            edges.computeIfAbsent(time[0], val -> new ArrayList<>()).add(new int[]{time[1], time[2]});
        }

        minHeap.offer(new int[]{0, k});
        Set<Integer> visited = new HashSet();
        int t = 0;
        while(!minHeap.isEmpty()){
            int[] curr = minHeap.poll();
            int time = curr[0], node = curr[1];
            if(visited.contains(node)){
                continue;
            }
            visited.add(node);
            t = time;
            if(edges.containsKey(node)){
            for(int[] neigh : edges.get(curr[1])){
                int time2 = neigh[1], neighborNode = neigh[0];
                if(!visited.contains(neighborNode)){
                    minHeap.offer(new int[]{ time2 + time , neighborNode});
                }
            }
            }
        }
        return visited.size() == n ? t : -1;
    }
}
