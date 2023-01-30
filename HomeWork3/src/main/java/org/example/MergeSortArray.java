package org.example;

import java.util.Arrays;

public class MergeSortArray {
    public static void main(String[] args) {
        int[] array = {5, 10, 7, 3, 9, 1, 4, 2, 6, 8};
        System.out.println(Arrays.toString(sortArr(array)));

    }
    public static int[] sortArr(int[] array){
        if (array == null) return null;//если массив пуст, возвращаем 0
        if (array.length < 2) return array;//если массив из 1элем то он отсортирован, возвращаем массив

        int leftPartArray[] = new int[array.length/2];//делим исход массив на 2 части
        System.arraycopy(array, 0, leftPartArray, 0, array.length/2);//копируем в лев часть
        //исходн массив с перв элемен до половины

        int rightPartArray[] = new int[array.length-leftPartArray.length];
        System.arraycopy(array, leftPartArray.length, rightPartArray, 0, array.length-leftPartArray.length);
        //копируем в прав часть исходн массив половины до конца
        sortArr(leftPartArray);//рекурсивно вызываем функцию для каждой части массива, пока не разделиться до одноэле-
        sortArr(rightPartArray);//ментных частей

        mergeArr(array, leftPartArray,rightPartArray);//вызываем функцию соединяющую наши отсортированные части
        return array;
    }

    public static void mergeArr(int[] array, int[] leftPartArray, int[] rightPartArray) {
        int positionLeftArr = 0;
        int positionRightArr = 0;
        int len = array.length;

        for (int i = 0; i < len; i++) {
            if (positionLeftArr == leftPartArray.length){//если в лев части достигнут конец массива заполняем элементами
                array[i] = rightPartArray[positionRightArr];//из правой части
                positionRightArr++;
            } else if (positionRightArr == rightPartArray.length) {//если в прав части достигнут конец массива заполняем
                array[i] = leftPartArray[positionLeftArr];// элементами из левой части
                positionLeftArr++;
            } else if (leftPartArray[positionLeftArr] < rightPartArray[positionRightArr]) {
                array[i] = leftPartArray[positionLeftArr];//меньше элемента правой - добавляем его в результир.массив
                positionLeftArr++;//и берем след элем из левой части
            } else {//если элемент правой части меньше элемента левой - добавляем его в результир.массив
                array[i] = rightPartArray[positionRightArr];
                positionRightArr++;//и берем след элем из правой части
            }
        }
    }

}
