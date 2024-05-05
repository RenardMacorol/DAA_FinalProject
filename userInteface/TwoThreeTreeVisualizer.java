package userInteface;

import javax.swing.*;

import dataStructure.Node;
import dataStructure.TwoThreeTree;

import java.awt.*;

public class TwoThreeTreeVisualizer extends JPanel {

    private TwoThreeTree tree;
    private int nodeWidth = 40;
    private int nodeHeight = 20;
    private int horizontalGap = 50;
    private int verticalGap = 50;

    public TwoThreeTreeVisualizer(TwoThreeTree tree) {
        this.tree = tree;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Draw the tree recursively starting from the root
        if (tree.root != null) {
            drawNode(g, tree.root, getWidth() / 2, 50, getWidth() / 4);
        }
    }

    private void drawNode(Graphics g, Node node, int x, int y, int offsetX) {
        // Draw the node's keys
        for (int i = 0; i < node.numKeys; i++) {
            g.drawRect(x - nodeWidth / 2 + offsetX * i, y, nodeWidth, nodeHeight);
            g.drawString(Integer.toString(node.keys[i].getEmpNo()), x + offsetX * i, y + nodeHeight / 2);
        }

        // Draw the node's children recursively
        for (int i = 0; i < node.numKeys + 1; i++) {
            if (node.children[i] != null) {
                drawNode(g, node.children[i], x + offsetX * i, y + verticalGap, offsetX / 2);
            }
        }
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(1000, 800);
    }
}

