/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    Map<Node, Node> deepNode = new HashMap();
    public Node cloneGraph(Node node) {
        if(node == null) return null;
        deepNode.put(node, new Node(node.val));
        Queue<Node> queue = new LinkedList();
        queue.offer(node);

        while(!queue.isEmpty()){
            Node curr = queue.poll();
            for(Node neighbor : curr.neighbors){
                if(!deepNode.containsKey(neighbor)){
                    deepNode.put(neighbor, new Node(neighbor.val));
                    queue.offer(neighbor);
                }
                deepNode.get(curr).neighbors.add(deepNode.get(neighbor));
            }
        }
        return deepNode.get(node);
    }
}