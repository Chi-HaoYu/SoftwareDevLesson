

public class DateSort {

    public static FileDataSet[] DateSort(FileDataSet[] fileDataSet) {
        quickSort(fileDataSet, 0, fileDataSet.length-1);
    
        return fileDataSet;
    }


    public static void quickSort(FileDataSet[] fileData, int low, int high) {
        if (low < high) {
            int p = partition(fileData, low, high);
            quickSort(fileData, low, p-1);
            quickSort(fileData, p+1, high);
        }
    }

    public static int partition(FileDataSet[] fileData, int low, int high) {
        int p = low, j;
        for (j = low+1; j <= high; j++) {
            if (fileData[j].date.compareTo(fileData[low].date) < 0) {
                swap(fileData, ++p, j);
            }
        }
        swap(fileData, low, p);

        return p;
    }

    public static void swap(FileDataSet[] fileData, int low, int pivot) {
        FileDataSet temp = fileData[low];
        fileData[low] = fileData[pivot];
        fileData[pivot] = temp;
    }
}