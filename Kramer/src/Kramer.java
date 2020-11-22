import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Kramer {

    public Integer getDeterminant(Integer[][] matrix) {
        Integer determinant = 0;
        Integer coefficient = 0;


        List<Integer> minor = new ArrayList<>();
        for(Integer i = 0; i < 4; i++) {
            minor.removeAll(minor);
            for(Integer j = 1; j < 4; j++) {
                for(Integer g = 0; g < 4; g++) {
                    coefficient = matrix[0][i];
                    if(i != g) {
                        minor.add(matrix[j][g]);
                    }
                }
            }

            Integer xod = i + 1;
            if (xod == 1) determinant = determinant + getDeterminantMini(coefficient, minor);
            if (xod == 2) determinant = determinant - getDeterminantMini(coefficient, minor);
            if (xod == 3) determinant = determinant + getDeterminantMini(coefficient, minor);
            if (xod == 4) determinant = determinant - getDeterminantMini(coefficient, minor);
//            if (xod/2 == 0) {
//                System.out.println(getDeterminantMini(coefficient, minor));
//                determinant = determinant + getDeterminantMini(coefficient, minor);
//            }
//            else {
//                System.out.println(getDeterminantMini(coefficient, minor));
//                determinant = determinant - getDeterminantMini(coefficient, minor);
//            }

        }
        return determinant;
    }

    public Integer getDeterminantMini(Integer coefficient, List<Integer> minor) {

        Integer determinant = (minor.get(0) * minor.get(4) * minor.get(8) + minor.get(1) * minor.get(5) * minor.get(6) + minor.get(2) * minor.get(3) * minor.get(7))
                - (minor.get(2) * minor.get(4) * minor.get(6) + minor.get(1) * minor.get(3) * minor.get(8) +
                minor.get(0) * minor.get(5) * minor.get(7));
        return determinant * coefficient;
    }


}
