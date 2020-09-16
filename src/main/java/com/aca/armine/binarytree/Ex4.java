package com.aca.armine.binarytree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Ex4 {
    private void preOrder(Node root, int level, Map<Integer, ArrayList<Node>> nodesByLevel) {

        if (root == null) {
            return;
        }
        nodesByLevel.putIfAbsent(level, new ArrayList<>());
        nodesByLevel.get(level).add(root);
        preOrder(root.getLeft(), level + 1, nodesByLevel);
        preOrder(root.getRight(), level + 1, nodesByLevel);
    }

    public boolean checkPerfectOrNot(Node root) {
        Map<Integer, ArrayList<Node>> map = new HashMap<>();
        preOrder(root, 1, map);
        for (int i = 1; i <= map.size(); i++) {
            if (map.get(i).size() < Math.pow(2, i - 1)) {
                return false;
            }
        }
        return true;
    }


}
