import java.util.Arrays;
import java.util.stream.Stream;

public class Main {


    public static void main(String[] args) {
        Kramer kr = new Kramer();
        Integer determinantHead = 0;
        Integer[][] matrix = {
                {5, 3, -6, 2},
                {7, 4, 4, -5},
                {3, 1, -1, 4},
                {8, 0, -3, -6}
        };

        Integer[] matrixAnswer = {3, 2, 22, -31};

        determinantHead = kr.getDeterminant(matrix);

        for (Integer i = 0; i < matrix.length; i++) {
            Integer[][] matrixLocal = {
                    {5, 3, -6, 2},
                    {7, 4, 4, -5},
                    {3, 1, -1, 4},
                    {8, 0, -3, -6}
            };//Преобразовать в Stram API
            Integer determinantLocal = 0;
            for (Integer j = 0; j < matrixAnswer.length; j++) {
                matrixLocal[j][i] = matrixAnswer[j];
            }
            System.out.println("\n");
            determinantLocal = kr.getDeterminant(matrixLocal);
            System.out.println("X" + i + " = "+ determinantLocal/determinantHead);

        }


    }
}
