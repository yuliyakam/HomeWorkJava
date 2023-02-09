package org.example;

import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) {
        int arr[] = {4, 8, 10, 7, 5, 1, 9, 2, 6, 3, 0};

        sortArray(arr);
        System.out.print(Arrays.toString(arr));

    }
    public static void sortArray(int arr[]){
        int n = arr.length;
        for (int i = n / 2 - 1; i >= 0 ; i--) {
            heapifyMetod(arr, n ,i);
        }
        for (int i = n - 1; i >=0 ; i--) {
            int buffer = arr[0];
            arr[0] = arr[i];
            arr[i] = buffer;
            heapifyMetod(arr, i ,0);
        }
    }
    public static void heapifyMetod(int[] arr, int size, int index){
        int max = index;//считаем максимумом текущий элемент
        int left = 2 * index + 1;//элемент левее
        int right = 2 * index + 2;//элемент правее
        //если левый больше корня
        if (left < size && arr[left] > arr[max])
            max = left;
        //если правый больше корня
        if(right < size && arr[right] > arr[max])
            max = right;
        //если самый большой не корень делаем перестановку
        if (max != index){
            int buffer = arr[index];
            arr[index] = arr[max];
            arr[max] = buffer;
            //вызываем рекурсию на стабилизацию поддерева данного узла в двоичную кучу
            heapifyMetod(arr, size, max);
        }

    }
}
