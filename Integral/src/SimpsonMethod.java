public class SimpsonMethod {
    private Integer N = 10000;

    double f (double x) {
        return Math.sin(x);
    }

    double IntSimpson(double a, double b){
        Double h = (b - a) / (N - 1);     // step size

        Double sum = 1.0 / 3.0 * (f(a) + f(b));

        for (Integer i = 1; i < N - 1; i += 2) {
            Double x = a + h * i;
            sum += 4.0 / 3.0 * f(x);
        }

        for (Integer i = 2; i < N - 1; i += 2) {
            Double x = a + h * i;
            sum += 2.0 / 3.0 * f(x);
        }

        return sum * h;
    }

    public Double getInfelicity(Double a, Double b, Integer n, Double h){
        Double infelicity = derivative(a, b);
        return ((b - a) / 2880 * Math.pow(h, 4) * infelicity);
    }

    public Double derivative(Double a, Double b){
        Double p = Math.max(Math.abs(Math.cos(a)), Math.abs(Math.cos(b)));
        return p;
    }
}
