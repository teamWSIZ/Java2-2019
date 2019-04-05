//package wsi.wykop;

import java.util.Scanner;

public class B {
    public static int isPossible(int n, int m) {
        int holder = m / n;
        int twos = 0;
        int thress = 0;
        if (m % n == 0) {
            while (holder % 2 == 0) {
                twos++;
                holder = holder / 2;
            }
            while (holder % 3 == 0) {
                thress++;
                holder = holder / 3;
            }
        } else {
            return -1;
        }
        return twos + thress;
    }


    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int m = s.nextInt();


        int x = isPossible(n,m);
        System.out.println(x);

    }
}
