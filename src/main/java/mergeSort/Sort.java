package mergeSort;

public class Sort {

    public  static int[] sort(int [] arrayA){
        if(arrayA == null){
            return arrayA;
        }

        if(arrayA.length < 2){
            return arrayA;
        }

        int [] arrayB = new int[arrayA.length/2];
        System.arraycopy(arrayA,0,arrayB,0,arrayA.length/2);

        int [] arrayC = new int[arrayA.length/2];
        System.arraycopy(arrayA,arrayA.length/2,arrayC,0,arrayA.length/2);

        arrayB = sort(arrayB);
        arrayC = sort(arrayC);
        return merge(arrayB,arrayC);
    }

    public static int[] merge(int [] arrayА, int [] arrayB){
        int [] arrayC = new int[arrayА.length + arrayB.length];
        int positionA = 0, positionB = 0;

        for (int i = 0; i < arrayC.length; i++) {
            if (positionA == arrayА.length){
                arrayC[i] = arrayB[i - positionB];
                positionB++;
            } else if (positionB == arrayB.length) {
                arrayC[i] = arrayА[i - positionA];
                positionA++;
            } else if (arrayА[i - positionA] < arrayB[i - positionB]) {
                arrayC[i] = arrayА[i - positionA];
                positionB++;
            } else {
                arrayC[i] = arrayB[i - positionB];
                positionA++;
            }
        }
        return arrayC;
    }
}
