package com.aca.armine.algoritm.binarytree;

public class Ex1 {


    public int height (Node root) {
        if (root == null) {
            return 0;
        }
       return Math.max(height(root.getLeft()), height(root.getRight())) + 1;
    }

 public boolean isBalanced(Node root) {
        if (root == null) {
            return true;
        }
        int leftSubTreeHeight = height(root.getLeft());
        int rightSubTreeHeight = height(root.getRight());
        return Math.abs(leftSubTreeHeight - rightSubTreeHeight) <= 1;


    }


}
