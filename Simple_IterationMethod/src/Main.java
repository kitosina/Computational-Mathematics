public class Main {
    public static void main(String[] args) {
        CalculationFunction calculationFunction = new CalculationFunction();
        final Double EPS = 1e-24;
        Double x = 1.0;
        double rez; int iter = 0;
        do {
            rez = x;
            x = calculationFunction.function(x);
            iter++;
            System.out.println("Iteration: " + iter + "\t|Approximation: " + x + "\t|Difference Module: " + Math.abs(rez - x));
        } while (Math.abs(rez - x) > EPS && iter<20000);
        System.out.println("Result: "+ x);
    }
}
