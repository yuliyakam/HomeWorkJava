/*
    В файле содержится строка с данными:
    [{"фамилия":"Иванов","оценка":"5","предмет":"Математика"}, {"фамилия":"Петрова","оценка":"4","предмет":"Информатика"},
    {"фамилия":"Краснов","оценка":"5","предмет":"Физика"}]
    Напишите метод, который разберёт её на составные части и, используя StringBuilder создаст массив строк такого вида:
    Студент Иванов получил 5 по предмету Математика.
    Студент Петрова получил 4 по предмету Информатика.
    Студент Краснов получил 5 по предмету Физика.
*/
package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import static org.example.DoSQLWhithSplitAndBuilder.parsStr;


public class ParsDataToString {
    public static void main(String[] args){

        String strFromDictionary = readFile("info.txt");
        String[] resultArrayOfString = getResultArray(parsStrFromDictionary(strFromDictionary)).split(",");
        for (String el : resultArrayOfString){
            System.out.println(el);
        }
    }
    static String readFile(String fileName){
        String str = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            str = br.readLine();
            br.close();
        } catch (IOException ex){
            System.out.println("Something wrong!");
        }
        return str;
    }
    static String parsStrFromDictionary(String str){
        StringBuilder sb = new StringBuilder();
        str = str.substring(1, str.length()-1);//убираем [ вначале и ] в конце
        String[] strArr = str.split(", ");//получаем массив, элем в котором имеют вид {"ключ":"значение", "ключ":
        // "значение", "ключ":"значение"}
        for (String el : strArr){
            sb.append(String.join(",", parsStr(el)));
            sb.append(",");
        }
        return sb.toString();//получаем строку вида Иванов,5,Математика,Петрова,4,Информатика,Краснов,5,Физика,
    }
    static String getResultArray(String str){//Студент Иванов получил 5 по предмету Математика.
        StringBuilder sb = new StringBuilder();
        String[] arr = str.split(",");
        for (int i = 0; i <arr.length ; i+=3) {
            sb.append("Студент ");
            sb.append(arr[i]);
            sb.append(" получил ");
            sb.append(arr[i+1]);
            sb.append(" по предмету ");
            sb.append(arr[i+2]);
            sb.append(".");
            sb.append(",");
        }
        return sb.toString();
    }

}
