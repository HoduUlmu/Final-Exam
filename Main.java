import java.util.ArrayList;
import java.util.Random;

import static java.lang.Math.pow;

public class Main {


    public static void main(String[] args) {
        double d = (double)(3)/(double)10000;
        ArrayList<Double> au = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            au.add(i,(i+1)*d);
        }

        for (int i  = 0; i <1000 ; i++) {
            int result = hubo(au);
            int result2 = selection(au, result);
        }


        }

        public static int selection(ArrayList<Double> au,int min){
            ArrayList<Double> selection = new ArrayList<>();

            for (int i = 0; i < 100; i++) {
                selection.add(au.get(min - i));
                selection.add(au.get(min + i));
            }

            ArrayList<Double> selection2 = new ArrayList<>();
            for (int i = 0; i < 50; i++) {
                double sel1 = selection.get((int) (Math.random() * 100));
                double sel2 = selection.get((int) (Math.random() * 100));
                selection2.add(sel1 * ((double) 1 / (double) 4) + sel2 * ((double) 3 / (double) 4));
                selection2.add(sel1 * ((double) 3 / (double) 4) + sel2 * ((double) 1 / (double) 4));
        }
            return hubo(selection2);
    }

public static int hubo(ArrayList<Double> au){
    double a = 1.5;
    double b = 100;

    ArrayList<Double> xu = new ArrayList<>();
    for (int i = 0; i < 100; i++) {
        xu.add(i,Math.random()*(35-20+1)+20);
    }

    Random ran = new Random();
    ArrayList<Double> yu = new ArrayList<>();
    for (int i = 0; i < 100; i++) {
        yu.add(i, a*xu.get(i)+b+ran.nextGaussian()*10);
    }

    ArrayList<Double>  mse = new ArrayList<>();
    double flag=50000;
    int min = 0;
    for (int i = 0; i < au.size(); i++) {
        double sum=0;
        for (int j = 0; j < yu.size(); j++) {
            sum += pow((yu.get(j) - (au.get(i)*xu.get(j)+b)),2);
        }
        mse.add(i,sum);
        if(mse.get(i)<flag){
            flag = mse.get(i);
            min = i;
        }
    }
    System.out.println(au.get(min));
        return min;
    }
    }



