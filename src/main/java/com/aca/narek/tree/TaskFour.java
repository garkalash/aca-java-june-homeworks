package com.aca.narek.tree;

public class TaskFour {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.left.left.left = new Node(8);

        if (tree.isPerfect(tree.root) == true)
            System.out.println("Tree is perfect");
        else
            System.out.println("Tree is not perfect");
    }
}
