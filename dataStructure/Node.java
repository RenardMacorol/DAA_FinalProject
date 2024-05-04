package dataStructure;
import employeePackage.*;

public class Node {
    public Employee[] keys;
    public Node[] children;
    public int numKeys;
    boolean leaf;
    int t; // minimum degree

    // Constructor
    Node(int t, boolean leaf) {
        this.t = t;
        this.keys = new Employee[2 * t - 1];
        this.children = new Node[2 * t];
        this.numKeys = 0;
        this.leaf = leaf;
    }

    // Function to traverse all nodes in a subtree rooted with this node
    void traverse() {
        int i;
        for (i = 0; i < this.numKeys; i++) {
            // If this is not leaf, then before printing key[i],
            // traverse the subtree rooted with child children[i].
            if (!this.leaf)
                this.children[i].traverse();
            System.out.print(this.keys[i].getEmpNo()+" ");
        }

        // Print the subtree rooted with last child
        if (!this.leaf)
            this.children[i].traverse();
    }

    // Function to search key k in subtree rooted with this node
    Node search(int k) {
        // Find the first key greater than or equal to k
        int i = 0;
        while (i < this.numKeys && k > this.keys[i].getEmpNo())
            i++;

        // If the found key is equal to k, return this node
        if (i < this.numKeys && this.keys[i].getEmpNo() == k)
            return this;

        // If the key is not found and this is a leaf node
        if (this.leaf)
            return null;

        // Go to the appropriate child
        return this.children[i].search(k);
    }

    // Function to split the child y of this node. i is the index of y in child array
    void splitChild(int i, Node y) {
        // Create a new node which is going to store (t-1) keys of y
        Node z = new Node(y.t, y.leaf);
        z.numKeys = this.t - 1;

        // Copy the last (t-1) keys of y to z
        for (int j = 0; j < this.t - 1; j++)
            z.keys[j] = y.keys[j + this.t];

        // Copy the last t children of y to z
        if (!y.leaf) {
            for (int j = 0; j < this.t; j++)
                z.children[j] = y.children[j + this.t];
        }

        // Reduce the number of keys in y
        y.numKeys = this.t - 1;

        // Since this node is going to have a new child, create space for new child
        for (int j = this.numKeys; j >= i + 1; j--)
            this.children[j + 1] = this.children[j];

        // Link the new child to this node
        this.children[i + 1] = z;

        // A key of y will move to this node. Find the location of new key and move all greater keys one space ahead
        for (int j = this.numKeys - 1; j >= i; j--)
            this.keys[j + 1] = this.keys[j];

        // Copy the middle key of y to this node
        this.keys[i] = y.keys[this.t - 1];

        // Increment the count of keys in this node
        this.numKeys++;
    }

    // A utility function to insert a new key in the subtree rooted with this node.
    // The assumption is, the node must be non-full when this function is called
    void insertNonFull(Employee employee) {
        // Initialize index as the rightmost element
        int i = this.numKeys - 1;

        // If this is a leaf node
        if (this.leaf) {
            // Find the right place to insert the new key and move all greater keys one place ahead
            while (i >= 0 && this.keys[i].getEmpNo() > employee.getEmpNo()) {
                this.keys[i + 1] = this.keys[i];
                i--;
            }

            // Insert the new key at found location
            this.keys[i + 1] = employee;
            this.numKeys++;
        } else { // If this node is not leaf
            // Find the child which is going to have the new key
            while (i >= 0 && this.keys[i].getEmpNo() > employee.getEmpNo())
                i--;

            // See if the found child is full
            if (this.children[i + 1].numKeys == 2 * this.t - 1) {
                // If the child is full, then split it
                this.splitChild(i + 1, this.children[i + 1]);

                // After the split, the middle key of y goes up and y is split into two.
                // See which of the two is going to have the new key
                if (this.keys[i + 1].getEmpNo() < employee.getEmpNo())
                    i++;
            }
            this.children[i + 1].insertNonFull(employee);
        }
    }
}


 
