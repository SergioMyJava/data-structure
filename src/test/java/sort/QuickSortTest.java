package sort;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuickSortTest {
    QuickSort exp = new QuickSort();
    int[] a = {3,6,1,5,7,22};
    int[] b = {1,3,5,6,7,22};
    int[] k = {7,5,21,19,34,7};
    int[] h = {5,7,7,19,21,34};

    @Test
    void sort() {
        int[] c = exp.sort(a);
        int[] m = exp.sort(k);
        for(int k = 0;k<c.length;k++){
            assertEquals(true,c[k] == b[k]);
            assertEquals(true,m[k] == h[k]);
        }
    }
}