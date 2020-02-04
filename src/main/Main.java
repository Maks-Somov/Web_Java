package main;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner sc = new Scanner(System.in);
        int Arr[] = new int[10];
        for(int i=0;i<Arr.length;i++){
            Arr[i]=(int)(Math.random()*100);
            System.out.println(i+" : "+Arr[i]);
        }
        System.out.println("  Hello maks\n"+"if you want find min press 1.\n"+"if max - press 2");
        int number = sc.nextInt();
        int min = Arr[0];
        int max = Arr[0];
        switch (number){
            case 1: for(int i=0;i<Arr.length;i++){
            if(min>Arr[i]){
                min = Arr[i];
                    }
                }
        System.out.println(min);
            break;
            case 2: for(int i=0;i<Arr.length;i++){
            if(max<Arr[i]){
                max = Arr[i];
                    }
                }
        System.out.println(max);
        break;
            default:
System.out.println("incorrect number!!");
        }
    }
}
