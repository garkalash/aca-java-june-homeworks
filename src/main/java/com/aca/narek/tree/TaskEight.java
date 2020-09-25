package com.aca.narek.tree;

public class TaskEight {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(8);
        tree.root.left = new Node(3);
        tree.root.right = new Node(10);
        tree.root.left.left = new Node(1);
        tree.root.left.right = new Node(6);
        tree.root.left.right.left = new Node(4);

        System.out.println("The depth of 11 is: " + tree.getLevelByKey(tree.root, 11));
        System.out.println("The depth of 4 is: " + tree.getLevelByKey(tree.root, 4));
    }
}
