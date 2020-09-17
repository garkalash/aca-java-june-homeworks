package com.aca.arsen.algorithms.trees;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int [] arr = new int[8];
        arr[0] = 5;
        arr[1] = 15;
        arr[2] = 11;
        arr[3] = 12;
        arr[4] = 2;
        arr[5] = -5;
        arr[6] = 19;
        arr[7] = 2;

        mergeSort(arr, arr.length);

        System.out.println(Arrays.toString(arr));
    }

    public static void mergeSort(int[] arr,int n) {
        if(n < 2) return;
        int mid = n/2;
        int[] left = new int[mid];
        int[] right = new int[n - mid];
        for (int i = 0; i< n; ++i){
            if (i < mid){
                left[i] = arr[i];
            } else right[i - mid] = arr[i];
        }
        mergeSort(left, mid);
        mergeSort(right, n-mid);
        merge(arr, left, right, mid, n-mid);
    }

    public static void merge(int[] arr,
                             int[] left,
                             int[] right,
                             int leftInd,
                             int rightInd) {
        int i = 0, j = 0, k = 0;
        while(i < leftInd && j < rightInd){
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }
        while(i < leftInd){
            arr[k++] = left[i++];
        }
        while(j < rightInd) {
            arr[k++] = right[j++];
        }
    }
}
