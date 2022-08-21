import java.util.*;

public class BinarySearchInsert {

    // TODO
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

    public static void printLeaves(Node root){
        if(root == null) return;

        // check if given node is a leaf
        if(root.left == null && root.right == null){
            System.out.println(root.value + ", ");
            return;
        }

        if(root.left != null) printLeaves(root.left);

        if(root.right != null) printLeaves(root.right);
    }

    public static Node insertNode(Node head, int data){
        if(head == null){
            head = new Node();
            head.value = data;
            return head;
        }

        // if data greater than node... recurse right or left
        if(head.value < data){
            head.right = insertNode(head.right, data);
        }else{
            head.left = insertNode(head.left, data);
        }

        // return the original root node of tree
        return head;

    }


    public static void main(String[] args) {

        List<Integer> dataInput = List.of(20, 201, 2012, 90, 23, 45, 65, 786, 45);

        Node root = null;

        for(Integer node: dataInput){
            root = insertNode(root, node);
        }

        printLeaves(root);
    }
}
