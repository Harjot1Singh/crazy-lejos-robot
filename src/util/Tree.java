package util;

import java.io.Serializable;
import java.util.Iterator;

public class Tree<T> implements Serializable {
    private Node<T> root;

    public Tree(Node<T> root) {
        this.root = root;
    }

    public Node<T> getRoot() {
        return root;
    }

    public static class Node<T> implements Serializable, Iterable<T> {
        private Node<T> left;
        private Node<T> right;
        private Node<T> ahead;
        private Node<T> parent;

        public Node(Node<T> parent, Node<T> left, Node<T> right, Node<T> ahead) {
            this.parent = parent;
            this.ahead = ahead;
            this.left = left;
            this.right = right;
        }

        public void setLeft(Node<T> left) {
            this.left = left;
        }

        public void setAhead(Node<T> ahead) {
            this.ahead = ahead;
        }

        public void setRight(Node<T> right) {
            this.right = right;
        }

        public Node<T> getAhead() {
            return ahead;
        }

        public Node<T> getRight() {
            return right;
        }

        public Node<T> getLeft() {
            return left;
        }

        public Node<T> getParent() {
            return parent;
        }

        @Override
        public Iterator<T> iterator() {
            return null;
        }
    }
}
