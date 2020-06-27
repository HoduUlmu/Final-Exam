import java.util.ArrayList;
import java.util.Random;

import static java.lang.Math.pow;

public class Main {

    //b는 정해놓은 값이기에 전역변수로 설정해준다.
    public static double b = 100;


    //메인함수에서 데이터 생성을 해주고 selection,crossover,mutation을 실행한다.
    public static void main(String[] args) {

        //데이터셋 생성
        double a = 1.5;
        ArrayList<Double> xu = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            xu.add(i,Math.random()*(35-20+1)+20);
        }

        Random ran = new Random();
        ArrayList<Double> yu = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            yu.add(i, a*xu.get(i)+b+ran.nextGaussian()*4);
        }

        //a,기울기의 후보값들 생성
        double d = (double)(3)/(double)10000;
        ArrayList<Double> au = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            au.add(i,(i+1)*d);
        }

        //selection을 통해 유지할 n개의 후보값 설정
        ArrayList<Double> result = new ArrayList<>();

        //init
        result = selection(xu,yu,au);

        //반복수행
        for (int i = 0; i < 7; i++) {
            result = crossover(result);
            result = selection(xu, yu, result);
        }


        }

        //교차 두 a값의 3/4지점과 1/4지점을 교차연산했다
        public static ArrayList<Double> crossover(ArrayList<Double> au){
        ArrayList<Double> crossover = new ArrayList<>();
            for (int i = 0; i < 50; i++) {
                double sel1 = au.get((int) (Math.random() * 100));
                double sel2 = au.get((int) (Math.random() * 100));
                crossover.add(sel1 * ((double) 1 / (double) 4) + sel2 * ((double) 3 / (double) 4));
                crossover.add(sel1 * ((double) 3 / (double) 4) + sel2 * ((double) 1 / (double) 4));
        }

            return crossover;
    }


//선택 연산
public static ArrayList<Double> selection(ArrayList<Double> xu, ArrayList<Double> yu, ArrayList<Double> au){
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


    ArrayList<Double> selection = new ArrayList<>();
    selection.add(0,au.get(min));
    for (int i = 1; i < 50; i++) {
        selection.add(au.get(min - i));
        selection.add(au.get(min + i));
    }
    selection.add(au.get(min+50));

        return selection;
    }

    public static void mutation(){
        Random r = new Random();
        double p = (double)1/100;
    }
    }



