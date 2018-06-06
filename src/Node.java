import java.util.ArrayList;

public class Node {

    public int number;
    public int indexDFS;
    public boolean wasVisited;
    public int low;

    public Node(int number) {
        this.number = number;
    }

    public ArrayList<Node> listOfNodes = new ArrayList<>();

    public void addNode(Node node){
        listOfNodes.add(node);
    }

}
