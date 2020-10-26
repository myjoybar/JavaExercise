package sort.test.fortest;


/**
 * LRU，尾部删除法
 * @param <T>
 */
public class LRUTest<T> {

    private int maxCount;
    private int size;
    private Node<T> head;

    public LRUTest(int maxCount) {
        this.maxCount = maxCount;
    }

    /**
     * 如果超出最大容量，就先删除尾部
     *
     * @param value
     */
    public void add(Node value) {
        if (isOverToMaxCount()) {
            System.out.println("size = " + size);
            deleteTail();
        }
        insertToHead(value);
    }


    public void get(Node value) {
        Pair<Node<T>> pair = findNode(value);
        if (pair != findNode(value)) {
            // 移除Node节点
            Node targetNode = pair.getSecond();
            Node beforeTargetNode = pair.getFirst();
            beforeTargetNode.setNext(targetNode.getNext());

            // 再把Node节点插入到链表头部
            insertToHead(targetNode);
        }
    }

    private Pair<Node<T>> findNode(Node value) {
        // second 是查找到的节点，first 是前一个节点
        Pair<Node<T>> pair = null;
        if (value != null) {
            Node node = head;
            while (node != null && node.getNext() != null) {

                if (value == node) {
                    pair = new Pair<>(null, node);
                    break;
                }
                if (value == node.getNext()) {
                    // 头节点
                    pair = new Pair<>(node, node.getNext());
                    break;
                }

                node = node.getNext();
            }
        }
        return pair;
    }

    /**
     * 判断是否超出最大容量
     *
     * @return
     */
    private boolean isOverToMaxCount() {
        return size >= maxCount;
    }

    /**
     * 将指定节点插入链表头部
     *
     * @param node
     */
    private void insertToHead(Node<T> node) {
        if (head == null) {
            head = node;
        } else {
            node.setNext(head);
            head = node;
        }
        size++;

    }

    private void insertToTail() {
        // TODO: 2020/10/23
    }

    /**
     * 删除链表尾部节点
     */
    private void deleteTail() {
        Node tail = getTail();
        Node node = head;

        System.out.println("delete tail = " + tail.getValue());

        while ( node.getNext() != null) {
            // 如果是倒数第二个节点，则把tail节点清空
            if (node.getNext() == tail) {
                tail = null;
                node.setNext(null);
            } else {
                node = node.getNext();
            }
        }
        size--;
    }

    /**
     * 获取链表尾部节点
     *
     * @return
     */
    private Node<T> getTail() {
        Node node = head;
        while (node.getNext() != null) {
            node = node.getNext();
        }
        return node;
    }


    public void loop() {
        Node node = head;
        while (node != null) {
            System.out.println(node.getValue());
            if (node.getNext() != null) {
                node = node.getNext();
            }else {
                break;
            }
        }

    }

}
