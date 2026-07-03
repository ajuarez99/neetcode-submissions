class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> heap = new PriorityQueue<>(Comparator.comparing(a -> a[0]));
        for(int[] point : points){
            int dis = point[0] * point[0] + point[1] * point[1];
            heap.offer(new int[]{dis,point[0], point[1]});
        }
        int[][] ans = new int[k][2];
        for(int i =0;i < k; i++ ){
            int[] curr= heap.poll();
            ans[i][0] = curr[1];
            ans[i][1] = curr[2];
        }
        return ans;
    }
}
