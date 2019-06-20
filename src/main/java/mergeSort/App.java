package mergeSort;

import static mergeSort.Sort.sort;

public class App {
    public static void main(String[] args){
//        int[] a = {3,6,1,5,7,22};
//     int[] b =sort(a);
//     for(int v : b){
//         System.out.println(v);
//     }
        int[] a = {3,6,1,5,90,90,7,22};
        int[] b = {1,3,5,6,7,22,90,90};
        int[] c = Sort.sort(a);
        for(int k =0;k<b.length;k++){
            System.out.println(b[k] == c[k]);
        }
    }
}
