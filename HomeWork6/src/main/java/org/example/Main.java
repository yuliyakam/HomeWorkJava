/*  1. Подумать над структурой класса Ноутбук для магазина техники - выделить поля и методы. Реализовать в java.
    2. Создать множество ноутбуков.
    Написать метод, который будет запрашивать у пользователя критерий (или критерии) фильтрации и выведет ноутбуки,
    отвечающие фильтру. Критерии фильтрации можно хранить в Map. Например:
    “Введите цифру, соответствующую необходимому критерию:
    1 - ОЗУ
    2 - Объем ЖД
    3 - Операционная система
    4 - Цвет …
    Далее нужно запросить минимальные значения для указанных критериев - сохранить параметры фильтрации можно также в Map.
    Отфильтровать ноутбуки из первоначального множества и вывести проходящие по условиям.
* */
package org.example;

import java.util.*;

public class Main {
    private static Scanner input = new Scanner(System.in);
    public static Notebook checkNt = new Notebook();
    public static void main(String[] args) {

        List<Notebook> notes = new ArrayList<Notebook>();

        Notebook nt = new Notebook(2, 256, "windows", "black");
        nt.addCpu(new Cpu("intel", "2.4", 4));

        notes.add(nt);

        nt = new Notebook(4, 500, "windows", "black");
        nt.addCpu(new Cpu("amd", "3.4", 8));

        notes.add(nt);

        nt = new Notebook(8, 1000, "linux", "silver");
        nt.addCpu(new Cpu("intel", "2.4", 4));

        notes.add(nt);

        nt = new Notebook(2, 256, "linux", "black");
        nt.addCpu(new Cpu("amd", "3.8", 4));

        notes.add(nt);

        nt = new Notebook(2, 256, "windows", "black");
        nt.addCpu(new Cpu("ibm", "2.4", 4));

        notes.add(nt);


        Map<String, String> test = new HashMap<>();
        test = checkNotebook();
        String str = "";
        int flag = 0;

        for (Notebook el: notes) {
            if (el.equals(checkNt)) {
                flag = 1;
                System.out.println(el);
            }
        }
        if (flag == 0) {
            System.out.println("К сожалению, по вашему запросу у нас пока нет нужной модели, но мы нашли совпадения" +
                    " по некоторым полям в других моделях: ");
            //Данный цикл выводит любые совпадения, имеет недостаток, что выводит по запросу озу 4 и процессор с частотой 2.4
            for (Notebook element : notes) {
                str = element.toString();
                for (String elem : test.values())
                    if (str.contains(elem)) System.out.println(str);
                str = "";
            }
        }
    }
    private static Map checkNotebook(){
        Map<String, String> criterias = new HashMap<>();

        System.out.println("Укажитете критерии модели\n1 - RAM(ОЗУ - опретивная память)" +
                "\n2 - Объем жесткого диска\n3 - Операционная система\n4 - Цвет\n5 - Процессор\n6 - Выберите этот пункт" +
                "для начала поиска по вышеуказанным критериям\n");
        while (true) {
            String position = input.nextLine();
            if (position.equals("6")) break;
            if (position.equals("1")) {
                System.out.println("Какой объем оперативной памяти Вас интересует?");
                String ram = input.next();
                criterias.put(position, ram);
                checkNt.setRam(Integer.parseInt(ram));
            }
            if (position.equals("2")) {
                System.out.println("Какой объем жесткого диска Вас интересует?");
                String hdd = input.next();
                criterias.put(position, hdd);
                checkNt.setHdd(Integer.parseInt(hdd));
            }
            if (position.equals("3")) {
                System.out.println("Операционная система windows/linux?");
                String os = input.next();
                criterias.put(position, os);
                checkNt.setOs(os);
            }
            if (position.equals("4")) {
                System.out.println("Цвет? например black");
                String color = input.next();
                criterias.put(position, color);
                checkNt.setColor(color);
            }
            if (position.equals("5")){
                System.out.println("Выбирите модель процессора");
                Cpu model = findCpu();
                criterias.put(position, model.toString());
                checkNt.addCpu(model);
            }
        }
        System.out.println("Вы выбрали следующие критерии");
        System.out.println(checkNt);

        return criterias;
    }

   private static Cpu findCpu(){
        System.out.println("Укажитете фирму производителя(intel,amb,ibm)");
        String name = input.next();
        System.out.println("Частота процессора, например 2.4");
        String cpuFrequency= input.next();
        System.out.println("Количество ядер");
        int coresNumber= input.nextInt();
        Cpu needModel = new Cpu(name,cpuFrequency, coresNumber);
        return needModel;
    }
}