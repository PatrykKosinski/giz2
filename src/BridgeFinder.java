public class BridgeFinder {

    public  Node[] nodes;
    //public  StringBuilder bridges = new StringBuilder();

    public BridgeFinder(Node[] nodes, StringBuilder bridges) {
        this.nodes = nodes;
        //this.bridges = bridges;
    }

    public  String getResult() {
        for (int i = 1; i < nodes.length; i++) {
            if (!nodes[i].wasVisited) {
                DFS(1, i, -1);

            }
        }
        return " ";
    }


    public int DFS(int indexDFS, int currentNodeNumber, int parentNode) {

        Node currentNode = nodes[currentNodeNumber];
        currentNode.indexDFS = indexDFS;
        currentNode.low = indexDFS;

        for (int i = 0; i < currentNode.listOfNodes.size(); i++) {

            Node neighbour = currentNode.listOfNodes.get(i);
            if (neighbour.number != parentNode) {
                if (!(neighbour.indexDFS>0)) {
                    int nestedLow = DFS(indexDFS + 1, neighbour.number, currentNodeNumber);
                    if (nestedLow < currentNode.low) {
                        currentNode.low = nestedLow;
                    }

                }else if (neighbour.indexDFS < currentNode.low) {
                    currentNode.low = neighbour.indexDFS;
                }
            }
        }


        if (parentNode > -1 && currentNode.indexDFS == currentNode.low) {
            System.out.println("Found bridge: " + parentNode + " - " + currentNodeNumber);
           // bridges.append(parentNode + currentNodeNumber);
        }
        return currentNode.low;
    }



}
