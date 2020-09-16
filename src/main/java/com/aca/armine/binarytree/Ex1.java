package com.aca.armine.binarytree;

public class Ex1 {

    public boolean checkBalance(Node root) {
        int result = isBalanced(root);
        return result > 0;
    }

    private int isBalanced(Node root) {
        if (root == null) {
            return 0;
        }
        int leftSubTreeHeight = isBalanced(root.getLeft());
        if (leftSubTreeHeight == -1) {
            return -1;
        }
        int rightSubTreeHeight = isBalanced(root.getRight());
        if (rightSubTreeHeight == -1) {
            return -1;
        }
        if (Math.abs(leftSubTreeHeight - rightSubTreeHeight) > 1) {
            return -1;

        }
        return Math.max(leftSubTreeHeight, rightSubTreeHeight) + 1;

    }

}
