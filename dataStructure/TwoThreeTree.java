package dataStructure;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import employeePackage.*;

public class TwoThreeTree {
    public Node root;
    int t; // Minimum degree
    int numEmployees;
    private double totalSalary;
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


    
    public Double countSalary(){
        totalSalary = 0.00;
        countSalaryInSubtree(root);
        return totalSalary;
    }

    private void countSalaryInSubtree(Node node) {
        if (node != null) {
            for(int i = 0; i < node.numKeys; i++){
                totalSalary += node.keys[i].getSalary();
            }
            
            // Recursively sum
            for (int i = 0; i < node.numKeys + 1; i++) {
               countSalaryInSubtree(node.children[i]);
            }
        }
    }
    private ArrayList<Double> salaries = new ArrayList<>();
    public Double getMedianSalary(){
        collectSalary(root);
        Collections.sort(salaries);

        int size = salaries.size();
        if (size == 0) {
            return 0.00; // Return 0 if there are no salaries
        }

        if (size % 2 == 0) {
            // If the number of salaries is even, calculate the average of the two middle values
            int middleIndex1 = size / 2 - 1;
            int middleIndex2 = size / 2;
            return (salaries.get(middleIndex1) + salaries.get(middleIndex2)) / 2.0;
        } else {
            // If the number of salaries is odd, return the middle value
            return salaries.get(size / 2);
        }
    }
    private void collectSalary(Node node) {
        if (node != null) {
            for (int i = 0; i < node.numKeys; i++) {
                salaries.add(node.keys[i].getSalary());
            }

            // Recursively collect salaries from children nodes
            for (int i = 0; i < node.numKeys + 1; i++) {
                collectSalary(node.children[i]);
            }
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