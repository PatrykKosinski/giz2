public class ArticulationPointFinder {

    public  Node[] nodes;
    //public  StringBuilder bridges = new StringBuilder();

    public ArticulationPointFinder(Node[] nodes, StringBuilder bridges) {
        this.nodes = nodes;
        //this.bridges = bridges;
    }

    public  String getResult() {
        for (int i = 1; i < nodes.length; i++) {
            if (!nodes[i].wasVisited) {
                DFS(1, i, -1);

            }
        }
        return "dupa";
    }


    public int DFS(int indexDFS, int currentNodeNumber, int parentNode) {

        Node currentNode = nodes[currentNodeNumber];
        currentNode.indexDFS = indexDFS;
        currentNode.low = indexDFS;

        int test = 0;

        for (int i = 0; i < currentNode.listOfNodes.size(); i++) {
            Node neighbour = currentNode.listOfNodes.get(i);
            if (neighbour.number != parentNode) {
                if (!(neighbour.indexDFS>0)) {
                    int nestedLow = DFS(indexDFS + 1, neighbour.number, currentNodeNumber);
                    if (nestedLow < currentNode.low) {
                        currentNode.low = nestedLow;
                    }
                    if(nestedLow<currentNode.low){
                        currentNode.low = nestedLow;
                    }
                    if (nestedLow >=currentNode.indexDFS){
                        test = 1;
                    }

                }else if (neighbour.indexDFS < currentNode.low) {
                    currentNode.low = neighbour.indexDFS;
                }
            }
        }

        if (test ==1){
            System.out.println("Found articulation point: "+ currentNodeNumber);
        }

        return currentNode.low;
    }



}
