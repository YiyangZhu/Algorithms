package G;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class CloneGraph {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null){
            return null;
        }

        LinkedList<UndirectedGraphNode> queue = new LinkedList<>();
        HashMap<UndirectedGraphNode,UndirectedGraphNode> map = new HashMap<>();

        UndirectedGraphNode newHead = new UndirectedGraphNode(node.label);
        queue.add(newHead);
        map.put(node,newHead);

        while(!queue.isEmpty()){
            UndirectedGraphNode n = queue.pop();
            List<UndirectedGraphNode> list = n.neighbors;

            for(UndirectedGraphNode aNeighbor: list){
                if(map.containsKey(aNeighbor)){
                    map.get(n).neighbors.add(aNeighbor);
                } else {
                    queue.add(aNeighbor);
                    UndirectedGraphNode copied = new UndirectedGraphNode(aNeighbor.label);
                    map.put(aNeighbor,copied );
                    map.get(n).neighbors.add(copied);
                }

            }
        }
        return newHead;

    }

}
