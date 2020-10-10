import java.util.Objects;

public class Matrix {

    private Double getDerivative11(Double x) {
        return 2.0 * (x - 1.0);
    }

    private Double getDerivative12(Double y) {
        return 2.0 * y;
    }

    private Double getDerivative21(Double x) {
        return 2.0 * x * Math.cos(Math.pow(x, 2));
    }

    private Double getDerivative22() {
        return -1.0;
    }

    public Double getDerivative(Double quantity, Integer str, Integer stl) {
        Double result = null;
        switch (str) {
            case 0:
                switch (stl) {
                    case 0:
                        result = this.getDerivative11(quantity);
                        break;
                    case 1:
                        result = this.getDerivative12(quantity);
                        break;
                    default:
                        System.out.println("Error Switch");
                        break;
                }
                break;
            case 1:
                switch (stl) {
                    case 0:
                        result = this.getDerivative21(quantity);
                        break;
                    case 1:
                        result = this.getDerivative22();
                        break;
                    default:
                        System.out.println("Error Switch");
                }
                break;
            default:
                System.out.println("Error Switch");
        }
        return result;
    }

    public Double[][] getInversion(Double[][] matrix) {
        Double temp = null;
        Double[][] matrixTemp = new Double[2][2];
        Double[][] matrixInversion = new Double[2][2];

        for(Integer i = 0; i < 2; i++) {
            for (Integer j = 0; j < 2; j++) {
                matrixTemp[i][j] = matrix[i][j];
            }
        }

        for (int i = 0; i < 2; i++)
            for (int j = 0; j < 2; j++)
            {
                matrixInversion[i][j] = 0.0;

                if (i == j)
                    matrixInversion[i][j] = 1.0;
            }

        for (int k = 0; k < 2; k++)
        {
            temp = matrixTemp[k][k];

            for (int j = 0; j < 2; j++)
            {
                matrixTemp[k][j] /= temp;
                matrixInversion[k][j] /= temp;
            }

            for (int i = k + 1; i < 2; i++)
            {
                temp = matrixTemp[i][k];

                for (int j = 0; j < 2; j++)
                {
                    matrixTemp[i][j] -= matrixTemp[k][j] * temp;
                    matrixInversion[i][j] -= matrixInversion[k][j] * temp;
                }
            }
        }

        for (int k = 2 - 1; k > 0; k--)
        {
            for (int i = k - 1; i >= 0; i--)
            {
                temp = matrixTemp[i][k];

                for (int j = 0; j < 2; j++)
                {
                    matrixTemp[i][j] -= matrixTemp[k][j] * temp;
                    matrixInversion[i][j] -= matrixInversion[k][j] * temp;
                }
            }
        }

        for (int i = 0; i < 2; i++)
            for (int j = 0; j < 2; j++)
                matrixTemp[i][j] = matrixInversion[i][j];

            return matrixInversion;
    }

    public Double[] getMultiplyMatrix(Double[] resultFunction, Double[][] matrixInversion) {
        Double[] multiplyMatrix = new Double[2];

        multiplyMatrix[0] = matrixInversion[0][0] * resultFunction[0] + matrixInversion[0][1] * resultFunction[1];
        multiplyMatrix[1] = matrixInversion[1][0] * resultFunction[0] + matrixInversion[1][1] * resultFunction[1];


        return multiplyMatrix;
    }


}
