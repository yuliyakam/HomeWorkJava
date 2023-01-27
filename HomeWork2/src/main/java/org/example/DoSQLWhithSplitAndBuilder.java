/*В файле содержится строка с исходными данными в такой форме:
    {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}
    Требуется на её основе построить и вывести на экран новую строку, в форме SQL запроса:
    SELECT * FROM students WHERE name = "Ivanov" AND country = "Russia" AND city = "Moscow";
    Для разбора строки используйте String.split. Сформируйте новую строку, используя StringBuilder.
    Значения null не включаются в запрос.
 */
package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DoSQLWhithSplitAndBuilder {
    public static void main(String[] args)  {

        String str = readFile("data.txt");
        String[] variableValueInSql = parsStr(str);
        String name = variableValueInSql[0];
        String country = variableValueInSql[1];
        String city = variableValueInSql[2];

        System.out.println(createSQLString(name,country,city));

    }
    static String createSQLString(String name, String country, String city){
        StringBuilder result = new StringBuilder();

        result.append("SELECT * FROM students WHERE name = \"");
        result.append(name);

        result.append("\" AND country = \"");
        result.append(country);

        result.append("\" AND city = \"");
        result.append(city);
        result.append("\";");

        return result.toString();
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
    static String[] parsStr(String str){
        int index = 0;
        str = str.substring(1, str.length()-1);//убираем {}
        String[] strArr = str.split(",");//получаем массив, элем в котором имеют вид "ключ":"значение"
        int length = strArr.length;
        String[] sqlName = new String[length];
        for (String el : strArr){
            int ind = el.indexOf(':');//находим индекс : чтобы сделать срез послед значения
            sqlName[index] = el.substring(ind+2, el.length()-1);//сохраняем значение нужное в запросе SQL
            index++;
        }
        return sqlName;
    }
}