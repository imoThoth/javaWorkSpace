import java.util.Set;

public class DepthFirstSearch {
    static class Node {

        int value;
        Node left;
        Node right;

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }

    }

    boolean depthFirstSearch(Node node, Set<Node> visited, int goal){
        if(node == null) return false;

        if(node.value == goal){
            return true;
        }

        for(Node neighbour: node.getNeighbours()){
            if(visited.contains(neighbour)) continue;
            visited.add(neighbour);
            boolean isFound = depthFirstSearch(neighbour, visited, goal);


            if(isFound) return true;
        }

        return false;


    }

    public static void main(String[] args) {

    }
}
