import javax.swing.*;

public class ControlPanel extends JPanel {
    private SortingPanel sortingPanel;

    public ControlPanel(SortingPanel panel) {
        this.sortingPanel = panel;
        this.setBounds(0, 0, 800, 50);

        String[] algorithms = {"Bubble Sort", "Insertion Sort", "Selection Sort", "Merge Sort", "Quick Sort"};
        JComboBox<String> algoBox = new JComboBox<>(algorithms);

        JButton runBtn = new JButton("Run");
        runBtn.addActionListener(e -> {
            int[] arr = sortingPanel.getArray();
            String selected = (String) algoBox.getSelectedItem();
            switch (selected) {
                case "Bubble Sort" -> SortAlgorithms.bubbleSort(arr, sortingPanel);
                case "Insertion Sort" -> SortAlgorithms.insertionSort(arr, sortingPanel);
                case "Selection Sort" -> SortAlgorithms.selectionSort(arr, sortingPanel);
                case "Merge Sort" -> SortAlgorithms.mergeSort(arr, sortingPanel);
                case "Quick Sort" -> SortAlgorithms.quickSort(arr, sortingPanel);
            }
        });

        JButton resetBtn = new JButton("Reset");
        resetBtn.addActionListener(e -> sortingPanel.setArray(generateArray(50)));

        this.add(algoBox);
        this.add(runBtn);
        this.add(resetBtn);
    }

    private int[] generateArray(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = (int)(Math.random() * 400) + 50;
        }
        return arr;
    }
}
