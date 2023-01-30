/*
    Пусть дан произвольный список целых чисел. Удалить из него чётные числа.*/
package org.example;

import java.util.ArrayList;

import java.util.List;

public class FindAndDeleteEvenNumber {
    public static void main(String[] args) {
        //Integer[] array = {1, 2, 3, 4, 5};
       // List<Integer> listNumbers = Arrays.asList(1, 2, 3, 4, 5);

        List  listNumbers = new ArrayList<Integer>();
        listNumbers.add(-1);
        listNumbers.add(2);
        listNumbers.add(4);
        listNumbers.add(-5);
        listNumbers.add(1);

        deleteEvenElements(listNumbers);
        System.out.println(listNumbers);

        int min = (Integer)listNumbers.get(0);
        int max = (Integer)listNumbers.get(0);
        int lenList = listNumbers.size();
        double sum = 0;
        for (int i = 0; i < lenList; i++) {
            if ((Integer) listNumbers.get(i)>0)
                sum += (Integer) listNumbers.get(i);
            else
                sum += (Integer) listNumbers.get(i)*-1;
            if ((Integer)listNumbers.get(i) < min) min = (Integer) listNumbers.get(i);
            if ((Integer)listNumbers.get(i) > max) max = (Integer) listNumbers.get(i);
        }

        double srAr = sum/lenList;

        System.out.printf("Максимальное = %d, минимальное = %d\n", max, min);
        System.out.print("Cреднее арифметичское = " + srAr);
    }
    static List deleteEvenElements(List list){
        for (int i = 0; i < list.size(); i++) {
            if ((Integer)list.get(i) % 2 == 0){
                list.remove(i);
                i--;
            }
        }
        return list;
    }
}