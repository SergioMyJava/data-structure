package mergeSort;


public class App {
    public static void main(String[] args){
        int[] a = {3,6,1,5,7,22};

        QuickSort t = new QuickSort();
        int [] sorted = t.sort(a);
        for(int g : sorted){
            System.out.print(g + " ");
        }

    }
}
