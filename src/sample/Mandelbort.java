package sample;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

public class Mandelbort {
    public static boolean[][] Mas=new boolean[][]{};
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
            if (zi2 + zr2 > BAILOUT) {
                return i;
            }
            if(i >max_i){
                return 0;
            }
        }
    }
public static void main(String[] args) throws  InterruptedException{

        ArrayList<Long> as=count();
        for(int i=0;i<4;i++)
            System.out.println(as.get(i));


}
    public static ArrayList<Long> count() throws InterruptedException {
        long border = 0;
        long empty = 0;
        long inside = 0;
        int[] param = {1000, 10000, 100000, 1000_000};
        boolean [][] mas=new boolean[80][80];
        int x, y;
        ArrayList<Long> ls = new ArrayList<Long>() {
        };
        ArrayList<Long> ans = new ArrayList<>();
        int c = 0;
        for (int i = 0; i < param.length; i++){
            long m = System.currentTimeMillis();
            for (y = -39; y < 39; y++) {
                System.out.print("\n");
                for (x = -39; x < 39; x++) {
                  if (iterate(x / 40.0f, y / 40.0f, param[i]) == 0) {
                        System.out.print("*");
                       mas[y+40][x+40]=true;
                    } else {
                        System.out.print(" ");
                        mas[y+40][x+40]=false;
                    }
                }

            }
        long diff = System.currentTimeMillis() - m;
        ls.add(diff);
    }
       Mas=mas;
        return ls;
    }

    public static long measure(){
        long l=System.currentTimeMillis();

        return System.currentTimeMillis()-l;
    }
}

