package mergeSort;

import java.util.Arrays;

public class Sort {

    public static int[] sort(int[] arr) {
        int[] index = new int[arr.length];
        int midl = arr.length/2;
        int leftIndex;
        int rightIndex;

        for(int i = 0;i<arr.length;i++){
            leftIndex = midl/2;
            index[i] = leftIndex;

        }

        return null;
    }

    public static int workWithIndex(int index){
        int left = index/2;

        if(index%2 == 0){
            int rightIndex = index/2;
        }
        else{
            int rightIndex = (index/2)+1;
        }
        return left;
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
