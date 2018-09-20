package Baicizhan;

import java.util.Scanner;

/**
 * 给定n个点，求覆盖n个点最小的多边形面积
 */

public class Main4 {

    public static void main(String args[])
    {
        Scanner sn = new Scanner(System.in);
        int pointNum = sn.nextInt();
        point[] vertex = new point[pointNum];
        for(int i=0;i<pointNum;i++){
            vertex[i]= new point();
        }
        for(int i=0;i<pointNum;i++){
            vertex[i].x = sn.nextInt();
            vertex[i].y = sn.nextInt();
        }
        Double res = Math.floor(caculate(vertex,pointNum));
        int result = res.intValue();
        System.out.println(result);
    }

    private static float caculate(point vertex[],int pointNum)
    {
        int i=0;
        float temp=0;
        for(;i<pointNum-1;i++)
        {
            temp+=(vertex[i].x-vertex[i+1].x)*(vertex[i].y+vertex[i+1].y);
        }
        temp+=(vertex[i].x-vertex[0].x)*(vertex[i].y+vertex[0].y);
        return temp/2;
    }

    static class point{
        float x;
        float y;
        point(){
            this.x=0;
            this.y=0;
        }
    }
}
