/* Реализуйте алгоритм сортировки пузырьком числового массива, результат после каждой итерации запишите
 в лог-файл.
* */
package org.example;

import java.io.IOException;
import java.util.Random;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class BubleSort {
    private static Random random = new Random();
    public  static void main(String[] args){

        int[] arr = getRandomArray(5, 0, 10);
        createLogInfo(arr);

        for (int element : arr) System.out.printf("%d ", element);
    }
    static void createLogInfo(int[] arr){
        try {
            Logger logger = Logger.getLogger(BubleSort.class.getName());
            FileHandler fh = new FileHandler("log.txt");
            logger.addHandler(fh);
            logger.setLevel(Level.INFO);

            SimpleFormatter sFormat = new SimpleFormatter();
            fh.setFormatter(sFormat);

            int len =  arr.length;
            int el = 0;
            String str = "";
            for (int i = 0; i < len-1; i++) {
                for (int j = i + 1; j < len; j++) {
                    if (arr[i] > arr[j]) {
                        el = arr[i];
                        arr[i] = arr[j];
                        arr[j] = el;
                        str = "Элемент " + el + " перемещен на позицию " + j;
                        logger.info(str);
                    }
                }
                str = "";
            }
            } catch (IOException ex){
                System.out.println("Something wrong!");
            }
        }

    static int[] getRandomArray(int size, int min, int max){
        int[] arr = new int[size];//
        int index = 0;
        while (index < size) {
            arr[index] = random.nextInt(min, max);
            index = index + 1;
        }
        return arr;
    }
}



