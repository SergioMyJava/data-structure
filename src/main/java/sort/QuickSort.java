package sort;

public class QuickSort {

    public int[] sort(int[] array) {
        return quickSort(array, 0, array.length - 1);
    }

    public int[] quickSort(int[] array, int start, int end) {
        int beginning = start;
        int finish = end;
        int pivot = beginning - (beginning - finish) / 2;

        while (beginning < finish) {

            while (beginning < pivot && array[beginning] <= array[pivot]) {
                beginning++;
            }
            while (finish > pivot && array[finish] >= array[pivot]) {
                finish--;
            }

            if (beginning < finish) {
                int temp = array[finish];
                array[finish] = array[beginning];
                array[beginning] = temp;

                if (beginning == pivot)
                    pivot = finish;
                else if (finish == pivot)
                    pivot = beginning;
            }
        }

        if (start < end) {
            quickSort(array, start, pivot);
            quickSort(array, pivot + 1, end);
        }
        return array;
    }
}
