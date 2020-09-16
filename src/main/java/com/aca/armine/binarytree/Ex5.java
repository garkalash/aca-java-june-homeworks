package com.aca.armine.binarytree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Ex5 {

    private void preOrder(Node root, int level, Map<Integer, ArrayList<Integer>> nodesKeyByLevel) {
        if (root == null) {
            return;
        }
        nodesKeyByLevel.putIfAbsent(level, new ArrayList<>());
        nodesKeyByLevel.get(level).add(root.getKey());

        preOrder(root.getLeft(), level + 1, nodesKeyByLevel);
        preOrder(root.getRight(), level + 1, nodesKeyByLevel);
    }

    public Optional<Integer> getNodDepth(Integer key, Node root) {
        Map<Integer, ArrayList<Integer>> nodesKeyByLevel = new HashMap<>();
        preOrder(root, 1, nodesKeyByLevel);

        for (int i = 1; i <= nodesKeyByLevel.size(); i++) {

            boolean finedNode = nodesKeyByLevel.get(i).stream()
                    .anyMatch(integer -> integer.equals(key));
            if (finedNode) {
                return Optional.of(i - 1);
            }
        }
        return Optional.empty();
    }


}
