package task2;

public class FibonacciHeap {

    static class Node {
        int key;
        int degree;
        boolean marked;
        Node parent;
        Node child;
        Node left;
        Node right;

        Node(int key) {
            this.key = key;
            this.degree = 0;
            this.marked = false;
            this.parent = null;
            this.child = null;
            this.left = this;
            this.right = this;
        }
    }

    private Node minNode;
    private int size;

    public FibonacciHeap() {
        this.minNode = null;
        this.size = 0;
    }

    public void insert(int key) {
        Node node = new Node(key);
        if (minNode == null) {
            minNode = node;
        } else {
            addToRootList(node);
            if (node.key < minNode.key) {
                minNode = node;
            }
        }
        size++;
    }

    public int getMin() {
        if (minNode == null) {
            throw new IllegalStateException("Heap is empty");
        }
        return minNode.key;
    }

    public int extractMin() {
        if (minNode == null) {
            throw new IllegalStateException("Heap is empty");
        }
        Node min = minNode;
        if (min.child != null) {
            Node child = min.child;
            do {
                Node nextChild = child.right;
                addToRootList(child);
                child.parent = null;
                child = nextChild;
            } while (child != min.child);
        }
        removeFromRootList(min);
        if (min == min.right) {
            minNode = null;
        } else {
            minNode = min.right;
            consolidate();
        }
        size--;
        return min.key;
    }

    private void addToRootList(Node node) {
        node.left = minNode;
        node.right = minNode.right;
        minNode.right.left = node;
        minNode.right = node;
    }

    private void removeFromRootList(Node node) {
        node.left.right = node.right;
        node.right.left = node.left;
    }

    private void consolidate() {
        int maxDegree = (int) Math.floor(Math.log(size) / Math.log((1 + Math.sqrt(5)) / 2)) + 1;
        Node[] degreeTable = new Node[maxDegree];
        Node current = minNode;
        do {
            Node next = current.right;
            int degree = current.degree;
            while (degreeTable[degree] != null) {
                Node other = degreeTable[degree];
                if (current.key > other.key) {
                    Node temp = current;
                    current = other;
                    other = temp;
                }
                link(other, current);
                degreeTable[degree] = null;
                degree++;
            }
            degreeTable[degree] = current;
            current = next;
        } while (current != minNode);
        minNode = null;
        for (Node node : degreeTable) {
            if (node != null) {
                if (minNode == null) {
                    minNode = node;
                } else {
                    addToRootList(node);
                    if (node.key < minNode.key) {
                        minNode = node;
                    }
                }
            }
        }
    }

    private void link(Node child, Node parent) {
        removeFromRootList(child);
        child.left = child.right = child;
        if (parent.child == null) {
            parent.child = child;
        } else {
            child.right = parent.child.right;
            child.left = parent.child;
            parent.child.right.left = child;
            parent.child.right = child;
        }
        child.parent = parent;
        parent.degree++;
        child.marked = false;
    }

    public void decreaseKey(Node node, int newKey) {
        if (newKey > node.key) {
            throw new IllegalArgumentException("New key is greater than current key");
        }
        node.key = newKey;
        Node parent = node.parent;
        if (parent != null && node.key < parent.key) {
            cut(node, parent);
            cascadingCut(parent);
        }
        if (node.key < minNode.key) {
            minNode = node;
        }
    }

    private void cut(Node node, Node parent) {
        removeFromChildList(parent, node);
        parent.degree--;
        addToRootList(node);
        node.parent = null;
        node.marked = false;
    }

    private void cascadingCut(Node node) {
        Node parent = node.parent;
        if (parent != null) {
            if (!node.marked) {
                node.marked = true;
            } else {
                cut(node, parent);
                cascadingCut(parent);
            }
        }
    }

    private void removeFromChildList(Node parent, Node child) {
        if (parent.child == parent.child.right) {
            parent.child = null;
        } else if (parent.child == child) {
            parent.child = child.right;
        }
        child.left.right = child.right;
        child.right.left = child.left;
    }

    public boolean isEmpty() {
        return minNode == null;
    }

    public int size() {
        return size;
    }
}
