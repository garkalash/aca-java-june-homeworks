package com.aca.narek.tree;

public class TaskSeven {
    public static void main(String[] args) {
        BinaryTree tree1 = new BinaryTree();
        tree1.root = new Node(1);
        tree1.root.left = new Node(2);
        tree1.root.right = new Node(3);
        tree1.root.left.left = new Node(4);
        tree1.root.left.right = new Node(5);
        tree1.root.left.left.left = new Node(6);

        BinaryTree tree2 = new BinaryTree();
        tree2.root = new Node(1);
        tree2.root.left = new Node(2);
        tree2.root.right = new Node(3);
        tree2.root.left.left = new Node(4);
        tree2.root.left.right = new Node(5);
        tree2.root.left.left.left = new Node(6);

        TaskSeven tsk7 = new TaskSeven();

        if (tsk7.isTreeEqual(tree1.root, tree2.root)) {
            System.out.println("Trees is equal");
        } else {
            System.out.println("Tree is not equal");
        }

        tree2.root.right.right = new Node(3);

        if (tsk7.isTreeEqual(tree1.root, tree2.root)) {
            System.out.println("Trees is equal");
        } else {
            System.out.println("Trees is not equal");
        }
    }

    public boolean isTreeEqual(Node node1, Node node2) {
        if (node1 == null && node2 == null)
            return true;

        if (node1 != null && node2 == null)
            return false;

        if (node1 == null && node2 != null)
            return false;

        return node1.data == node2.data && isTreeEqual(node1.left, node2.left) && isTreeEqual(node1.right, node2.right);
    }
}
