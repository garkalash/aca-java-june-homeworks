package com.aca.narek.tree;

public class BinaryTree {
    Node root;

    public Integer height(Node node) {
        if (node == null)
            return 0;

        return 1 + Math.max(height(node.left), height(node.right));
    }

    public Integer countNodes(Node root) {
        if (root == null)
            return 0;

        return (1 + countNodes(root.left) + countNodes(root.right));
    }

    public Boolean isTreeBalanced(Node node) {
        Integer leftHeight, rightHeight;

        if (node == null) {
            return true;
        }

        leftHeight = height(node.left);
        rightHeight = height(node.right);

        return Math.abs(leftHeight - rightHeight) <= 1 ? true : false;
    }

    public boolean isComplete(Node root, int index, int number_nodes) {
        if (root == null)
            return true;

        if (index >= number_nodes)
            return false;

        return (isComplete(root.left, 2 * index + 1, number_nodes)
                && isComplete(root.right, 2 * index + 2, number_nodes));
    }

    public boolean isTreeFull(Node node) {
        if(node == null)
            return true;

        if(node.left == null && node.right == null )
            return true;

        if((node.left!=null) && (node.right!=null))
            return (isTreeFull(node.left) && isTreeFull(node.right));

        return false;
    }

    public Integer depth(Node node) {
        int d = 0;

        while (node != null) {
            d++;
            node = node.left;
        }

        return d;
    }

    private boolean isPerfectHelper(Node root, int d, int level) {
        if (root == null)
            return true;

        if (root.left == null && root.right == null)
            return (d == level + 1);

        if (root.left == null || root.right == null)
            return false;

        return isPerfectHelper(root.left, d, level + 1) && isPerfectHelper(root.right, d, level + 1);
    }

    public boolean isPerfect(Node root) {
        int d = depth(root);
        return isPerfectHelper(root, d, 0);
    }

    public Integer sumOfNodesData(Node node) {
        if (node == null)
            return 0;

        return node.data + sumOfNodesData(node.left) + sumOfNodesData(node.right);
    }

    private Integer getLevelByKeyHelper(Node node, Integer data, Integer level) {
        if (node == null)
            return 0;

        if (node.data == data)
            return level;

        Integer lvl = getLevelByKeyHelper(node.right, data, level + 1);
        if (lvl != 0)
            return lvl;

        lvl = getLevelByKeyHelper(node.left, data, level + 1);
        return lvl;
    }

    public Integer getLevelByKey(Node node, Integer data) {
        return getLevelByKeyHelper(node, data, 0);
    }

    private Integer getLevelBSTHelper(Node node, Integer data, Integer level) {
        if (node == null)
            return 0;

        if (node.data == data)
            return level;

        Integer lvl = 0;

        if (node.data < data)
            lvl = getLevelBSTHelper(node.right, data, level + 1);
        if (lvl != 0)
            return lvl;

        if (node.data > data)
            lvl = getLevelBSTHelper(node.left, data, level + 1);
        return lvl;
    }

    public Integer getLevelBST(Node node, Integer data) {
        return getLevelByKeyHelper(node, data, 0);
    }
}
