package Sorting;

public class SelectionSort {

    public static void printArrays(int[] arr){
        for(int j: arr){
            System.out.print(j + " ");
        }
    }

    public static void selectionSort(int[] arr){
        int len = arr.length;
        for(int i = 0; i <= len-2; i++){
            int minIndex = i;
            for (int j = i; j <= len-1; j++){
                if(arr[j] < arr[minIndex]){
                    minIndex = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }
    public static void main(String[] args) {
        int[] arr = {2,4,3,1,0};

        System.out.println("Arrays before sorting");
        printArrays(arr);

        selectionSort(arr);
        System.out.println();

        System.out.println("Arrays after sorting");
        printArrays(arr);

    }

//    Complexity is O(n2)
}
