package mergeSort;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SortTest {
    int[] a = {3,6,1,5,7,22};
    int[] b = {1,3,5,6,7,22};

    @Test
    void sort() {
        int[] c = Sort.sort(a);
        assertEquals(true,b.equals(c));
    }
}