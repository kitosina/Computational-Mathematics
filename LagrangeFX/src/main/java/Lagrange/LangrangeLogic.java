package Lagrange;

public class LangrangeLogic {

    public Double getFunction(Double x) {
        return (Math.tan(x));   //вычесление tg(x)
    }

    public Double getStandardDeviation(Double[] x, int num) {
        Double Sum = 0.0;
        Double dev = 0.0;
        for(int i = 0; i < num; i++){
            Sum += x[i];
        }
        for(int i = 0; i < num; i++){
            dev += Math.pow(x[i] - (Sum/num), 2);
        }
        return (Math.sqrt(dev/(num-1)));
    }

    public Double lagrangePolynom(Double x, Double x0, Double h, Integer num, Double f) {
        Double L = 0.0;
        Double l;

        for(Integer i = 0;i < num; i++){
            l = 1.0;
            for(Integer j = 0;j < num; j++){
                if(i.equals(j) == false){
                    l *= (x-(x0 + j * h)) / ((x0 + h * i) - (x0 + j * h));
                }
            }
            L += f*l;
        }
        return L;
    }
}
