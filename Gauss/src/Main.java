public class Main {
    public static void main(String[] args) {
        Gauss gauss = new Gauss();
        int n = 4;
        int k = 4;
        Double[][] matrix =  {
                {5.0, 3.0, -6.0, 2.0, 3.0},
                {7.0, 4.0, 4.0, -5.0, 2.0},
                {3.0, 1.0, -1.0, 4.0, 22.0},
                {8.0, 0.0, -3.0, -6.0, -31.0}
        };
        Double[] result = new Double[n];


        result = gauss.gaussMethod(matrix,k,n,result);
        System.out.println("\n Корни:");
        for(int i = 0; i < n;i++){
            System.out.format("%f",result[i]);
            System.out.println();
        }
    }
}
