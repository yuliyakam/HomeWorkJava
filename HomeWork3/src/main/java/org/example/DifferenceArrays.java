/*Даны два ArrayList из целых чисел. Написать функции, которые вычисляют разницу коллекций:
Разность:
A - B = все числа из первой коллекции, которые не содержатся во второй коллекции
B - A = все числа из второй коллекции, которые не содержатся в первой
Симметрическая разность:
A ^ B = числа из первой коллекции, которых нет во второй, А ТАКЖЕ числа из второй, которых нет в первой*/
package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DifferenceArrays {
    private static List listRemoveElements = new ArrayList<Integer>();//Глобальная переменная
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        List A = new ArrayList<Integer>();
        A.add(-1);
        A.add(2);
        A.add(4);
        A.add(-5);
        A.add(1);

        List B = new ArrayList<Integer>();
        B.add(-1);
        B.add(2);
        B.add(-4);
        B.add(5);
        System.out.println("Имеются два ArrayList\n"+"A = "+A+" "+"B = "+B);
        System.out.println("Выбирите действие:\n1 - Найти разницу ArrayList A-B\n2 - Найти разницу ArrayList B-A\n" +
                "3 - Найти симметрическую разницу ArrayList A^B\n");
        int chekNumber = input.nextInt();

        if (chekNumber == 1) System.out.print("A-B: "+ AdifferenceB(A,B));
        else if (chekNumber == 2) System.out.println("B-A: "+ BdifferenceA(B,A));
        else System.out.print("A^B: " + SymmetricalDifference(A,B));
    }
    static List AdifferenceB(List list1, List list2){

        for (int i = 0; i < list2.size(); i++) {
            if (list1.contains(list2.get(i))){
                listRemoveElements.add(list2.get(i));
                list1.remove(list2.get(i));
            }
        }
        return list1;
    }
    static List BdifferenceA(List list2, List list1){
        for (int i = 0; i < list1.size(); i++) {
            if (list2.contains(list1.get(i))){
                list2.remove(list1.get(i));
            }
        }
        return list2;
    }
    static List SymmetricalDifference(List list1, List list2){
        List listA = new ArrayList<Integer>();
        List listB = new ArrayList<Integer>();
        List result = new ArrayList<Integer>();
        listA = AdifferenceB(list1,list2);
        listB = BdifferenceA(list2,list1);
        int lengthA = listA.size();
        int lengthB = listB.size();
        for (int i = 0; i < lengthA; i++) result.add(listA.get(i));

        for (int i = 0; i < lengthB; i++) result.add(listB.get(i));

        int lengthResalt = listRemoveElements.size();
        for (int i = 0; i < lengthResalt; i++) {
            if (result.contains(listRemoveElements.get(i))){
                result.remove(listRemoveElements.get(i));
            }
        }
        return result;
    }
}
