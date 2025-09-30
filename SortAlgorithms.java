public class SortAlgorithms {

    // Bubble Sort
    public static void bubbleSort(int[] arr, SortingPanel panel) {
        new Thread(() -> {
            try {
                for (int i = 0; i < arr.length - 1; i++) {
                    for (int j = 0; j < arr.length - i - 1; j++) {
                        if (arr[j] > arr[j + 1]) {
                            swap(arr, j, j + 1);
                            panel.setArray(arr.clone());
                            Thread.sleep(50);
                        }
                    }
                }
            } catch (Exception e) { e.printStackTrace(); }
        }).start();
    }

    // Insertion Sort
    public static void insertionSort(int[] arr, SortingPanel panel) {
        new Thread(() -> {
            try {
                for (int i = 1; i < arr.length; i++) {
                    int key = arr[i];
                    int j = i - 1;
                    while (j >= 0 && arr[j] > key) {
                        arr[j + 1] = arr[j];
                        j--;
                        panel.setArray(arr.clone());
                        Thread.sleep(50);
                    }
                    arr[j + 1] = key;
                    panel.setArray(arr.clone());
                    Thread.sleep(50);
                }
            } catch (Exception e) { e.printStackTrace(); }
        }).start();
    }

    // Selection Sort
    public static void selectionSort(int[] arr, SortingPanel panel) {
        new Thread(() -> {
            try {
                for (int i = 0; i < arr.length - 1; i++) {
                    int minIndex = i;
                    for (int j = i + 1; j < arr.length; j++) {
                        if (arr[j] < arr[minIndex]) {
                            minIndex = j;
                        }
                    }
                    swap(arr, i, minIndex);
                    panel.setArray(arr.clone());
                    Thread.sleep(50);
                }
            } catch (Exception e) { e.printStackTrace(); }
        }).start();
    }

    // Merge Sort
    public static void mergeSort(int[] arr, SortingPanel panel) {
        new Thread(() -> {
            try {
                mergeSortHelper(arr, 0, arr.length - 1, panel);
            } catch (Exception e) { e.printStackTrace(); }
        }).start();
    }

    private static void mergeSortHelper(int[] arr, int left, int right, SortingPanel panel) throws InterruptedException {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSortHelper(arr, left, mid, panel);
            mergeSortHelper(arr, mid + 1, right, panel);
            merge(arr, left, mid, right, panel);
        }
    }

    private static void merge(int[] arr, int left, int mid, int right, SortingPanel panel) throws InterruptedException {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; i++) L[i] = arr[left + i];
        for (int j = 0; j < n2; j++) R[j] = arr[mid + 1 + j];

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k++] = L[i++];
            } else {
                arr[k++] = R[j++];
            }
            panel.setArray(arr.clone());
            Thread.sleep(50);
        }

        while (i < n1) {
            arr[k++] = L[i++];
            panel.setArray(arr.clone());
            Thread.sleep(50);
        }

        while (j < n2) {
            arr[k++] = R[j++];
            panel.setArray(arr.clone());
            Thread.sleep(50);
        }
    }

    // Quick Sort
    public static void quickSort(int[] arr, SortingPanel panel) {
        new Thread(() -> {
            try {
                quickSortHelper(arr, 0, arr.length - 1, panel);
            } catch (Exception e) { e.printStackTrace(); }
        }).start();
    }

    private static void quickSortHelper(int[] arr, int low, int high, SortingPanel panel) throws InterruptedException {
        if (low < high) {
            int pi = partition(arr, low, high, panel);
            quickSortHelper(arr, low, pi - 1, panel);
            quickSortHelper(arr, pi + 1, high, panel);
        }
    }

    private static int partition(int[] arr, int low, int high, SortingPanel panel) throws InterruptedException {
        int pivot = arr[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
                panel.setArray(arr.clone());
                Thread.sleep(50);
            }
        }
        swap(arr, i + 1, high);
        panel.setArray(arr.clone());
        Thread.sleep(50);
        return (i + 1);
    }

    // Swap helper
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
