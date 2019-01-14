package sort;

/**
 * Created by joybar on 2019/1/10.
 */
public class NodeCircleJudge {

    public static void main(String[] args) {

        Node node12 = new Node(12, null);
        Node node11 = new Node(11, node12);
        Node node10 = new Node(10, node11);
        Node node9 = new Node(9, node10);
        Node node8 = new Node(8, node9);
        Node node7 = new Node(7, node8);
        Node node6 = new Node(6, node7);
        Node node5 = new Node(5, node6);
        Node node4 = new Node(4, node5);
        Node node3 = new Node(3, node4);
        Node node2 = new Node(2, node3);
        Node node1 = new Node(1, node2);

        node12.setNext(node10);

        System.out.println("isCircleNodeList====="+isCircleNodeList(node1));
        System.out.println("isCircleNodeList2====="+isCircleNodeList2(node1));
//        loopNode(node1);
//        nodeConverse(node1);
//
//        System.out.println("=====");
//        loopNode(node12);


    }

    public static boolean isCircleNodeList(Node head){

        while (null != head) {
            System.out.print(head.getValue()+" ");
            if(head.isVisited){
                return true;
            }
            head.isVisited = true;
            head = head.getNext();
        }
        return false;
    }


    public static boolean isCircleNodeList2(Node head){

        Node headSlow = head;
        Node headFast = head;

        while (null != headSlow &&headFast!=null) {
            System.out.print(headSlow.getValue()+" ");
            headSlow = headSlow.getNext();
            if(headFast.getNext()!=null){
                headFast =headFast.getNext().getNext();
            }
            if(headSlow==headFast){
                return true;
            }

        }
        return false;
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
        private boolean isVisited;

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
