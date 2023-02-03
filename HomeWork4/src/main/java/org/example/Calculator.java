/*Напишите постфиксный калькулятор. Пользователь вводит данные и операции в обратной польской записи. Калькулятор
 вычисляет результат и проверяет, что в стэке получилось единственное число.
Например:
5 4 3 - + => 5 1 + => 6
 */
package org.example;
import java.util.Stack;
import java.util.Arrays;
public class Calculator {

        private static boolean isDigit(String s) throws NumberFormatException {//метод обрабатывающий корректность ввода
            try {//если на входе удается преобразовать символ в цифру, значит мы можем добавить её в стэк
                Integer.parseInt(s);
                return true;
            } catch (NumberFormatException e) {
                return false;
            }
        }

        public static void main(String[] args) {
            // Инфиксная запись                                             Постфиксная запись
            //  (1+2*3*4)*(10/5) - 20                                       1 2 3 * 4 * + 5 10 / * 20 -
            //  (1 + 2) * 3                                                 1 2 + 3 *
            //  (20-30)*10                                                  20 30 - 10 *


            String[] exp = "2 5 ^".split(" "); // 2^5 два в пятой степени

            int res = 0;
            for (String element : exp) {
                System.out.printf("%s ", element);
            }
            System.out.print("= ");
            Stack<Integer> st = new Stack<>();
            for (int i = 0; i < exp.length; i++) {

                if (isDigit(exp[i])) {
                    st.push(Integer.parseInt(exp[i]));
                } else {
                    switch (exp[i]) {
                        case "+":
                            res = st.pop() + st.pop();
                            st.push(res);
                            break;
                        case "-":
                            res = -st.pop() + st.pop();
                            st.push(res);
                            break;
                        case "*":
                            res = st.pop() * st.pop();
                            st.push(res);
                            break;
                        case "/":
                            res =  st.pop()/ st.pop();
                            st.push(res);
                            break;
                       case "^":
                           int pow = st.pop();
                           int number = st.pop();
                           res = 1;
                           for (int j = 0; j < pow; j++) {
                                res *= number;
                           }
                           //Возведение в степень через класс Math
//                           res = (int) Math.pow(number, pow);
                           st.push(res);
                           break;
                        default:
                            System.out.println("Введено некорректное действие! Допустимы знаки:\n " +
                                    "\"+\" - сложение\n \"-\" - вычитание\n \"/\" - деление\n \"*\" - умножение\n" +
                                    "\"^\" - возведение в степень (слева от ^ показатель степени!)");
                            break;
                    }
                }
            }
            if (st.size() == 1)
            System.out.printf("%d\n", st.pop());
        }
    }

