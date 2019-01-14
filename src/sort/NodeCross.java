package sort;

/**
 * Created by joybar on 2019/1/10.
 */
public class NodeCross {

    //https://blog.csdn.net/dawn_after_dark/article/details/73864643
    //https://www.jianshu.com/p/634c147fe2a9
    //https://blog.csdn.net/happymatilian/article/details/47811161

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


        Node nodeHead1 = new Node(1, node2);


        // Node nodeHeadTest = new Node(1, null);

        Node nodeHead2 = new Node(1, node6);


        //  node12.setNext(node10);

        System.out.println("isCircleNodeList2=====" + isCircleNodeList2(nodeHead1));
        System.out.println("isCircleNodeList2=====" + isCircleNodeList2(nodeHead2));
        loopNode(nodeHead1);
        loopNode(nodeHead2);

        System.out.println("");
        isCross(nodeHead1, nodeHead2);
        getCrossNode(nodeHead1, nodeHead2);
//        nodeConverse(node1);
//
//        System.out.println("=====");
//        loopNode(node12);


    }


    public static boolean isCross(Node head1, Node head2) {

        boolean nodeFirstHasCircle = isCircleNodeList2(head1);
        boolean nodeSecondHasCircle = isCircleNodeList2(head2);

        if (!nodeFirstHasCircle && !nodeSecondHasCircle) {
            System.out.println("");
            Node firstTail = getLastNode(head1);
            Node secondTail = getLastNode(head2);

            System.out.println("firstTail.getValue()=====" + firstTail.getValue());
            System.out.println("secondTail.getValue()=====" + secondTail.getValue());
            return firstTail == secondTail;
        }

        return false;

    }


    public static Node getCrossNode(Node head1, Node head2) {

        int count1 = getLength(head1);
        int count2 = getLength(head2);
        System.out.println("count1 = " + count1);
        System.out.println("count2 = " + count2);

        Node headLongger = head1;
        Node headShoter = head2;
        if(count1<count2){
            headLongger = head2;
            headShoter = head1;
        }
        int offset = Math.abs(count2-count1);

        System.out.println("offset = " + offset);

        int count = 0;
        while (headLongger!=null&&count<offset){
            count++;
            headLongger=headLongger.getNext();
        }
        System.out.println("headLongger.getValue = " + headLongger.getValue());



        while (headLongger!=null&&headShoter!=null){
            if(headLongger==headShoter){
                System.out.println("the cross node value is  = " + headLongger.getValue());
                return headLongger;
            }
            headLongger=headLongger.getNext();
            headShoter=headShoter.getNext();
        }


        return null;

    }


    public static int getLength(Node head) {
        int count = 0;
        while (null != head) {
            System.out.print(head.getValue() + " ");
            head = head.getNext();
            count++;
        }
        return count;
    }


    public static boolean isCircleNodeList2(Node head) {

        Node headSlow = head;
        Node headFast = head;

        while (null != headSlow && headFast != null) {
            // System.out.print(headSlow.getValue()+" ");
            headSlow = headSlow.getNext();
            if (headFast.getNext() != null) {
                headFast = headFast.getNext().getNext();
            }
            if (headSlow == headFast) {
                return true;
            }

        }
        return false;
    }


    public static Node getLastNode(Node head) {
        Node tail = null;
        while (null != head) {
            head = head.getNext();
            if (head != null) {
                tail = head;
            }
        }
        return tail;
    }


    public static void loopNode(Node head) {

        while (null != head) {
            System.out.print(head.getValue() + " ");
            head = head.getNext();
        }
        System.out.println("");
    }


    public static void loopNodeConverse(Node head) {

        while (null != head) {
            System.out.print(head.getValue() + " ");
            head = head.getNext();
        }
        System.out.println("");
    }


    public static Node nodeConverse(Node head) {
        Node pre = null;
        if (null != head) {
            pre = head;
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
        return pre;
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
