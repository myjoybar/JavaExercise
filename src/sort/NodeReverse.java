package sort;

/**
 * Created by joybar on 2019/1/10.
 */
public class NodeReverse {

    public static void main(String[] args) {

        Node node5 = new Node(5, null);
        Node node4 = new Node(4, node5);
        Node node3 = new Node(3, node4);
        Node node2 = new Node(2, node3);
        Node node1 = new Node(1, node2);
        loopNode(node1);
        nodeConverse(node1);
        //reverse(node1);

        System.out.println("=====");
        loopNode(node5);


    }


    public static void loopNode(Node head) {

        while (null != head) {
            System.out.print(head.getValue()+" ");
            head = head.getNext();
        }
    }

    public static void nodeConverse(Node head) {
        if (null != head) {
            Node pre = head;
            Node cur = pre.getNext();

            while (null != cur) {
               // System.out.println("cur.getValue====="+cur.getValue());
                Node next = cur.getNext();
                cur.setNext(pre);
                pre = cur;
                cur = next;

            }
            head.setNext(null);
        }
    }




    private static class Node {
        private int value;
        private Node next;

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }
}
