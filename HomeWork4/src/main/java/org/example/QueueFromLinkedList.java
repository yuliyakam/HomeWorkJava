/*Реализуйте очередь с помощью LinkedList со следующими методами:
  enqueue() - помещает элемент в конец очереди, dequeue() - возвращает первый элемент из очереди и удаляет его,
  first() - возвращает первый элемент из очереди, не удаляя.*/
package org.example;

import java.util.Arrays;
import java.util.LinkedList;

public class QueueFromLinkedList {
    public static LinkedList<Integer> list = new LinkedList<>();
    public static void main(String[] args) {
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        enqueue(6);
        System.out.println(Arrays.toString(list.toArray()));
        System.out.println(first());
        System.out.printf("Первый удаленный элемент из очереди %d\n", decueue());
        System.out.println(Arrays.toString(list.toArray()));

    }
    static void enqueue(int element){
        list.addLast(element);
    }
    static int decueue(){
        if (list.size() == 0)
            throw new IllegalStateException("Нельзя доставать элемент из пустого стэка!");
        return list.removeFirst();
    }
    static int first(){
        if (list.size() == 0)
            throw new IllegalStateException("Неозможно отобразить первый элемент, стэк пуст!");
        return list.peekFirst();
    }

}
