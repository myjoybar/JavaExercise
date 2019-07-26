package sort;

import java.util.Arrays;

/**
 * Created by joybar on 20/01/19.
 */
public class BtreeSum {

    public static void main(String[] args) {


    }

    public static boolean judgePathSum(int sum, BinaryNode root) {
        if (null == root) {
            return false;
        }
        if (null == root.leftNode && null == root.rightNode && sum - root.value == 0) {
            return true;
        }
        return (judgePathSum(sum - root.value, root.leftNode) || judgePathSum(sum - root.value,
                root.rightNode));
    }

    public static class BinaryNode {
        int value;
        BinaryNode leftNode;
        BinaryNode rightNode;
        public BinaryNode(int value) {
            this.value = value;
        }

        public void setLeftNode(BinaryNode leftNode) {
            this.leftNode = leftNode;
        }

        public void setRightNode(BinaryNode rightNode) {
            this.rightNode = rightNode;
        }
    }

}
