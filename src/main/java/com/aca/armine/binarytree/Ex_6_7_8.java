package com.aca.armine.binarytree;

public class Ex_6_7_8 {

//ex6
    public Integer getsNodesKeySum(Node node) {
        Integer sum = 0;
        if (node == null) {
            return 0;
        }
        sum = sum + node.getKey();
        getsNodesKeySum(node.getLeft());
        getsNodesKeySum(node.getRight());

        return sum;
    }
//ex7
    public boolean areBinaryTreesEqual(Node root1, Node root2) {
        if (root1 == null && root2 == null) {
            return true;
        } else if (root1 == null || root2 == null) {
            return false;
        } else return root1.getKey()== root2.getKey() &&
                areBinaryTreesEqual(root1.getLeft(), root2.getLeft()) &&
                areBinaryTreesEqual(root1.getRight(), root2.getRight());
    }


//ex8
    public Integer getBSTDepth(Integer key, Node root) {
        Integer depth = 0;
        if (root == null) {
            return 0;
        }

        if (key > root.getKey()) {
            depth++;
            getBSTDepth(key, root.getRight());
        } else if (key < root.getKey()) {
            depth++;
            getBSTDepth(key, root.getLeft());
        }
        return depth;

    }

}
