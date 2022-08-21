public class MergeLinkedLists {

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

    public static Node mergeLists(Node l1, Node l2){
        if(l1 == null) return l2;
        if(l2 == null) return l1;

        if(l1.val < l2.val){
            l1.next = mergeLists(l1.next, l2);
            return l1;
        }else{
            l2.next = mergeLists(l1, l2.next);
            return l2;
        }
    }

    public static void printLinkedList(Node node){
        Node tempValue = node;
        while(tempValue != null){
            System.out.println(tempValue.val + " ");
            tempValue = tempValue.getNext();
        }
    }

    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(25);
        Node n3 = new Node(34);
        Node n4 = new Node(42);
        Node n5 = new Node(51);

        Node m1 = new Node(11);
        Node m2 = new Node(21);
        Node m3 = new Node(23);
        Node m4 = new Node(24);
        Node m5 = new Node(52);

        n1.setNext(n2);
        n2.setNext(n3);
        n3.setNext(n4);
        n4.setNext(n5);


        m1.setNext(m2);
        m2.setNext(m3);
        m3.setNext(m4);
        m4.setNext(m5);

        Node sortedMerge = mergeLists(n1, m1);
        printLinkedList(sortedMerge);

    }
}
