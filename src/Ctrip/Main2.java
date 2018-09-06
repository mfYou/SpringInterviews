package Ctrip;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sn = new Scanner(System.in);
        int num = sn.nextInt();
        int target =  sn.nextInt();
        int[][] array = new int[num][3];
        for (int i=0; i<num; i++){
            String str = sn.nextLine();
            String[] temp = str.split(" ");
            for (int j=0; i<3; i++){
                array[i][j] = Integer.parseInt(temp[i]);
            }
        }

    }
}
