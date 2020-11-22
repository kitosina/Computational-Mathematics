package Lagrange;

import java.text.DecimalFormat;

public class LagrangeCalculations {
    private DecimalFormat formatDouble = new DecimalFormat("###.####");//Double format
    private LangrangeLogic langrangeLogic = new LangrangeLogic();
    Integer quantityPoint = 30;
    Double[] result = new Double[quantityPoint];
    Double[] polynomial = new Double[quantityPoint];
    Double[] xPolimomial = new Double[quantityPoint];
    Double[] xResult = new Double[quantityPoint];

    public void calculationValuesLagrange() {
        Double xBegin = -4.5;
        Double step = 0.1;
//        Double stepPolinom = 0.25;
        Double deviation1, deviation2;

        for (Integer i = 0; i < quantityPoint; i++) {
            result[i] = langrangeLogic.getFunction((-1.5 + i * step));
            xResult[i] = -1.5 + i * step;

            polynomial[i] = langrangeLogic.lagrangePolynom(-1.51, xBegin, 0.1, quantityPoint, result[i]);
            xPolimomial[i] = -1.52 + i * step;
            System.out.println("Function Result: " + formatDouble.format(result[i]) + "\t Polynomial: " + formatDouble.format(polynomial[i]) + "\t If x = " + xResult[i]);
        }

        deviation1 = langrangeLogic.getStandardDeviation(result, quantityPoint);
        deviation2 = langrangeLogic.getStandardDeviation(polynomial, quantityPoint);

        System.out.println("\nDeviation1 = " + deviation1 + "\nDeviation2 = " + deviation2);
    }

    public Double[] getPolynomial() {
        return polynomial;
    }

    public Double[] getResult() {
        return result;
    }

    public Double[] getXPolimomial() {
        return xPolimomial;
    }

    public Double[] getxResult() {
        return xResult;
    }

    public Integer getQuantityPoint() {
        return quantityPoint;
    }
}
