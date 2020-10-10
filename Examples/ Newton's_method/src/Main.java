public class Main {
    public static void main(String[] args) {
        final Matrix matrix = new Matrix();
        final Functions functions = new Functions();

        final Double EPS = 1e-5;
        Double[][] matrixJacobian = new Double[2][2];
        Double[][] matrixInversion;
        Double[] resultFunction = new Double[2];
        Double[] multiplyMatrix;
//        Double approximationX1 = -0.7;
//        Double approximationY1 = 0.7;
        Double approximationX1 = 2.8;
        Double approximationY1 = 1.0;


        do {
            for(int i = 0; i < 2; i++) {
                for (int j = 0; j < 2; j++) {
                    if (i == 0 && j == 1) {
                        matrixJacobian[i][j] = matrix.getDerivative(approximationY1, i, j);
                    } else matrixJacobian[i][j] = matrix.getDerivative(approximationX1, i, j);
                }
            }

            matrixInversion = matrix.getInversion(matrixJacobian);

            resultFunction[0] = functions.function1(approximationX1, approximationY1);
            resultFunction[1] = functions.function2(approximationX1, approximationY1);

            multiplyMatrix = matrix.getMultiplyMatrix(resultFunction, matrixInversion);

            approximationX1 -= multiplyMatrix[0];
            approximationY1 -= multiplyMatrix[1];
        } while (Math.abs(multiplyMatrix[0]) < EPS && Math.abs(multiplyMatrix[1]) < EPS);

        System.out.println("X = " + approximationX1);
        System.out.println("Y = " + approximationY1);
    }

}