package org.example;

import java.util.Scanner;

public class App 
{
    public static int Square(int[][] array){
        int ny = array.length;
        int max_x = array[0][0];
        int max_y = array[0][1];
        int min_x = array[0][0];
        int min_y = array[0][1];
        if(ny == 1){
            return 1;
        }

        for(int i = 0; i<ny; i++){
            int x_fr = array[i][0];
            int y_fr = array[i][1];
            if(x_fr > max_x){
                max_x = x_fr;
            }
            if(x_fr < min_x){
                min_x = x_fr;
            }
            if(y_fr > max_y){
                max_y = y_fr;
            }
            if(y_fr < min_y){
                min_y = y_fr;
            }
        }
        return (max_x-min_x+1)*(max_y-min_y+1);
    }



    public static void main( String[] args )
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите кол-во монстров: ");
        int n = scanner.nextInt();
        int[][] arr = new int[n][2];
        for(int i = 0; i<n; i++){

            System.out.print("x: ");
            int x_1 = scanner.nextInt();
            arr[i][0] = x_1;
            System.out.print("y: ");
            int y_1 = scanner.nextInt();
            arr[i][1] = y_1;
        }


        int minn = 1000;
        for(int i = 0; i<n; i++){
            for(int j = 0; j<2; j++){
                int[][] arr2 = arr.clone();
                arr2[i][j] += 1;
                int k = Square(arr2);
                arr2[i][j] -= 2;
                int m = Square(arr2);
                minn = Math.min(k,minn);
                minn = Math.min(m, minn);
            }
        }
        System.out.print(minn);
    }
}