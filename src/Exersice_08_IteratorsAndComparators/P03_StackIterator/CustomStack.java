package Exersice_08_IteratorsAndComparators.P03_StackIterator;

import java.util.Iterator;

public class CustomStack implements Iterable<Integer> {

    private Node top;

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<>() {

            private Node currentNode = top;

            @Override
            public boolean hasNext() {
                return currentNode != null;
            }

            @Override
            public Integer next() {
                int element = currentNode.element;
                currentNode = currentNode.previous;
                return element;
            }
        };
    }

    private class Node {
        private int element;
        private Node previous;

        public Node(int element) {
            this.element = element;
        }
    }

    public void push(int element) {
        Node newNode = new Node(element);
        if (this.top != null) {
            newNode.previous = this.top;
        }
        this.top = newNode;
    }

    public int pop() {
        if (this.top == null) {
            throw new IllegalStateException("No Elements");
        }
        int poppedElement = this.top.element;
        this.top = this.top.previous;
        return poppedElement;
    }
}
