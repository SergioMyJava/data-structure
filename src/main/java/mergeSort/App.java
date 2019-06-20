package mergeSort;

import static mergeSort.Sort.sort;

public class App {
    public static void main(String[] args){
        int[] a = {3,6,1,5,7,22};
     int[] b =sort(a);
     for(int v : b){
         System.out.println(v);
     }
    }
}
