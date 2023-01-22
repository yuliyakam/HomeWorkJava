package org.example;
import java.util.Scanner;
public class TriangleNumber {
    private static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
       int userNumber = getUserNumber("Введите положительное, натуральное число, от которого вы хотите посчитать треугольное число ? ");
       System.out.printf("Треулоьное число от %d = %d", userNumber, getTriangleNumber(userNumber));
    }
    // метод запрашивает число от пользователя
    static int getUserNumber(String msg){
        int num = 0;
        do {
            System.out.print(msg);
            num = input.nextInt();
        } while (num<0);
        return num;
    }
    // метод расчета треугольного числа
    static int getTriangleNumber(int num){
        int triangleNumber = num * (num + 1) / 2;
        return triangleNumber;
    }

}