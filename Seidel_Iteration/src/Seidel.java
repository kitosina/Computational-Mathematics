
public class Seidel {

    private Integer iteration = 0;
    public Double[] seidelMethod(Double[][] matrix, int n,Double[] result){
        boolean flag = true;
        Double[] function = new Double[n];
        function = startApproximation(function,n);
        int k = 0;
        do {
            function = getFunction(function,result,n,matrix);
            iteration++;
            flag = checkValue(flag,result,function,n);
            k++;
        } while(flag && k < 200);
        return result;
    }

    public Double[] dubl(Double[] result, Double[] function, int n){
        for( int i = 0; i< n; i++){
            result[i] = function[i];
        }
        return result;
    }

    private Double[] startApproximation(Double[] result, int n){
        for(int i = 0; i < n;i++){
            result[i]=0.0;
        }

        return result;
    }

    private Double[] getFunction(Double[] function,Double[] result,int n, Double[][] matrix){
        result = dubl(result,function,n);
        Double s;
        for(int i = 0; i < n;i++){
            s=0.0;
            for(int j = 0; j < n;j++){
                if(i != j){

                    s += function[j]*matrix[i][j];

                }
            }
            function[i] = matrix[i][n] - s;
            System.out.println("Iteration: " + iteration + "\tResult = " + function[i]);
            iteration++;
        }
        return function;
    }

    private boolean checkValue(boolean flag,Double[] result, Double[] function, int n){
        Double norm = 0.0;
        Double eps = 0.0000000000000001;
        for (int i = 0; i < n;i++){
            norm = Math.max(norm,Math.abs(result[i]-function[i]));
        }
        if(norm < eps){
            flag = false;
        }
        return flag;
    }

}
