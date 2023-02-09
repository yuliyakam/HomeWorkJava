package org.example;

public class QueenMove {
    public static void main(String[] args) {
        int[][] field = new int[8][8];
        go(1, field, 2, 3);
    }
    private static void go(int number, int[][] field, int x, int y){
//условие при котором выходим за рамки поля
        if (x<0 || y<0 || x>=field[0].length || y>= field.length)
            return;
//условие что место уже занято
        if (field[y][x] != 0)
            return;
        field[y][x] = number;
        for (int i = 0; i < field.length; i++) {

            field[y][i] = number;
            field[i][x] = number;

        }

        print(field);

        if (number == field.length){
            print(field);
            System.exit(0);
        }

//        go(number+1, field, x+1,y+1);
//        go(number+1, field, x+2,y+2);
//        go(number+1, field, x+3,y+3);
//        go(number+1, field, x+4,y+4);
//        go(number+1, field, x+5,y+5);
//        go(number+1, field, x+6,y+6);
//        go(number+1, field, x+7,y+7);

        field[y][x] = 0;
    }
    private static void print(int[][] field){
        for (int[] array:field){
            for(int elem: array){
                System.out.printf("%4d", elem);
            }
            System.out.printf("\n");
        }//по строкам
    }
}
