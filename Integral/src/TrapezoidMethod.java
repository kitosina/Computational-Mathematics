public class TrapezoidMethod {

    public  double integralTrapec(Double a, Double b){
        Double area = 0.0;
        Double h = 0.01;
        for(int i=0; i<(b-a)/h; i++){
            area+= h* (0.5*(func(a+i*h)+func(a+(i+1)*h)));
        }
        return area;
    }

    private static Double func(Double x) {
        return Math.sin(x);
    }

    public Double getInfelicity(Double a, Double b, int n){
        Double infelicity = derivative(a,b);
        return (Math.pow((b - a), 3.0)/(12 * Math.pow(n, 2) * infelicity));
    }
    public Double derivative(Double a, Double b){
        Double p = Math.max(-Math.cos(a), -Math.cos(b));
        return p;
    }

}
