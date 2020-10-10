public class Main {
    public static void main(String[] args) {
        final Matrix matrix = new Matrix();
        final Functions functions = new Functions();

        final Double EPS = 0.91;
        final Double[][] matrixJacobian = new Double[2][2];
        Double[][] matrixInversion = null;
        Double[] resultFunction = new Double[2];
        Double[] multiplyMatrix = new Double[2];

        Double approximationX1 = 2.6;
//        Double approximationX2 = 8.0;
        Double approximationY1 = 1.0;
//        Double approximationY2 = 2.0;




        for(Integer i = 0; i < 2; i++) {
            for (Integer j = 0; j < 2; j++) {
                if (i == 0 && j == 1) {
                    matrixJacobian[i][j] = matrix.getDerivative(approximationY1, i, j);
                } else matrixJacobian[i][j] = matrix.getDerivative(approximationX1, i, j);
            }
        }

        matrixInversion = matrix.getInversion(matrixJacobian);

//        for(Integer i = 0; i < 2; i++) {
//            for (Integer j = 0; j < 2; j++) {
//                System.out.println(Float.parseFloat(String.valueOf(matrixJacobian[i][j])) + "\n");
//                System.out.println(Float.parseFloat(String.valueOf(matrixInversion[i][j])) + "\n");
//            }
//        }

        resultFunction[0] = functions.function1(approximationX1, approximationY1);
        resultFunction[1] = functions.function2(approximationX1, approximationY1);

        for(;;) {
            multiplyMatrix = matrix.getMultiplyMatrix(resultFunction, matrixInversion);
            if (multiplyMatrix[0] > multiplyMatrix[1]) {
                if(Math.abs(multiplyMatrix[0]) < EPS) break;
            } else {
                if (Math.abs(multiplyMatrix[1]) < EPS) break;
            }
            resultFunction[0] = approximationX1 - multiplyMatrix[0];
            resultFunction[1] = approximationY1 - multiplyMatrix[1];
            approximationX1 = functions.function1(resultFunction[0], resultFunction[1]);
            approximationY1 = functions.function2(resultFunction[0], resultFunction[1]);
            resultFunction[0] = approximationX1;
            resultFunction[1] = approximationY1;

            for(Integer i = 0; i < 2; i++) {
                for (Integer j = 0; j < 2; j++) {
                    if (i == 0 && j == 1) {
                        matrixJacobian[i][j] = matrix.getDerivative(approximationY1, i, j);
                    } else matrixJacobian[i][j] = matrix.getDerivative(approximationX1, i, j);
                }
            }

            matrixInversion = matrix.getInversion(matrixJacobian);
//
        }
//
        System.out.println(Float.parseFloat(String.valueOf(multiplyMatrix[0])));
        System.out.println(Float.parseFloat(String.valueOf(multiplyMatrix[1])));

    }
}
