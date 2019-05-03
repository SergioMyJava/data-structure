package LinkedList;

public class TaskFromViaGames {

    public int getSecondMax(int [] array){
        int max = 0;
        int secondMax = 0;
        for(int i = 0;i<array.length;i++){
            int a = array[i];
            if(max < a){
                secondMax = max;
                max = a;
            }
            if(a < max && a > secondMax){
                secondMax = a;
            }
        }
        return  secondMax;
    }
}
