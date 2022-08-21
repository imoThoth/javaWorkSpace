public class ReverseLinkedList {

    static class Node {
        private int val;
        private Node next;

        public Node(int val){
            this.val = val;
        }

        public void setNext(Node node){
            this.next = node;
        }

        public Node getNext(){
            return next;
        }
    }

    public static Node reverseList(Node node){
        if(node == null || node.next == null) {
            return node;
        }

        Node p = reverseList(node.next);
        node.next.next = node;
        node.next = null;
        return p;
    }

    public static void printLinkedList(Node node){
        Node tmp = node;
        while (tmp != null){
            System.out.println(tmp.val + " ");
            tmp = tmp.getNext();
        }
    }

    public static void main(String[] args) {

        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);

        n1.setNext(n2);
        n2.setNext(n3);
        n3.setNext(n4);
        n4.setNext(n5);

        printLinkedList(n1);
        Node reversed = reverseList(n1);
        System.out.println("");
        printLinkedList(reversed);


    }
}
