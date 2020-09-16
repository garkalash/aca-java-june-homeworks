package com.aca.armine.binarytree;

public class Ex3 {

    public boolean checkFullOrNot(Node root) {
        if (root == null) {
            return true;
        }
        if ((root.getRight() == null && root.getLeft() == null) || root.getLeft() != null && root.getRight() != null){
            return true;
        }
        return (checkFullOrNot(root.getLeft()) && checkFullOrNot(root.getRight()));
    }


}
