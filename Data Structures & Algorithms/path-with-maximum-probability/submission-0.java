class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        Map<Integer, List<double[]>> map = new HashMap();
        int i = 0;
        for(int[] edge : edges){
            map.computeIfAbsent(edge[0], val -> new ArrayList<>()).add(new double[]{ edge[1], succProb[i]});
            map.computeIfAbsent(edge[1], val -> new ArrayList<>()).add(new double[]{ edge[0], succProb[i]});
            i++;
        }

        PriorityQueue<double[]> minHeap = new PriorityQueue<>((a, b) -> Double.compare(b[1], a[1]));
        double[] maxProb = new double[n];
        maxProb[start_node] = 1.0;
        minHeap.offer(new double[]{ start_node, 1.0});

        while(!minHeap.isEmpty()){
            double[] curr= minHeap.poll();
            int currNode = (int) curr[0];
            double prob = curr[1];

            if(currNode == end_node) return prob;
            if(prob < maxProb[currNode]) continue;

            for(double[] neigh : map.getOrDefault(currNode, new ArrayList<>())){
                int neighNode = (int) neigh[0];
                double neighProb =  prob * neigh[1];
                if(neighProb > maxProb[neighNode]){
                    maxProb[neighNode] = neighProb;
                    minHeap.offer(new double[]{ neighNode, neighProb});
                }
            }

        }

        return 0.0;
    }
}