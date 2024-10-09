import javax.swing.*;
import java.awt.*;

public class GUI extends JPanel {

    private BinarySearchTree bst;

    public GUI(BinarySearchTree bst) {
        this.bst = bst;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (bst.root != null) {
            desenharArvore(g, bst.root, getWidth() / 2, 50, getWidth() / 4);
        }
    }


    private void desenharArvore(Graphics g, Node node, int x, int y, int espaco) {
        g.setColor(Color.BLACK);
        g.fillOval(x - 15, y - 15, 30, 30);
        g.setColor(Color.WHITE);
        g.drawString(Integer.toString(node.dado), x - 7, y + 5);

        if (node.left != null) {
            g.setColor(Color.BLACK);
            g.drawLine(x, y, x - espaco, y + 50);
            desenharArvore(g, node.left, x - espaco, y + 50, espaco / 2);
        }
        if (node.right != null) {
            g.setColor(Color.BLACK);
            g.drawLine(x, y, x + espaco, y + 50);
            desenharArvore(g, node.right, x + espaco, y + 50, espaco / 2);
        }
    }
}
