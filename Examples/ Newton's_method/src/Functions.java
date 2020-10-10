import java.util.Scanner;

public class Functions {

    //(x-1)^2+y^2 = 4
    //sin(x^2)-y = 0

    public Double function1 (Double x, Double y){
        return (Math.pow((x - 1), 2.0) + Math.pow(y, 2.0) - 4);
    }

    public Double function2 (Double x, Double y){
        return (Math.sin(Math.pow(x, 2.0)) - y);
    }

//    public Double dFunction1 (Double x, Double y){
//        return 2 * (x - 1) + 2 * y;
//    }
//
//    public Double dFunction2 (Double x, Double y){
//        return 2 * x * Math.cos(Math.pow(x, 2)) - 1;
//    }

}
