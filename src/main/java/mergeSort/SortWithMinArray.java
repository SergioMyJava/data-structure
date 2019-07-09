package mergeSort;

import java.util.Arrays;

public class SortWithMinArray {

    public static int[] sort(int[] arr) {
        if (arr.length < 2) {
            return arr;
        }
        int[] arr1 = Arrays.copyOfRange(arr, 0, arr.length / 2);
        int[] arr2 = Arrays.copyOfRange(arr, arr.length / 2, arr.length);
        return merge(sort(arr1), sort(arr2));
    }

    public static int[] merge(int[] arr1, int arr2[]) {
        int[] arr = new int[arr1.length + arr2.length];
        int i1 = 0;
        int i2 = 0;

        for (int i = 0; i < arr.length; i++) {
            if (i1 == arr1.length) {
                arr[i] = arr2[i2++];
            } else if (i2 == arr2.length) {
                arr[i] = arr1[i1++];
            } else {
                if (arr1[i1] < arr2[i2]) {
                    arr[i] = arr1[i1++];
                } else {
                    arr[i] = arr2[i2++];
                }
            }
        }
        return arr;
    }
}
