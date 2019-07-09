package mergeSort;

public class QuickSort {
    public int[] sort(int[] array) {
        return quickSort(array, 0, array.length-1);
    }

    public int[] quickSort(int[] array, int start, int end) {
        if (start >= end) {
            return array;
        }
        int beginning = start;
        int finish = end;
        int pivot = finish / 2;

        while (beginning < finish) {

            while (beginning < pivot && array[beginning] <= array[pivot]) {
                beginning++;
            }
            while (finish > pivot && array[finish] >= array[pivot]) {
                finish--;
            }

            if (beginning < finish) {
                int temp = array[beginning];
                array[beginning] = array[finish];
                array[finish] = temp;
            }

//            if(beginning == pivot){
//                pivot = finish;
//            }
//            else{
//                pivot = beginning;
//            }
            quickSort(array, beginning, pivot);
            quickSort(array, pivot-1, finish);
        }
        return array;
    }
}
