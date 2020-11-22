public class Gauss {
    public Double[] gaussMethod(Double[][] matrix, int k, int n, Double[] resultVector){ //прямой ход
        for(int r = 0;r < k-1; r++){
            for(int i = r+1; i < k; i++){
                for(int j = r+1; j < n; j++){
                    matrix[i][j] += matrix[r][j]*(-matrix[i][r]/matrix[r][r]);
                }
                matrix[i][n] += matrix[r][n]*(-matrix[i][r]/matrix[r][r]);
                matrix[i][r] = 0.0;
            }
        }
        System.out.println();


        for (int i = 0; i < k; i++){
            Double temp = matrix[i][i];
            for (int j = 0; j < n+1; j++){
                matrix[i][j] /= temp;
            }
        }

        for(int i = n-1;i >= 0;i--){
            resultVector[i] = 0.0;
            if(i==(n-1)){
                resultVector[i] = matrix[i][n];
            }
            else{
                for(int j = k-1;j > i;j--){
                    resultVector[i] =resultVector[i] + matrix[i][j]*resultVector[j];
                }
                resultVector[i] = matrix[i][n]-resultVector[i];
            }
        }


        return resultVector;
    }
}
