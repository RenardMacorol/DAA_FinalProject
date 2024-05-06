package dataStructure;
import employeePackage.*;

public class TwoThreeTree {
    public Node root;
    int t; // Minimum degree
    int numEmployees;
    // Constructor
    public TwoThreeTree(int t) {
        this.root = null;
        this.t = t;
        this.numEmployees =0;
    }

    // This function to travese the tree
    public void traverse() {
        if (this.root != null)
            this.root.traverse();
    }

    // This function is to search a key. Usefull function and important for this program 
    public Node search(int k) {
    return searchInSubtree(root, k);
    }

    private Node searchInSubtree(Node node, int k) {
    if (node == null)
        return null;

    return node.search(k);
    }


    // The main function that inserts a new key in this 2-3 Tree
    public void insert(Employee employee) {
        // If the tree is empty
        if (this.root == null) {
            this.root = new Node(t, true);
            this.root.keys[0] = employee;
            this.root.numKeys = 1;
        } else { // If the tree is not empty
            // If root is full, then tree grows in height
            if (this.root.numKeys == 2 * t - 1) {
                Node s = new Node(t, false);
                s.children[0] = this.root;
                s.splitChild(0, this.root);
                int i = 0;
                if (s.keys[0].getEmpNo() < employee.getEmpNo())
                    i++;
                s.children[i].insertNonFull(employee);
                this.root = s;
            } else // If root is not full, call insertNonFull for root
                this.root.insertNonFull(employee);
        }
    }


    // Method to count the number of employees in the tree
    public int countEmployees() {
        numEmployees = 0; // Reset the count before traversal
        countEmployeesInSubtree(root); // Start counting from the root
        return numEmployees;
    }

    // eto yung method na recursively parang sa binary
    private void countEmployeesInSubtree(Node node) {
        if (node != null) {
            // Add the number of keys in the current node to the total count
            numEmployees += node.numKeys;

            // Recursively count employees in the children of the current node
            for (int i = 0; i < node.numKeys + 1; i++) {
                countEmployeesInSubtree(node.children[i]);
            }
        }
    }
}