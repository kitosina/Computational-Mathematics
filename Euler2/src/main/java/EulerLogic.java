public class EulerLogic {
    Double a = 0.0;
    Double b = 10.0;
    Double h = 0.001;
    Integer n = Integer.valueOf((int) ((b - a)/h));
    Double coef = -4 * Math.pow(Math.PI,2.0);
    Double[] X = new Double[n+1];
    Double[] F = new Double[n+1];
    Double[] Z = new Double[n+1];

    public void Euler() {
        X[0] = 0.0;
        F[0] = 0.0;
        Z[0] = 1.0;
        System.out.println("x \t \t Y1 \t \t Y2 \t \t F");
        System.out.println(X[0] + "\t \t \t" + Z[0] + "\t \t \t" + F[0]);
        for (Integer i = 1; i < n+1; i++) {
            X[i] = X[i-1] + h;
            Z[i] = h * coef * (0.005 * Z[i-1] + F[i-1]) + Z[i-1];
            F[i] = Z[i-1] * h + F[i-1];
            System.out.println(X[i] + "\t \t \t" + Z[i] + "\t \t \t" + F[i]);
        }
    }

    public Integer getN() {
        return n;
    }

    public Double[] getX() {
        return X;
    }

    public Double[] getF() {
        return F;
    }
}
