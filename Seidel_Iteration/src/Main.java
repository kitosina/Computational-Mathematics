public class Main {
    public static void main(String[] args) {
        Seidel seidel = new Seidel();
        Iteration iteration = new Iteration();
        int n = 3; //число неизвестных переменных
        int k = 3; //число уравнений в системе
        Double[][] matrix = {
                {10.0, 1.0, 1.0, 12.0},
                {2.0, 10.0, 1.0, 13.0},
                {2.0, 2.0, 10.0, 14.0}
        };
        Double[] result = new Double[n];

        for (int i = 0; i < k; i++){
            Double temp = matrix[i][i];
            for (int j = 0; j < n+1; j++){
                matrix[i][j] /= temp;
            }
        }

        System.out.println("\nSeidel result:");
        result = seidel.seidelMethod(matrix,n,result);
        System.out.println("\nSeidel Корни:");
        for(int i = 0; i < n; i++){
            System.out.println(Math.ceil(result[i]));
        }

        System.out.println("\nIteration result:");
        result = iteration.iterationMethod(matrix,n,result);
        System.out.println("\nIteration Корни:");
        for(int i = 0; i < n; i++){
            System.out.println(Math.ceil(result[i]));
        }
    }
}
