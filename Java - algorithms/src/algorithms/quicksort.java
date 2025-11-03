package algorithms;

public class quicksort {
    public static void QuickSort(int[] array, int start, int end){
        if (end <= start) {
            return;
        }
        int pivot = partition(array,start,end);
        QuickSort(array,start,pivot-1);
        QuickSort(array, pivot+1,end);
    }
    public static int partition(int[] array, int start, int end){
        int pivot = array[end];
        int v = start-1;
        for( int i = start; i < end; i++){
            if (array[i] < pivot) {
                v++;
                int temp = array[v];
                array[v] = array[i];
                array[i] = temp;
            }
        }
        v++;
        int temp = array[v];
        array[v] = array[end];
        array[end] = temp;
        return v;
    }
    public static void main(String[] args){
        int[] array = {2,5,90,89,9,1,4,7,4,8,3,8,6};
        QuickSort(array, 0, array.length-1);
        for( int n: array){
            System.out.print(n + " ");
        }
        System.out.println();
    }
}
