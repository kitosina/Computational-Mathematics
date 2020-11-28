public class Iteration {
    public Double[] iterationMethod(Double[][] matrix, int n, Double[] result){
        boolean flag = true;
        Double[] function = new Double[n];
        function = startApproximation(function,n);
        int k = 0;
        int iteration = 0;
        do {
            result = getFunction(function,result,n,matrix);
            flag = checkValue(flag, result,function,n);
            if(flag){
                for(int i = 0;i < n;i++){
                    function[i]=result[i];
                    System.out.println("Iteration: " + iteration + "\tResult= " + function[i]);
                    iteration++;
                }
            }
        } while(flag && k < 200);

        return result;
    }

    private Double[] startApproximation(Double[] result, int n){
        for(int i = 0; i < n;i++){
            result[i]=0.0;
        }

        return result;
    }

    private Double[] getFunction(Double[] function, Double[] result,int n, Double[][] matrix){
        for(int i = 0; i < n;i++){
            result[i] = 0.0;
            for(int j = 0; j < n;j++){
                if(i != j){
                    result[i] += function[j]*matrix[i][j];
                }
            }
            result[i] = matrix[i][n] - result[i];
        }
        return result;
    }

    private boolean checkValue(boolean flag,Double[] result, Double[] function, int n){
        Double norm=0.0;
        Double eps=0.0000000000000001;
        for (int i = 0; i < n;i++){
            norm = Math.max(norm,Math.abs(result[i]-function[i]));
        }
        if(norm<eps){
            flag = false;
        }
        return flag;
    }
}
