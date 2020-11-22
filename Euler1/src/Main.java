public class Main {
    public static void main(String[] args) {
            Double a = 0.0;
            Double b = 2.0;
            Double h = 0.1;
            Integer n = Integer.valueOf((int) ((b - a) / h));
            Double[] X = new Double[n + 1];
            Double[] Y = new Double[n + 1];
            X[0] = 0.0;
            Y[0] = 0.0;
            System.out.println("x \t \t \t \t \t \tEulerMethod \t \t \t \t \t \t x^3/3");
            System.out.println(X[0] + "\t \t \t" + Y[0] + "\t \t \t" + "---");
            for (Integer i = 1; i < n + 1; i++) {
                X[i] = X[i - 1] + h;
                Y[i] = Y[i - 1] + h * (function(X[i - 1]));
                System.out.println(X[i] + "\t \t \t \t \t \t" + Y[i] + "\t \t \t \t \t \t" + function2(X[i]));
            }
        }

    public static Double function(Double x){
        return x == 0 ? 0 : Math.pow(x, 2);
    }
    public static Double function2 (Double x){
        return Math.pow(x, 3) / 3;
    }
}
