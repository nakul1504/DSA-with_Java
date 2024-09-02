package Sorting;

public class BubbleSort {

    public static void printArrays(int[] arr){
        for(int j: arr){
            System.out.print(j + " ");
        }
    }

    public static void bubbleSort(int[] arr){
        int len = arr.length;

        for(int i = len-1; i > 0; i--){
            int didSwap = 0;
            for(int j = 0; j < i; j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    didSwap = 1;
                }

                if(didSwap == 0){
                    break;
                }
            }
        }
    }
    public static void main(String[] args) {
        int[] arr = {2,1,3,0,8};

        System.out.println("Arrays before sorting");
        printArrays(arr);

        bubbleSort(arr);
        System.out.println();

        System.out.println("Arrays after sorting");
        printArrays(arr);
    }

//    Complexity is O(n2)
}
