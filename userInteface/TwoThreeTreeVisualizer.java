package userInteface;

import javax.swing.*;

import dataStructure.Node;
import dataStructure.TwoThreeTree;

import java.awt.*;

public class TwoThreeTreeVisualizer extends JPanel {

    private static final int NODE_SIZE = 50;
    private static final int EDGE_WIDTH = 2;
    private static final Color NODE_COLOR = Color.BLUE;
    private static final Color EDGE_COLOR = Color.GRAY;
    private static final int HORIZONTAL_GAP = 100;
    private static final int VERTICAL_GAP = 100;

    private TwoThreeTree tree; // Reference to your TwoThreeTree class

    public void TreeVisualization(TwoThreeTree tree) {
        this.tree = tree;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (tree != null && tree.root != null) {
            drawTree(g, tree.root, getWidth() / 2, 50, getWidth() / 4);
        }
    }

    private void drawTree(Graphics g, Node node, int x, int y, int offsetX) {
        // Draw the node
        g.setColor(NODE_COLOR);
        g.fillOval(x - NODE_SIZE / 2, y - NODE_SIZE / 2, NODE_SIZE, NODE_SIZE);
        g.setColor(Color.BLACK);
        g.drawString(String.valueOf(node.keys[0]), x - 5, y + 5); // Draw node key

        // Draw edges to children
        g.setColor(EDGE_COLOR);
        if (node.children[0] != null) {
            g.drawLine(x, y, x - offsetX, y + HORIZONTAL_GAP);
            drawTree(g, node.children[0], x - offsetX, y + HORIZONTAL_GAP, offsetX / 2);
        }
        if (node.children[1] != null) {
            g.drawLine(x, y, x, y + HORIZONTAL_GAP);
            drawTree(g, node.children[1], x, y + HORIZONTAL_GAP, offsetX / 2);
        }
        if (node.children[2] != null) {
            g.drawLine(x, y, x + offsetX, y + HORIZONTAL_GAP);
            drawTree(g, node.children[2], x + offsetX, y + HORIZONTAL_GAP, offsetX / 2);
        }
    }
}