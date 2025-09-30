import javax.swing.*;
import java.awt.*;

public class SortingPanel extends JPanel {
    private int[] array;

    public SortingPanel() {
        this.setBounds(0, 50, 800, 500);
        this.array = generateArray(50);
    }

    private int[] generateArray(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = (int)(Math.random() * 400) + 50;
        }
        return arr;
    }

    public void setArray(int[] arr) {
        this.array = arr;
        repaint();
    }

    public int[] getArray() {
        return array;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.setBackground(Color.black);

        g.setColor(Color.green);
        int width = getWidth() / array.length;

        for (int i = 0; i < array.length; i++) {
            g.fillRect(i * width, getHeight() - array[i], width - 2, array[i]);
        }
    }
}
