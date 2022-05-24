package com.citrys.app.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeNode <T extends Comparable<T>> {
    public T getVal() {
        return val;
    }

    public void setVal(T val) {
        this.val = val;
    }

    public TreeNode<T> getLeft() {
        return left;
    }

    public void setLeft(TreeNode<T> left) {
        this.left = left;
    }

    public TreeNode<T> getRight() {
        return right;
    }

    public void setRight(TreeNode<T> right) {
        this.right = right;
    }

    private T val;
    private TreeNode<T> left = null;
    private TreeNode<T> right = null;

    TreeNode(T value)  {
        this.val = value;
    }

    void insert(T value) {
        if (val == value) {return;}
        if (value.compareTo(val) < 0) {
            if (left == null) {
                left = new TreeNode<>(value);
            } else {
                left.insert(value);
            }
        } else {
            if (right == null) {
                right = new TreeNode<>(value);
            } else {
                right.insert(value);
            }
        }
    }

    boolean search(T value) {
        if (val == value) {
            return true;
        }
        if (value.compareTo(val) < 0) {
            if (left != null) {
                return left.search(value);
            }
        } else {
            if (right != null) {
                return right.search(value);
            }
        }
        return false;
    }

    T min() {
        if (left == null && val != null) {
            return val;
        }
        T min = null;
        while (left != null) {
            min  = left.val;
            left = left.left;
        }
        return min;
    }

    T max() {
        if (right == null && val != null) {
            return val;
        }
        T max = null;
        while (right != null) {
            max  = right.val;
            right = right.right;
        }
        return max;
    }


    void traverseInOrder() {
        if (left != null) {
            left.traverseInOrder();
        }
        System.out.print(val + ", ");
        if (right != null) {
            right.traverseInOrder();
        }
    }

    void traversePreOrder(){
        System.out.print(val + ", ");
        if (left != null) {
            left.traversePreOrder();
        }
        if (right != null) {
            right.traversePreOrder();
        }
    }

    List<List<T>> levelTraversal() {
        List<List<T>> result = new ArrayList<>();
        Queue<TreeNode<T>> queue = new LinkedList<>();
        queue.offer(this);
        while (!queue.isEmpty()) {
            List<T> interim = new LinkedList<>();
            int size = queue.size();
            for (int i = 0; i < size; ++ i) {
                TreeNode<T> node = queue.poll();
                if (node.val != null) interim.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            result.add(interim);
        }
        return result;
    }

}
