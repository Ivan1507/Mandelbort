package sample;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Mandelbort {
    static int BAILOUT = 16;
    static int MAX_ITERATIONS = 1000;

    private static int iterate(float x, float y,int max_i)
    {
        float cr = y-0.5f;
        float ci = x;
        float zi = 0.0f;
        float zr = 0.0f;
        int i = 0;
        while (true) {
            i++;
            float temp = zr * zi;
            float zr2 = zr * zr;
            float zi2 = zi * zi;
            zr = zr2 - zi2 + cr;
            zi = temp + temp + ci;
            if (zi2 + zr2 > BAILOUT)
                return i;
            if (i > max_i)
                return 0;
        }
    }

    public static ArrayList<Long> count()
    {
        Date d1 = new Date();
        int x,y;
        ArrayList<Long> ls=new ArrayList<Long>(){};
        int[] param={1000,10000,100000,1000000};
        for(int i=0;i<param.length;i++) {
            for (y = -39; y < 39; y++) {
                System.out.print("\n");
                for (x = -39; x < 39; x++) {
                    if (iterate(x / 40.0f, y / 40.0f,param[i]) == 0)
                        System.out.print("*");
                    else
                        System.out.print(" ");

                }
            }
            Date d2 = new Date();
            long diff = d2.getTime() - d1.getTime();
            diff/=1000.0f;
            ls.add(diff);

        }
        return ls;

    }
}

