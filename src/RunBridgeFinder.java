import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class RunBridgeFinder {

    public static Node[] nodes;
    public static StringBuilder bridges = new StringBuilder();

    public static void main(String[] args) throws IOException {

        FileReader fileReader = new FileReader("graph.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        int lineNumber = 0;

        String line = bufferedReader.readLine();

        while (line != null) {
            lineNumber++;
            line = bufferedReader.readLine();
        }

        int numberOfNodes = --lineNumber;

        //the array of nodes
        nodes = new Node[numberOfNodes + 1];

        //add all nodes
        for (int i = 1; i <= numberOfNodes; i++) {
            nodes[i] = new Node(i);
        }

        //add neighbours of node
        FileReader fileReader2 = new FileReader("graph.txt");
        BufferedReader bufferedReader2 = new BufferedReader(fileReader2);
        String root = bufferedReader2.readLine();
        int temp = 0;
        for (int i = 1; i <= numberOfNodes; i++) {
            temp++;
            String lowerNodeString = bufferedReader2.readLine();
            lowerNodeString.split(" ");

            for (int j = 0; j < lowerNodeString.length(); j++) {

                if (String.valueOf(lowerNodeString.charAt(j)).equals(" ")) {
                    j++;
                }
                nodes[temp].addNode(nodes[Character.getNumericValue(lowerNodeString.charAt(j))]);
                System.out.println("\nAdded lower node: " + lowerNodeString.charAt(j) + " node: " + temp);

                nodes[Character.getNumericValue(lowerNodeString.charAt(j))].addNode(nodes[temp]);
                System.out.println("Added lower node: " + temp + " to node: " + lowerNodeString.charAt(j));

            }

        }
        BridgeFinder bridgeFinder = new BridgeFinder(nodes, bridges);
        bridgeFinder.getResult();
    }





}
