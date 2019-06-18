package mergeSort;

import static mergeSort.Sort.sort;

public class App {
    public static void main(String[] args){
     int[] a = {10,4,6,5,8,9};
     int[] b =sort(a);
     for(int v : b){
         System.out.println(v);
     }
    }
}
