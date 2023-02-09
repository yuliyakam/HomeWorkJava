/*Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что один человек
может иметь несколько телефонов.*/
package org.example;

import org.w3c.dom.TypeInfo;

import java.lang.reflect.Array;
import java.util.*;

public class PhoneBook {
    private static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {

        Map<String, List> phoneBook = new HashMap<>();
        phoneBook.put("Иванов", Arrays.asList("89451542879", "85497102325"));
        phoneBook.put("Петров", Arrays.asList("89451542870"));
        phoneBook.put("Сидоров", Arrays.asList("8945154281", "85497104725", "87452365487"));

        System.out.println("Выберите действие \n1 - Посмотреть все записи\n2 - Найти контакт по фамилии\n3 - добавить котакт");
        int whatDo = input.nextInt();
        if (whatDo == 1) showAllContact(phoneBook);
        if (whatDo == 2) findContact(phoneBook);
        if (whatDo == 3) addContact(phoneBook);
    }
    private static void addContact(Map<String, List> map) {

        System.out.print("Введите фамилию абонента с большой буквы ");
        String firstname = input.next();
        if (map.containsKey(firstname)) {
            System.out.print("Такой абонент существует! Если вы хотите добавить еще номер к существующему, нажмите 1\n" +
                    "Если Вы хотите добавить другого абонента нажмите 2 и измените имя!");
            int whatDo = input.nextInt();
            if (whatDo == 1){
                System.out.print("Введите номер ");
                String phone = input.next();
                ArrayList<String> oldPhone = new ArrayList<>(map.get(firstname));
                oldPhone.add(phone);
                map.put(firstname, oldPhone);
                showAllContact(map);
            }
            if (whatDo == 2) addContact(map);
        }
        else {
            System.out.print("Введите номер ");
            String phone = input.next();
            map.put(firstname, Arrays.asList(phone));
            System.out.println("Контакт добавлен и будет сейчас отображен в справочнике!");
            showAllContact(map);
        }
    }

    private static void showAllContact(Map<String, List> map){
        for (Map.Entry<String,List> entry:map.entrySet()
             ) {
            System.out.println(entry.getKey()+" = "+ entry.getValue());
        }
    }
    private static void findContact(Map<String, List> map) {
        System.out.print("Введите фамилию абонента с большой буквы ");
        String str = input.next();
        if (map.containsKey(str)) {
            System.out.print(map.get(str));
        }
    }
}