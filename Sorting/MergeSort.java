package Sorting;

import java.util.*;

public class MergeSort {

    public static void merge(int[] arr, int low, int mid, int high){
        ArrayList<Integer> temp = new ArrayList<>();
        int left = low;
        int right = mid+1;

        while (left <= mid && right <= high){
            if(arr[left] < arr[right]){
                temp.add(arr[left]);
                left++;
            }else{
                temp.add(arr[right]);
                right++;
            }
        }

        while (left <= mid){
            temp.add(arr[left]);
            left++;
        }

        while (right <=  high){
            temp.add(arr[right]);
            right++;
        }

        for(int i = low; i <= high; i++){
            arr[i] = temp.get(i - low);
        }
    }
    public static void mergeSort(int[] arr, int low, int high){
        if(low == high){
            return;
        }
        int mid = (low + high)/2;

        mergeSort(arr, low, mid);
        mergeSort(arr, mid+1, high);
        merge(arr, low, mid, high);
    }

    public static void printArray(int[] arr){
        for(int j : arr){
            System.out.print(j + " ");
        }

        System.out.println();
    }
    public static void main(String[] args) {
        int[] arr = {2,1,4,6,5,3};

        int low = 0; int high = arr.length - 1;
        System.out.println("Array before sorting");
        printArray(arr);

        mergeSort(arr, low, high);

        System.out.println("Array after sorting");
        printArray(arr);
    }
}
