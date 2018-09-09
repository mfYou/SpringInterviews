package ByteDance;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sn = new Scanner(System.in);
        int m = sn.nextInt();
        int[][] matrix = new int[m][m];
        for (int i=0; i<m;i++){
            for (int j=0; j<m; j++){
                matrix[i][j] = sn.nextInt();
            }
        }
        System.out.println(getNum(matrix));
    }

    static int getNum(int[][] matrix){
        int x=matrix.length,y=matrix.length;
        for (int i=0; i<matrix.length; i++){
            for (int j =0; j<matrix.length; j++){
                if (matrix[i][j]!=0){
                    x=i;
                    y=j;
                }
            }
        }
        if (x==matrix.length){
            return 0;
        }else {
            clearMatrix(x,y,matrix);
            return 1+getNum(matrix);
        }
    }

    static void clearMatrix(int i, int j, int[][] matrix){
        if (i<0||j<0||i>=matrix.length||j>=matrix.length) return;
        matrix[i][j] =0;
        for (int m=i-1; m>=0; m--){
            if (matrix[m][j]==0){
                break;
            }else {
                matrix[m][j]=0;
                clearMatrix(m, j, matrix);
            }
        }
        for (int m=i+1; m<matrix.length; m++){
            if (matrix[m][j]==0){
                break;
            }else {
                clearMatrix(m, j, matrix);
                matrix[m][j]=0;
            }
        }
        for (int m=j-1; m>=0; m--){
            if (matrix[i][m]==0){
                break;
            }else {
                matrix[i][m]=0;
                clearMatrix(i, m, matrix);
            }
        }
        for (int m=j+1; m<matrix.length; m++){
            if (matrix[i][m]==0){
                break;
            }else {
                matrix[i][m]=0;
                clearMatrix(i, m, matrix);
            }
        }
    }
}
