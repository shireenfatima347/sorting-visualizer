import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Sorting Algorithm Visualizer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLayout(null);
        SortingPanel sortingPanel = new SortingPanel();
        ControlPanel controlPanel = new ControlPanel(sortingPanel);

        frame.add(sortingPanel);
        frame.add(controlPanel);

        frame.setVisible(true);
    }
}
