package com.citrys.app.trees;

import java.util.ArrayList;
import java.util.List;

class MyTree<T extends Comparable<T>> {
    private TreeNode<T> root;

    void insert(T value) {
        if (root == null) {
            root = new TreeNode<T>(value);
        } else {
            root.insert(value);
        }
    }

    void traverse(){
        if (root == null) {
            System.out.println("Empty tree");
        }
        else root.traverseInOrder();
    }

    boolean search(T value) {
        if (root == null) {
            return false;
        }
        return root.search(value);
    }

    void delete(T value) {
        root = delete(root, value);
    }

    private TreeNode<T> delete(TreeNode<T> subtree, T value) {
        if (subtree == null) {
            return null;
        }
        if (value.compareTo(subtree.getVal()) < 0) {
            subtree.setLeft(delete(subtree.getLeft(), value));
        } else  if (value.compareTo(subtree.getVal()) > 0) {
            subtree.setRight(delete(subtree.getRight(), value));
        }
        else {
            if (subtree.getLeft() == null) {
                return subtree.getRight();
            }
            else if (subtree.getRight() == null) {
                return subtree.getLeft();
            }

            subtree.setVal(subtree.getRight().min());

            subtree.setRight(delete(subtree.getRight(), subtree.getVal()));

        }
        return subtree;
    }

    T min(){
        if (root == null) {
            return null;
        } else {
            return root.min();
        }
    }

    T max(){
        if (root == null) {
            return null;
        } else {
            return root.max();
        }
    }

    void traversePreOrder(){
        if (root == null) {
            System.out.println("Empty tree");
        }
        else root.traversePreOrder();
    }

    List<List<T>> levelTraversal() throws Exception {
        if (root != null) {
            return root.levelTraversal();
        } else {
            throw new Exception("Null tree");
        }
    }

    List<List<T>> rootToLeafPaths() {
        List<List<T>> paths = new ArrayList<>();
        List<T> internal = new ArrayList<>();
        dfs(root, paths, internal);
        return paths;
    }
    private void dfs(TreeNode<T> tree,  List<List<T>> paths, List<T> internal) {
        if (tree == null) {
            return;
        }
        internal.add(tree.getVal());
        if (tree.getLeft() == null && tree.getRight() == null) {
            // important to add as new !
            paths.add(new ArrayList<>(internal));
        } else {
            dfs(tree.getLeft(), paths, internal);
            dfs(tree.getRight(), paths, internal);
        }
        //backtrack
        internal.remove(internal.size() - 1);
    }

    List<T> getMaxSumPath() {
        List<T> maxSumPath = new ArrayList<>();
        maxSumPathDFS(root, maxSumPath, 0);
        return maxSumPath;
    }

    private void maxSumPathDFS(TreeNode<T> node, List<T> maxSumPath, int maxSum) {
        List<T> internal = new ArrayList<>();
        int tempSum = 0;
        if (node == null) {
            return;
        }
        internal.add(node.getVal());
        if (tempSum > maxSum) {
            maxSumPath.clear();
            maxSumPath.addAll(internal);
        } else {
            maxSumPathDFS(node.getLeft(), maxSumPath, tempSum);
            maxSumPathDFS(node.getRight(), maxSumPath, tempSum);
        }
        internal.remove(internal.size()  - 1);
    }
}


class CheckNodes {
    public static void main(String[] args) throws Exception {
        MyTree<Integer> tree = new MyTree<>();
        tree.insert(25);
        tree.insert(20);
        tree.insert(15);
        tree.insert(27);
        tree.insert(30);
        tree.insert(29);
        tree.insert(26);
        tree.insert(22);
        tree.insert(32);
        tree.insert(17);
        System.out.println(tree.levelTraversal());
        System.out.println();
        tree.delete(17);
        System.out.println(tree.levelTraversal());
        tree.insert(17);
        tree.delete(20);
        System.out.println(tree.levelTraversal());


        System.out.println(tree.rootToLeafPaths());

        System.out.println(tree.getMaxSumPath());
    }
}